package wannabit.io.cosmostaion.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import com.google.android.gms.common.util.CollectionUtils;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;
import com.trustwallet.walletconnect.WCClient;
import com.trustwallet.walletconnect.models.WCAccount;
import com.trustwallet.walletconnect.models.WCPeerMeta;
import com.trustwallet.walletconnect.models.keplr.WCKeplrWallet;
import com.trustwallet.walletconnect.models.session.WCSession;

import org.bitcoinj.core.ECKey;
import org.bitcoinj.crypto.DeterministicKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import wannabit.io.cosmostaion.R;
import wannabit.io.cosmostaion.base.BaseActivity;
import wannabit.io.cosmostaion.base.BaseChain;
import wannabit.io.cosmostaion.base.BaseConstant;
import wannabit.io.cosmostaion.cosmos.MsgGenerator;
import wannabit.io.cosmostaion.crypto.CryptoHelper;
import wannabit.io.cosmostaion.dao.Account;
import wannabit.io.cosmostaion.dialog.Dialog_Empty_Chain;
import wannabit.io.cosmostaion.dialog.Dialog_WC_Account;
import wannabit.io.cosmostaion.dialog.Dialog_Wc_Raw_Data;
import wannabit.io.cosmostaion.model.StdSignMsg;
import wannabit.io.cosmostaion.model.type.Msg;
import wannabit.io.cosmostaion.model.type.Signature;
import wannabit.io.cosmostaion.network.req.ReqBroadCast;
import wannabit.io.cosmostaion.utils.WDp;
import wannabit.io.cosmostaion.utils.WKey;
import wannabit.io.cosmostaion.utils.WLog;
import wannabit.io.cosmostaion.utils.WUtil;

public class ConnectWalletActivity extends BaseActivity implements View.OnClickListener {
    public final static int TYPE_TRUST_WALLET = 1;
    public final static int TYPE_KEPLR_WALLET = 2;

    private RelativeLayout mWcLayer, mLoadingLayer;
    private LinearLayout mEmptyLayer;
    private CardView mWcCardView;
    private ImageView mWcImg;
    private TextView mWcName, mWcUrl, mWcAccount;
    private Button mBtnDisconnect;
    private Dialog_Wc_Raw_Data mDialogWcRawData;
    private Dialog_Empty_Chain mDialogEmptyChain;
    private Dialog_WC_Account mDialogWcAccount;

    private String mWcURL;
    private WCClient wcClient;
    private WCSession wcSession;
    private WCPeerMeta mWcPeerMeta;
    private JsonArray mjsonArray;
    private Boolean isDeepLink = false;
    private Account currentAccount = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_wallet);
        initView();

        if (getIntent().getData() != null && "cosmostation".equals(getIntent().getData().getScheme())) {
            isDeepLink = true;
            mWcURL = getIntent().getData().getQuery();
        } else {
            mWcURL = getIntent().getStringExtra("wcUrl");
        }

        if (isDeepLink) {
            if (!getBaseDao().onHasPassword()) {
                mEmptyLayer.setVisibility(View.VISIBLE);
                mLoadingLayer.setVisibility(View.GONE);
                mBtnDisconnect.setText("Dismiss");
                return;
            } else {
                if (Collections2.filter(getBaseDao().onSelectAccounts(), account -> account.hasPrivateKey).isEmpty()) {
                    Toast.makeText(this, "No Private Key", Toast.LENGTH_SHORT).show();
                    finish();
                    return;
                }
                Intent intent = new Intent(this, PasswordCheckActivity.class);
                intent.putExtra(BaseConstant.CONST_PW_PURPOSE, BaseConstant.CONST_PW_SIMPLE_CHECK);
                startActivityForResult(intent, BaseConstant.CONST_PW_SIMPLE_CHECK);
                overridePendingTransition(R.anim.slide_in_bottom, R.anim.fade_out);
            }
        } else {
            currentAccount = mAccount;
            getKey();
            loadInfo();
            initWalletConnect();
        }
    }

    private void loadInfo() {
        currentAccount = getBaseDao().onSelectAccount(getBaseDao().getLastUser());
        mBaseChain = BaseChain.getChain(currentAccount.baseChain);
        mWcCardView.setCardBackgroundColor(WDp.getChainBgColor(this, mBaseChain));
    }

    private void initView() {
        mWcLayer = findViewById(R.id.wc_layer);
        mLoadingLayer = findViewById(R.id.loading_layer);
        mEmptyLayer = findViewById(R.id.empty_account);
        mWcCardView = findViewById(R.id.wc_card);
        mWcImg = findViewById(R.id.wc_img);
        mWcName = findViewById(R.id.wc_name);
        mWcUrl = findViewById(R.id.wc_url);
        mWcAccount = findViewById(R.id.wc_address);
        mBtnDisconnect = findViewById(R.id.btn_disconnect);
        mBtnDisconnect.setOnClickListener(this);

        setSupportActionBar(findViewById(R.id.tool_bar));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initWalletConnect() {
        OkHttpClient client = new OkHttpClient.Builder().pingInterval(100000, TimeUnit.MILLISECONDS).build();
        wcClient = new WCClient(new GsonBuilder(), client);
        WCPeerMeta meta = new WCPeerMeta("", "", "", Lists.newArrayList());
        wcSession = WCSession.Companion.from(mWcURL);
        wcClient.connect(wcSession, meta, UUID.randomUUID().toString(), null);
        wcClient.setOnGetAccounts(id -> {
            wcClient.approveRequest(id, makeWCAccount());
            return null;
        });
        wcClient.setOnDisconnect((code, reason) -> {
            runOnUiThread(() -> {
                Toast.makeText(getBaseContext(), getString(R.string.str_wc_disconnected), Toast.LENGTH_SHORT).show();
                if (!isFinishing()) onBackPressed();
            });
            return null;
        });
        wcClient.setOnSessionRequest((id, wcPeerMeta) -> {
            runOnUiThread(() -> {
                if (!isDeepLink) {
                    onInitView(wcPeerMeta);
                    wcClient.approveSession(Lists.newArrayList(currentAccount.address), 1);
                } else {
                    mWcPeerMeta = wcPeerMeta;
                    wcClient.approveSession(Lists.newArrayList(), 1);
                }
            });
            return null;
        });
        wcClient.setOnSignTransaction((id, wcSignTransaction) -> {
            runOnUiThread(() -> onShowRawDataDialog(processTrust(id, wcSignTransaction.getTransaction())));
            return null;
        });
        wcClient.setOnKeplrEnable((id, strings) -> {
            runOnUiThread(() -> onKeplrEnable(id, strings));
            return null;
        });
        wcClient.setOnKeplrGetKey((id, strings) -> {
            runOnUiThread(() -> onKeplrGetKey(id, strings));
            return null;
        });
        wcClient.setOnKeplrSignAmino((id, jsonArray) -> {
            mjsonArray = jsonArray;
            runOnUiThread(() -> onShowRawDataDialog(processKeplr(id)));
            return null;
        });
    }

    private ECKey getKey() {
        ECKey mEcKey;
        if (currentAccount.fromMnemonic) {
            String entropy = CryptoHelper.doDecryptData(getString(R.string.key_mnemonic) + currentAccount.uuid, currentAccount.resource, currentAccount.spec);
            DeterministicKey deterministicKey = WKey.getKeyWithPathfromEntropy(currentAccount, entropy);
            mEcKey = ECKey.fromPrivate(new BigInteger(deterministicKey.getPrivateKeyAsHex(), 16));
        } else {
            String privateKey = CryptoHelper.doDecryptData(getString(R.string.key_private) + currentAccount.uuid, currentAccount.resource, currentAccount.spec);
            mEcKey = ECKey.fromPrivate(new BigInteger(privateKey, 16));
        }
        return mEcKey;
    }

    private List<WCAccount> makeWCAccount() {
        if (mBaseChain.equals(BaseChain.KAVA_MAIN)) {
            return Lists.newArrayList(new WCAccount(459, currentAccount.address));
        }
        return Lists.newArrayList();
    }

    public void approveTrustRequest(long id, String wcSignTransaction) {
        WLog.w("Trust Request");
        StdSignMsg wcStdSignMsg = new Gson().fromJson(wcSignTransaction, StdSignMsg.class);
        try {
            JSONObject transactionJson = new JSONObject(wcSignTransaction);
            JSONArray messagesArray = transactionJson.getJSONArray("messages");
            ArrayList<Msg> msgList = Lists.newArrayList();
            for (int i = 0; i < messagesArray.length(); i++) {
                JSONObject rawMessage = messagesArray.getJSONObject(0).getJSONObject("rawJsonMessage");
                Msg msgModel = new Msg();
                msgModel.type = rawMessage.getString("type");
                msgModel.value = new Gson().fromJson(rawMessage.getString("value"), Msg.Value.class);
                msgModel.value.amount = msgModel.value.getCoins();
                msgList.add(msgModel);
            }
            wcStdSignMsg.msgs = msgList;

            Account account = new Account();
            account.accountNumber = Integer.parseInt(wcStdSignMsg.account_number);
            account.sequenceNumber = Integer.parseInt(wcStdSignMsg.sequence);
            ReqBroadCast tx = MsgGenerator.getWcTrustBroadcaseReq(account, msgList, wcStdSignMsg.fee, wcStdSignMsg.memo, getKey(), wcStdSignMsg.chain_id);
            Gson Presenter = new GsonBuilder().disableHtmlEscaping().create();
            String result = Presenter.toJson(tx);
            wcClient.approveRequest(id, result);
            Toast.makeText(getBaseContext(), getString(R.string.str_wc_request_responsed), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void approveKeplrRequest(long id) {
        WLog.w("Keplr Request");
        SignModel signModel = new SignModel(mjsonArray.get(2).getAsJsonObject(), getKey());
        wcClient.approveRequest(id, Lists.newArrayList(signModel));
        Toast.makeText(getBaseContext(), getString(R.string.str_wc_request_responsed), Toast.LENGTH_SHORT).show();

        if (isDeepLink) {
            moveTaskToBack(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (wcSession != null && wcClient.getSession() != null && wcClient.isConnected()) {
            wcClient.killSession();
        } else if (wcClient != null) {
            wcClient.disconnect();
        }
    }

    private void onInitView(WCPeerMeta meta) {
        Toast.makeText(getBaseContext(), getString(R.string.str_wc_connected), Toast.LENGTH_SHORT).show();
        Picasso.get()
                .load(meta.getIcons().get(0))
                .fit()
                .placeholder(R.drawable.validator_none_img)
                .into(mWcImg);
        mWcName.setText(meta.getName());
        mWcUrl.setText(meta.getUrl());
        mWcLayer.setVisibility(View.VISIBLE);
        mLoadingLayer.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(mBtnDisconnect)) {
            if (isDeepLink) {
                moveTaskToBack(true);
            }
            onBackPressed();
        }
    }

    private Bundle processTrust(Long id, String wcSignTransaction) {
        if (mDialogWcRawData != null && mDialogWcRawData.isAdded()) mDialogWcRawData.dismiss();
        if (wcSignTransaction != null) {
            Bundle bundle = new Bundle();
            bundle.putString("transaction", wcSignTransaction);
            bundle.putLong("id", id);
            bundle.putInt("type", TYPE_TRUST_WALLET);
            return bundle;
        } else {
            return null;
        }
    }

    private Bundle processKeplr(Long id) {
        if (mDialogWcRawData != null && mDialogWcRawData.isAdded()) mDialogWcRawData.dismiss();
        Bundle bundle = new Bundle();
        bundle.putString("transaction", mjsonArray.toString());
        bundle.putLong("id", id);
        bundle.putInt("type", TYPE_KEPLR_WALLET);
        return bundle;
    }

    private void onShowRawDataDialog(Bundle bundle) {
        mDialogWcRawData = Dialog_Wc_Raw_Data.newInstance(bundle);
        mDialogWcRawData.setCancelable(false);
        getSupportFragmentManager().beginTransaction().add(mDialogWcRawData, "dialog").commitNowAllowingStateLoss();
    }

    private void onKeplrEnable(long id, List<String> strings) {
        ArrayList<Account> existAccount = getBaseDao().onSelectAllAccountsByChainWithKey(WDp.getChainTypeByChainId(strings.get(0)));
        if (existAccount.size() <= 0) {
            mWcLayer.setVisibility(View.GONE);
            mLoadingLayer.setVisibility(View.GONE);
            onShowNoAccountsForChain();
        } else {
            wcClient.approveRequest(id, strings);
        }
    }

    private void onKeplrGetKey(Long id, List<String> chainIds) {
        onShowAccountDialog(id, chainIds);
    }

    private void onShowNoAccountsForChain() {
        mDialogEmptyChain = Dialog_Empty_Chain.newInstance();
        mDialogEmptyChain.setCancelable(false);
        getSupportFragmentManager().beginTransaction().add(mDialogEmptyChain, "dialog").commitNowAllowingStateLoss();
    }

    private void onShowAccountDialog(Long id, List<String> strings) {
        Bundle bundle = new Bundle();
        bundle.putLong("id", id);
        bundle.putString("chainName", strings.get(0));
        mDialogWcAccount = Dialog_WC_Account.newInstance(bundle);
        mDialogWcAccount.setCancelable(true);
        mDialogWcAccount.setOnSelectListener((wcId, account) -> {
            currentAccount = account;
            WCKeplrWallet keplr = new WCKeplrWallet(
                    WUtil.getWalletName(this, currentAccount),
                    "secp256k1",
                    getKey().getPublicKeyAsHex(),
                    WKey.generateTenderAddressFromPrivateKey(getKey().getPrivateKeyAsHex()),
                    currentAccount.address,
                    false);
            onInitView(mWcPeerMeta);
            mWcAccount.setText(currentAccount.address);
            wcClient.approveRequest(id, Lists.newArrayList(keplr));
            if (isDeepLink) {
                moveTaskToBack(true);
            }
        });
        getSupportFragmentManager().beginTransaction().add(mDialogWcAccount, "dialog").commitNowAllowingStateLoss();
    }

    public void onDeepLinkDismiss() {
        moveTaskToBack(true);
    }

    class SignModel {
        TreeMap<String, Object> signed;
        Signature signature;

        public SignModel(JsonObject txMsg, ECKey key) {
            this.signed = new Gson().fromJson(txMsg, TreeMap.class);
            this.signature = MsgGenerator.getWcKeplrBroadcaseReq(key, txMsg);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == BaseConstant.CONST_PW_SIMPLE_CHECK && resultCode == Activity.RESULT_OK) {
            initWalletConnect();
        } else {
            finish();
        }
    }
}

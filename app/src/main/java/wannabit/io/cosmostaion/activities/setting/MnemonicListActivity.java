package wannabit.io.cosmostaion.activities.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import wannabit.io.cosmostaion.R;
import wannabit.io.cosmostaion.activities.PasswordCheckActivity;
import wannabit.io.cosmostaion.activities.PasswordSetActivity;
import wannabit.io.cosmostaion.base.BaseActivity;
import wannabit.io.cosmostaion.crypto.CryptoHelper;
import wannabit.io.cosmostaion.crypto.EncResult;
import wannabit.io.cosmostaion.dao.MWords;
import wannabit.io.cosmostaion.dialog.NickNameSetDialog;
import wannabit.io.cosmostaion.utils.WKey;
import wannabit.io.cosmostaion.utils.WUtil;

public class MnemonicListActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private Button mBtnImportMnemonic, mBtnCreateMnemonic;

    private MnemonicListAdapter mAdapter;

    private ArrayList<MWords> mMyMnemonics = new ArrayList<>();
    private ArrayList<String> mWordsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mnemonic_list);
        mToolbar = findViewById(R.id.tool_bar);
        mRecyclerView = findViewById(R.id.recycler);
        mBtnImportMnemonic = findViewById(R.id.btn_import_mnemonic);
        mBtnCreateMnemonic = findViewById(R.id.btn_create_mnemonic);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new MnemonicListAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mBtnImportMnemonic.setOnClickListener(this);
        mBtnCreateMnemonic.setOnClickListener(this);

        onCreateMnemonic();

    }

    @Override
    protected void onResume() {
        super.onResume();
        mMyMnemonics = getBaseDao().onSelectAllMnemonics();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.equals(mBtnImportMnemonic)) {
            if (!getBaseDao().onHasPassword()) {
                Intent intent = new Intent(MnemonicListActivity.this, PasswordSetActivity.class);
                mnemonicImportResultLauncher.launch(intent);
            } else {
                Intent intent = new Intent(MnemonicListActivity.this, PasswordCheckActivity.class);
                mnemonicImportResultLauncher.launch(intent);
            }
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.fade_out);

        } else if (v.equals(mBtnCreateMnemonic)) {
            if (!getBaseDao().onHasPassword()) {
                Intent intent = new Intent(MnemonicListActivity.this, PasswordSetActivity.class);
                mnemonicCreateResultLauncher.launch(intent);
            } else {
                Intent intent = new Intent(MnemonicListActivity.this, PasswordCheckActivity.class);
                mnemonicCreateResultLauncher.launch(intent);
            }
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.fade_out);
        }
    }

    private final ActivityResultLauncher<Intent> mnemonicCreateResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
            long id = getBaseDao().onInsertMnemonics(onGenMWords());
            if (id > 0) {
                Bundle bundle = new Bundle();
                bundle.putLong("id", id);
                bundle.putInt(NickNameSetDialog.CHANGE_NICK_NAME_BUNDLE_KEY, NickNameSetDialog.MNEMONIC_CREATE_VALUE);
                NickNameSetDialog dialog = NickNameSetDialog.newInstance(bundle);
                dialog.show(getSupportFragmentManager(), "dialog");
            }
        }
    });

    private final ActivityResultLauncher<Intent> mnemonicImportResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
            long id = getBaseDao().onInsertMnemonics(onGenMWords());
            if (id > 0) {
                Bundle bundle = new Bundle();
                bundle.putLong("id", id);
                NickNameSetDialog dialog = NickNameSetDialog.newInstance(bundle);
                dialog.show(getSupportFragmentManager(), "dialog");
            }
        }
    });

    private class MnemonicListAdapter extends RecyclerView.Adapter<MnemonicListAdapter.ListHolder> {

        @NonNull
        @Override
        public ListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ListHolder(getLayoutInflater().inflate(R.layout.item_mnemonic_list, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ListHolder holder, int position) {
            MWords mWord = mMyMnemonics.get(position);
            holder.itemMnemonicName.setText(mWord.getName());
            holder.itemDerivedCnt.setText(String.valueOf(mWord.getLinkedWalletCnt(getBaseDao())));
            holder.itemWordsCnt.setText(String.valueOf(mWord.wordsCnt));
            holder.itemImportedDate.setText(mWord.getImportDate(MnemonicListActivity.this));

            holder.itemRoot.setOnClickListener(view -> {
                if (getBaseDao().isAutoPass()) {
                    Intent checkIntent = new Intent(MnemonicListActivity.this, MnemonicDetailActivity.class);
                    checkIntent.putExtra("mnemonicId", mWord.id);
                    startActivity(checkIntent);

                } else {
                    Intent checkintent = new Intent(MnemonicListActivity.this, PasswordCheckActivity.class);
                    checkintent.putExtra("mnemonicId", mWord.id);
                    mnemonicDetailResultLauncher.launch(checkintent);
                    overridePendingTransition(R.anim.slide_in_bottom, R.anim.fade_out);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mMyMnemonics.size();
        }

        public class ListHolder extends RecyclerView.ViewHolder {
            private CardView itemRoot;
            private TextView itemMnemonicName, itemDerivedCnt, itemWordsCnt, itemImportedDate;

            public ListHolder(View v) {
                super(v);
                itemRoot = itemView.findViewById(R.id.card_root);
                itemMnemonicName = itemView.findViewById(R.id.mnemonic_nickname);
                itemDerivedCnt = itemView.findViewById(R.id.derived_cnt);
                itemWordsCnt = itemView.findViewById(R.id.words_cnt);
                itemImportedDate = itemView.findViewById(R.id.imported_date);
            }
        }
    }

    ActivityResultLauncher<Intent> mnemonicDetailResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
            Intent checkintent = new Intent(MnemonicListActivity.this, MnemonicDetailActivity.class);
            checkintent.putExtra("mnemonicId", result.getData().getLongExtra("mnemonicId", -1));
            startActivity(checkintent);
        }
    });

    private void onCreateMnemonic() {
        byte[] mEntropy = WKey.getEntropy();
        mWordsList = new ArrayList<String>(WKey.getRandomMnemonic(mEntropy));
    }

    private MWords onGenMWords() {
        MWords tempMWords = MWords.getNewInstance();
        String entropy = WUtil.ByteArrayToHexString(WKey.toEntropy(mWordsList));
        EncResult encR = CryptoHelper.doEncryptData(getString(R.string.key_mnemonic) + tempMWords.uuid, entropy, false);

        tempMWords.resource = encR.getEncDataString();
        tempMWords.spec = encR.getIvDataString();
        tempMWords.wordsCnt = mWordsList.size();
        return tempMWords;
    }
}

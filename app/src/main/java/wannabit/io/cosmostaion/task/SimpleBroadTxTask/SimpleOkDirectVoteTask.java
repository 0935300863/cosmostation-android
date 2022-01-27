package wannabit.io.cosmostaion.task.SimpleBroadTxTask;

import org.bitcoinj.core.ECKey;
import org.bitcoinj.crypto.DeterministicKey;

import java.math.BigInteger;
import java.util.ArrayList;

import retrofit2.Response;
import wannabit.io.cosmostaion.BuildConfig;
import wannabit.io.cosmostaion.R;
import wannabit.io.cosmostaion.base.BaseApplication;
import wannabit.io.cosmostaion.base.BaseChain;
import wannabit.io.cosmostaion.base.BaseConstant;
import wannabit.io.cosmostaion.cosmos.MsgGenerator;
import wannabit.io.cosmostaion.crypto.CryptoHelper;
import wannabit.io.cosmostaion.dao.Account;
import wannabit.io.cosmostaion.dao.Password;
import wannabit.io.cosmostaion.model.type.Fee;
import wannabit.io.cosmostaion.model.type.Msg;
import wannabit.io.cosmostaion.network.ApiClient;
import wannabit.io.cosmostaion.network.req.ReqBroadCast;
import wannabit.io.cosmostaion.network.res.ResBroadTx;
import wannabit.io.cosmostaion.network.res.ResOkAccountInfo;
import wannabit.io.cosmostaion.task.CommonTask;
import wannabit.io.cosmostaion.task.TaskListener;
import wannabit.io.cosmostaion.task.TaskResult;
import wannabit.io.cosmostaion.utils.WKey;
import wannabit.io.cosmostaion.utils.WUtil;

import static wannabit.io.cosmostaion.base.BaseChain.OKEX_MAIN;
import static wannabit.io.cosmostaion.base.BaseChain.OK_TEST;
import static wannabit.io.cosmostaion.base.BaseChain.getChain;
import static wannabit.io.cosmostaion.base.BaseConstant.ERROR_CODE_BROADCAST;
import static wannabit.io.cosmostaion.base.BaseConstant.TASK_GEN_TX_OK_DIRECT_VOTE;

public class SimpleOkDirectVoteTask extends CommonTask {

    private Account             mAccount;
    private BaseChain           mBaseChain;
    private ArrayList<String>   mToValidators;
    private String              mMemo;
    private Fee                 mFees;

    public SimpleOkDirectVoteTask(BaseApplication app, TaskListener listener, Account account, BaseChain chain, ArrayList<String> toVals, String memo, Fee fees) {
        super(app, listener);
        this.mAccount = account;
        this.mBaseChain = chain;
        this.mToValidators = toVals;
        this.mMemo = memo;
        this.mFees = fees;
        this.mResult.taskType   = TASK_GEN_TX_OK_DIRECT_VOTE;
    }

    @Override
    protected TaskResult doInBackground(String... strings) {
        try {
            Password checkPw = mApp.getBaseDao().onSelectPassword();
            if(!CryptoHelper.verifyData(strings[0], checkPw.resource, mApp.getString(R.string.key_password))) {
                mResult.isSuccess = false;
                mResult.errorCode = BaseConstant.ERROR_CODE_INVALID_PASSWORD;
                return mResult;
            }
            if (mBaseChain.equals(OKEX_MAIN)) {
                Response<ResOkAccountInfo> accountResponse = ApiClient.getOkexChain(mApp).getAccountInfo(mAccount.address).execute();
                if (!accountResponse.isSuccessful()) {
                    mResult.errorCode = ERROR_CODE_BROADCAST;
                    return mResult;
                }
                mApp.getBaseDao().onUpdateAccount(WUtil.getAccountFromOkLcd(mAccount.id, accountResponse.body()));
                mApp.getBaseDao().mOkAccountInfo = accountResponse.body();

            }

            ECKey ecKey;
            if (mAccount.fromMnemonic) {
                String entropy = CryptoHelper.doDecryptData(mApp.getString(R.string.key_mnemonic) + mAccount.uuid, mAccount.resource, mAccount.spec);
                DeterministicKey deterministicKey = WKey.getKeyWithPathfromEntropy(mAccount, entropy);
                ecKey = ECKey.fromPrivate(new BigInteger(deterministicKey.getPrivateKeyAsHex(), 16));
            } else {
                String privateKey = CryptoHelper.doDecryptData(mApp.getString(R.string.key_private) + mAccount.uuid, mAccount.resource, mAccount.spec);
                ecKey = ECKey.fromPrivate(new BigInteger(privateKey, 16));
            }

            Msg incentiveMsg = MsgGenerator.genOkVote(mAccount.address, mToValidators, mBaseChain);
            ArrayList<Msg> msgs= new ArrayList<>();
            msgs.add(incentiveMsg);

            if (getChain(mAccount.baseChain).equals(OKEX_MAIN)) {
                ReqBroadCast reqBroadCast = MsgGenerator.getOKexBroadcaseReq(mAccount, msgs, mFees, mMemo, ecKey, mApp.getBaseDao().getChainId());
                Response<ResBroadTx> response = ApiClient.getOkexChain(mApp).broadTx(reqBroadCast).execute();
                if(response.isSuccessful() && response.body() != null) {
                    if (response.body().txhash != null) {
                        mResult.resultData = response.body().txhash;
                    }
                    if (response.body().code != null) {
                        mResult.errorCode = response.body().code;
                        mResult.errorMsg = response.body().raw_log;
                        return mResult;
                    }
                    mResult.isSuccess = true;

                } else {
                    mResult.errorCode = ERROR_CODE_BROADCAST;
                }

            }

        } catch (Exception e) {
            if(BuildConfig.DEBUG) e.printStackTrace();
        }

        return mResult;
    }
}

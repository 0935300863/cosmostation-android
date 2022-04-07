package wannabit.io.cosmostaion.chain;

import static wannabit.io.cosmostaion.base.BaseChain.IRIS_MAIN;
import static wannabit.io.cosmostaion.base.BaseChain.IRIS_TEST;
import static wannabit.io.cosmostaion.base.BaseConstant.BLOCK_TIME_IRIS;
import static wannabit.io.cosmostaion.base.BaseConstant.EXPLORER_IRIS_MAIN;
import static wannabit.io.cosmostaion.base.BaseConstant.IRIS_GAS_RATE_AVERAGE;
import static wannabit.io.cosmostaion.base.BaseConstant.IRIS_GAS_RATE_LOW;
import static wannabit.io.cosmostaion.base.BaseConstant.IRIS_GAS_RATE_TINY;
import static wannabit.io.cosmostaion.base.BaseConstant.IRIS_UNKNOWN_RELAYER;
import static wannabit.io.cosmostaion.base.BaseConstant.IRIS_VAL_URL;
import static wannabit.io.cosmostaion.base.BaseConstant.KEY_PATH;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_IRIS;
import static wannabit.io.cosmostaion.utils.WKey.bech32Decode;
import static wannabit.io.cosmostaion.utils.WKey.bech32Encode;
import static wannabit.io.cosmostaion.utils.WUtil.getEstimateGasAmount;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import org.bitcoinj.crypto.ChildNumber;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import wannabit.io.cosmostaion.R;
import wannabit.io.cosmostaion.activities.MainActivity;
import wannabit.io.cosmostaion.activities.chains.nft.NFTListActivity;
import wannabit.io.cosmostaion.base.BaseChain;
import wannabit.io.cosmostaion.base.BaseData;
import wannabit.io.cosmostaion.model.type.Coin;
import wannabit.io.cosmostaion.utils.WDp;

public class Iris extends Chain {

    @Override
    public BaseChain getChain() { return IRIS_MAIN; }

    @Override
    public ArrayList<BaseChain> getChains() {
        return Lists.newArrayList(IRIS_MAIN, IRIS_TEST);
    }

    @Override
    public String getMainDenom() {
        return TOKEN_IRIS;
    }

    @Override
    public int mainDecimal() { return 6; }

    @Override
    public BigDecimal getRealBlockTime() { return BLOCK_TIME_IRIS; }

    @Override
    public String getExplorer() {
        return EXPLORER_IRIS_MAIN;
    }

    @Override
    public List<ChildNumber> setParentPath(int customPath) {
        return ImmutableList.of(new ChildNumber(44, true), new ChildNumber(118, true), ChildNumber.ZERO_HARDENED, ChildNumber.ZERO);
    }

    @Override
    public String getDpAddress(byte[] converted) {
        return bech32Encode("iaa".getBytes(), converted);
    }

    @Override
    public String convertDpOpAddressToDpAddress(String dpOpAddress) {
        return bech32Encode("iaa".getBytes(), bech32Decode(dpOpAddress).data);
    }

    @Override
    public String setPath(int position, int customPath) {
        return KEY_PATH + String.valueOf(position);
    }

    @Override
    public void setShowCoinDp(Context c, BaseData baseData, Coin coin, TextView denomTv, TextView amountTv) {
        if (coin.denom.equalsIgnoreCase(getMainDenom())) {
            setDpMainDenom(c, denomTv);
        } else {
            denomTv.setTextColor(c.getResources().getColor(R.color.colorWhite));
            denomTv.setText(coin.denom.toUpperCase());
        }
        amountTv.setText(WDp.getDpAmount2(c, new BigDecimal(coin.amount), mainDecimal(), mainDecimal()));
    }

    @Override
    public void setShowCoinDp(Context c, BaseData baseData, String symbol, String amount, TextView denomTv, TextView amountTv) {
        if (symbol.equals(getMainDenom())) {
            setDpMainDenom(c, denomTv);
        } else {
            denomTv.setTextColor(c.getResources().getColor(R.color.colorWhite));
            denomTv.setText(symbol.toUpperCase());
        }
        amountTv.setText(WDp.getDpAmount2(c, new BigDecimal(amount), mainDecimal(), mainDecimal()));
    }

    @Override
    public void setDpMainDenom(Context c, TextView denomTxt) {
        denomTxt.setTextColor(c.getResources().getColor(R.color.colorIris));
        denomTxt.setText(c.getString(R.string.s_iris));
    }

    @Override
    public void setCoinMainDenom(Context c, TextView symbol, TextView fullName, ImageView imageView) {
        symbol.setText(c.getString(R.string.str_iris_c));
        fullName.setText("Iris Staking Coin");
        imageView.setImageDrawable(c.getResources().getDrawable(R.drawable.iris_toket_img));
    }

    @Override
    public void setChainTitle(Context c, TextView chainName, int type) {
        if (type == 0) {
            chainName.setText(c.getString(R.string.str_iris_net));
        } else {
            chainName.setText(c.getString(R.string.str_iris));
        }
    }

    @Override
    public void setInfoImg(ImageView imageView, int type) {
        if (type == 0) {
            imageView.setImageResource(R.drawable.iris_wh);
        } else if (type == 1) {
            imageView.setImageResource(R.drawable.iris_toket_img);
        }
    }

    @Override
    public String setMonikerImgUrl(String opAddress) {
        return IRIS_VAL_URL + opAddress + ".png";
    }

    @Override
    public String getChainName() {
        return "iris";
    }

    @Override
    public boolean isValidChainAddress(String address) {
        if (address.startsWith("iaa1")) { return true; }
        else { return false; }
    }

    @Override
    public String getDefaultRelayerImg() { return IRIS_UNKNOWN_RELAYER; }

    @Override
    public void setFloatBtn(Context c, FloatingActionButton floatBtn) {
        floatBtn.setBackgroundTintList(c.getResources().getColorStateList(R.color.colorIris));
    }

    @Override
    public void setLayoutColor(Context c, int length, LinearLayout[] wordsLayer) {
        wordsLayer[length].setBackground(c.getDrawable(R.drawable.box_round_iris));
    }

    @Override
    public int setChainColor(Context c, int type) {
        if (type == 0) {
            return c.getResources().getColor(R.color.colorIris);
        } else {
            return c.getResources().getColor(R.color.colorTransBgIris);
        }

    }

    @Override
    public ColorStateList setChainTabColor(Context c, int type) {
        if (type == 0) {
            return c.getResources().getColorStateList(R.color.color_tab_myvalidator_iris);
        } else {
            return c.getResources().getColorStateList(R.color.colorIris);
        }

    }

    @Override
    public void setGuideInfo(MainActivity mainActivity, ImageView guideImg, TextView guideTitle, TextView guideMsg, Button guideBtn1, Button guideBtn2) {
        guideImg.setImageDrawable(mainActivity.getResources().getDrawable(R.drawable.irisnet_img));
        guideTitle.setText(R.string.str_front_guide_title_iris);
        guideMsg.setText(R.string.str_front_guide_msg_iris);
    }

    @Override
    public void setWalletData(MainActivity mainActivity, ImageView coinImg, TextView coinDenom) {
        coinImg.setImageDrawable(mainActivity.getResources().getDrawable(R.drawable.iris_toket_img));
        coinDenom.setText(R.string.str_iris_c);
        coinDenom.setTextAppearance(R.style.font_ss_14_iris);
    }

    @Override
    public void setDexTitle(MainActivity mainActivity, RelativeLayout mBtnDex, TextView dexTitle) {
        mBtnDex.setVisibility(View.VISIBLE);
        dexTitle.setCompoundDrawablesWithIntrinsicBounds(mainActivity.getResources().getDrawable(R.drawable.icon_nft), null, null, null);
        dexTitle.setText(R.string.str_nft_c);
    }

    @Override
    public Intent setMainIntent(MainActivity mainActivity, int type) {
        if (type == 0) {
            return new Intent(mainActivity, NFTListActivity.class);
        } else {
            return new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.coingecko.com/en/coins/irisnet"));
        }
    }

    @Override
    public Intent setGuideIntent(int sequence) {
        if (sequence == 0) {
            return new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.irisnet.org/"));
        } else {
            return new Intent(Intent.ACTION_VIEW , Uri.parse("https://medium.com/irisnet-blog"));
        }
    }

    @Override
    public BigDecimal setEstimateGasFeeAmount(Context c, BaseChain basechain, int txType, int valCnt) {
        BigDecimal gasRate = new BigDecimal(IRIS_GAS_RATE_AVERAGE);
        BigDecimal gasAmount = getEstimateGasAmount(c, basechain, txType, valCnt);
        return gasRate.multiply(gasAmount).setScale(0, RoundingMode.DOWN);
    }

    @Override
    public BigDecimal setGasRate(int position) {
        if (position == 0) {
            return new BigDecimal(IRIS_GAS_RATE_TINY);
        } else if (position == 1) {
            return new BigDecimal(IRIS_GAS_RATE_LOW);
        }
        return new BigDecimal(IRIS_GAS_RATE_AVERAGE);
    }

}

package wannabit.io.cosmostaion.chain;

import static wannabit.io.cosmostaion.base.BaseChain.GRABRIDGE_MAIN;
import static wannabit.io.cosmostaion.base.BaseConstant.BLOCK_TIME_GRAV;
import static wannabit.io.cosmostaion.base.BaseConstant.COINGECKO_GRAV_MAIN;
import static wannabit.io.cosmostaion.base.BaseConstant.EXPLORER_GRABRIDGE_MAIN;
import static wannabit.io.cosmostaion.base.BaseConstant.GRABRIDGE_VAL_URL;
import static wannabit.io.cosmostaion.base.BaseConstant.GRAB_UNKNOWN_RELAYER;
import static wannabit.io.cosmostaion.base.BaseConstant.GRAV_GAS_RATE_AVERAGE;
import static wannabit.io.cosmostaion.base.BaseConstant.GRAV_GAS_RATE_LOW;
import static wannabit.io.cosmostaion.base.BaseConstant.GRAV_GAS_RATE_TINY;
import static wannabit.io.cosmostaion.base.BaseConstant.KEY_PATH;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_GRABRIDGE;
import static wannabit.io.cosmostaion.utils.WDp.getDpAmount2;
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
import wannabit.io.cosmostaion.base.BaseChain;
import wannabit.io.cosmostaion.base.BaseData;
import wannabit.io.cosmostaion.dao.Assets;
import wannabit.io.cosmostaion.network.ApiClient;
import wannabit.io.cosmostaion.network.HistoryApi;
import wannabit.io.cosmostaion.utils.WDp;
import wannabit.io.cosmostaion.utils.WUtil;

public class GravityBridge extends Chain {

    @Override
    public BaseChain getChain() { return GRABRIDGE_MAIN; }

    @Override
    public ArrayList<BaseChain> getChains() { return Lists.newArrayList(GRABRIDGE_MAIN); }

    @Override
    public String getMainDenom() {
        return TOKEN_GRABRIDGE;
    }

    @Override
    public int mainDecimal() { return 6; }

    @Override
    public BigDecimal getRealBlockTime() { return BLOCK_TIME_GRAV; }

    @Override
    public String getExplorer() { return EXPLORER_GRABRIDGE_MAIN; }

    @Override
    public List<ChildNumber> setParentPath(int customPath) {
        return  ImmutableList.of(new ChildNumber(44, true), new ChildNumber(118, true), ChildNumber.ZERO_HARDENED, ChildNumber.ZERO);
    }

    @Override
    public String getDpAddress(byte[] converted) {
        return bech32Encode("gravity".getBytes(), converted);
    }

    @Override
    public String convertDpOpAddressToDpAddress(String dpOpAddress) {
        return bech32Encode("gravity".getBytes(), bech32Decode(dpOpAddress).data);
    }

    @Override
    public String setPath(int position, int customPath) { return KEY_PATH + String.valueOf(position); }

    @Override
    public void setShowCoinDp(Context c, BaseData baseData, String symbol, String amount, TextView denomTv, TextView amountTv) {
        int decimal = WUtil.getGBridgeCoinDecimal(baseData, symbol);
        if (symbol.equalsIgnoreCase(TOKEN_GRABRIDGE)) {
            setDpMainDenom(c, denomTv);
        } else if (symbol.startsWith("gravity")) {
            final Assets assets = baseData.getAsset(symbol);
            if (assets != null) {
                denomTv.setText(assets.origin_symbol);
                denomTv.setTextColor(c.getResources().getColor(R.color.colorWhite));
            }
        } else {
            denomTv.setTextColor(c.getResources().getColor(R.color.colorWhite));
            denomTv.setText(symbol.toUpperCase());
        }
        amountTv.setText(getDpAmount2(c, new BigDecimal(amount), decimal, decimal));
    }

    @Override
    public void setDpMainDenom(Context c, TextView denomTxt) {
        denomTxt.setTextColor(c.getResources().getColor(R.color.colorGraBridge));
        denomTxt.setText(c.getString(R.string.str_grabridge_c));
    }

    @Override
    public void setCoinMainList(Context c, BaseData baseData, String denom, TextView symbol, TextView fullName, ImageView imageView, TextView balance, TextView value) {
        setDpMainDenom(c, symbol);
        fullName.setText("G-Bridge Staking Coin");
        setInfoImg(imageView, 1);

        BigDecimal totalAmount = baseData.getAllMainAsset(denom);
        balance.setText(getDpAmount2(c, totalAmount, mainDecimal(), 6));
        value.setText(WDp.dpUserCurrencyValue(baseData, denom, totalAmount, mainDecimal()));
    }

    @Override
    public void setChainTitle(Context c, TextView chainName, int type) {
        if (type == 0) {
            chainName.setText(c.getString(R.string.str_grabridge_net));
        } else {
            chainName.setText(c.getString(R.string.str_grabridge_main));
        }
    }

    @Override
    public void setInfoImg(ImageView imageView, int type) {
        if (type == 0) {
            imageView.setImageResource(R.drawable.chain_gravitybridge);
        } else if (type == 1) {
            imageView.setImageResource(R.drawable.token_gravitybridge);
        }
    }

    @Override
    public String setMonikerImgUrl(String opAddress) {
        return GRABRIDGE_VAL_URL + opAddress + ".png";
    }

    @Override
    public String getChainName() {
        return "gravity-bridge";
    }

    @Override
    public boolean isValidChainAddress(String address, BaseChain baseChain) {
        if (address.startsWith("gravity1") && baseChain.equals(getChain())) { return true; }
        else { return false; }
    }

    @Override
    public String getDefaultRelayerImg() { return GRAB_UNKNOWN_RELAYER; }

    @Override
    public void setFloatBtn(Context c, FloatingActionButton floatBtn) {
        floatBtn.setBackgroundTintList(c.getResources().getColorStateList(R.color.colorGraBridge));
    }

    @Override
    public void setLayoutColor(Context c, int length, LinearLayout[] wordsLayer) {
        wordsLayer[length].setBackground(c.getDrawable(R.drawable.box_round_grabridge));
    }

    @Override
    public int setChainColor(Context c, int type) {
        if (type == 0) {
            return c.getResources().getColor(R.color.colorGraBridge);
        } else {
            return c.getResources().getColor(R.color.colorTransBgGraBridge);
        }
    }

    @Override
    public ColorStateList setChainTabColor(Context c, int type) {
        if (type == 0) {
            return c.getResources().getColorStateList(R.color.color_tab_myvalidator_grabridge);
        } else {
            return c.getResources().getColorStateList(R.color.colorGraBridge);
        }

    }

    @Override
    public void setGuideInfo(MainActivity mainActivity, ImageView guideImg, TextView guideTitle, TextView guideMsg, Button guideBtn1, Button guideBtn2) {
        guideImg.setImageDrawable(mainActivity.getResources().getDrawable(R.drawable.infoicon_gravitybridge));
        guideTitle.setText(R.string.str_front_guide_title_grabridge);
        guideMsg.setText(R.string.str_front_guide_msg_grabridge);
    }

    @Override
    public void setWalletData(MainActivity mainActivity, ImageView coinImg, TextView coinDenom) {
        coinImg.setImageDrawable(mainActivity.getResources().getDrawable(R.drawable.token_gravitybridge));
        coinDenom.setText(R.string.str_grabridge_c);
        coinDenom.setTextAppearance(R.style.font_ss_14_grabridge);
    }

    @Override
    public void setDexTitle(MainActivity mainActivity, RelativeLayout mBtnDex, TextView dexTitle) {
        mBtnDex.setVisibility(View.GONE);
    }

    @Override
    public void setMainIntent(MainActivity mainActivity, int sequence) {
        if (sequence == 1) {
            mainActivity.startActivity(new Intent(Intent.ACTION_VIEW , Uri.parse(COINGECKO_GRAV_MAIN)));
        } else if (sequence == 2) {
            mainActivity.startActivity(new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.gravitybridge.net/")));
        } else if (sequence == 3 ) {
            mainActivity.startActivity(new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.gravitybridge.net/blog/")));
        }
    }

    @Override
    public BigDecimal setEstimateGasFeeAmount(Context c, BaseChain basechain, int txType, int valCnt) {
        BigDecimal gasRate = new BigDecimal(GRAV_GAS_RATE_AVERAGE);
        BigDecimal gasAmount = getEstimateGasAmount(c, basechain, txType, valCnt);
        return gasRate.multiply(gasAmount).setScale(0, RoundingMode.DOWN);
    }

    @Override
    public BigDecimal setGasRate(int position) {
        if (position == 0) {
            return new BigDecimal(GRAV_GAS_RATE_TINY);
        } else if (position == 1) {
            return new BigDecimal(GRAV_GAS_RATE_LOW);
        }
        return new BigDecimal(GRAV_GAS_RATE_AVERAGE);
    }

    @Override
    public HistoryApi getHistoryApi(Context c) { return ApiClient.getGraBridgeApi(c); }
}

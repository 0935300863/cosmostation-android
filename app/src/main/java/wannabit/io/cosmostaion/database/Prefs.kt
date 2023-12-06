package wannabit.io.cosmostaion.database

import SecureSharedPreferences
import android.content.Context
import org.json.JSONArray
import org.json.JSONException
import wannabit.io.cosmostaion.chain.DEFAULT_DISPLAY_COSMOS
import wannabit.io.cosmostaion.common.BaseData
import wannabit.io.cosmostaion.database.model.BaseAccount
import wannabit.io.cosmostaion.ui.main.CosmostationApp

object Prefs {
    private const val PREFERENCES_NAME = "PREFS"
    private const val DB_VERSION = "PRE_DB_VERSION"
    private const val LAST_ACCOUNT = "PRE_LAST_ACCOUNT"
    private const val DISPLAY_CHAINS = "PRE_DISPLAY_CHAINS"
    private const val LAST_PRICE_TIME = "PRE_LAST_PRICE_TIME"
    private const val LAST_CURRENCY = "PRE_CURRENCY"
    private const val LANGUAGE = "PRE_LANGUAGE"
    private const val PRICE_STYLE = "PRE_PRICE_STYLE"
    private const val LAST_TIME = "PRE_LAST_TIME"
    private const val APP_LOCK = "PRE_APP_LOCK"
    private const val AUTO_PASS = "PRE_AUTO_PASS"
    private const val FCM_TOKEN = "PRE_FCM_TOKEN_NEW"
    private const val ALARM_ENABLE_STATUS = "PRE_ALARM_STATUS"
    private const val CURRENT_USER_ID = "PRE_USER_ID"
    private const val DATABASE_PASSPHRASE = "DB_PASSPHRASE"

    private val preference = CosmostationApp.instance.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    var lastUserId: Long
        get() = preference.getLong(CURRENT_USER_ID, -1)
        set(value) = preference.edit().putLong(CURRENT_USER_ID, value).apply()

    var fcmToken: String
        get() = preference.getString(FCM_TOKEN, "") ?: ""
        set(value) = preference.edit().putString(FCM_TOKEN, value).apply()

    var alarmEnable: Boolean
        get() = preference.getBoolean(ALARM_ENABLE_STATUS, false)
        set(value) = preference.edit().putBoolean(ALARM_ENABLE_STATUS, value).apply()

    var passphrase: String
        get() = SecureSharedPreferences.wrap(preference).get(DATABASE_PASSPHRASE, "")
        set(value) = SecureSharedPreferences.wrap(preference).putString(DATABASE_PASSPHRASE, value)

    var version: Int
        get() = preference.getInt(DB_VERSION, -1)
        set(value) = preference.edit().putInt(DB_VERSION, value).apply()

    var lastAccountId: Long
        get() = preference.getLong(LAST_ACCOUNT, -1)
        set(value) = preference.edit().putLong(LAST_ACCOUNT, value).apply()

    fun setDisplayChains(baseAccount: BaseAccount, chainNames: List<String>) {
        val encoded = try {
            val jsonString = JSONArray(chainNames).toString()
            jsonString.toByteArray(Charsets.UTF_8)
        } catch (e: JSONException) {
            null
        }

        if (encoded != null) {
            val key = "${baseAccount.id} $DISPLAY_CHAINS"
            preference.edit().putString(key, String(encoded)).apply()
        }
    }

    fun getDisplayChains(baseAccount: BaseAccount): MutableList<String> {
        val key = "${baseAccount.id} $DISPLAY_CHAINS"
        val savedDataString = preference.getString(key, null)

        if (!savedDataString.isNullOrEmpty()) {
            try {
                val jsonArray = JSONArray(savedDataString)
                val result = ArrayList<String>()
                for (i in 0 until jsonArray.length()) {
                    result.add(jsonArray.getString(i))
                }
                return result
            } catch (e: JSONException) { e.printStackTrace() }
        }
        return DEFAULT_DISPLAY_COSMOS
    }

    var lastPriceTime: String
        get() = preference.getString(LAST_PRICE_TIME, "0") ?: "0"
        set(value) = preference.edit().putString(LAST_PRICE_TIME, value).apply()

    var currency: Int
        get() = preference.getInt(LAST_CURRENCY, 0)
        set(value) = preference.edit().putInt(LAST_CURRENCY, value).apply()

    var language: Int
        get() = preference.getInt(LANGUAGE, 0)
        set(value) = preference.edit().putInt(LANGUAGE, value).apply()

    var priceStyle: Int
        get() = preference.getInt(PRICE_STYLE, 0)
        set(value) = preference.edit().putInt(PRICE_STYLE, value).apply()

    var lastTime: Long
        get() = preference.getLong(LAST_TIME, 0)
        set(value) = preference.edit().putLong(LAST_TIME, value).apply()

    var appLock: Boolean
        get() = preference.getBoolean(APP_LOCK, false)
        set(value) = preference.edit().putBoolean(APP_LOCK, value).apply()

    var autoPass: Int
        get() = preference.getInt(AUTO_PASS, 0)
        set(value) = preference.edit().putInt(AUTO_PASS, value).apply()
}
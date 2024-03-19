package wannabit.io.cosmostaion.ui.viewmodel.intro

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cosmos.staking.v1beta1.StakingProto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import wannabit.io.cosmostaion.chain.CosmosLine
import wannabit.io.cosmostaion.chain.EthereumLine
import wannabit.io.cosmostaion.chain.cosmosClass.ChainBinanceBeacon
import wannabit.io.cosmostaion.chain.cosmosClass.ChainOkt996Keccak
import wannabit.io.cosmostaion.common.BaseConstant
import wannabit.io.cosmostaion.common.BaseData
import wannabit.io.cosmostaion.common.CosmostationConstants
import wannabit.io.cosmostaion.common.getChannel
import wannabit.io.cosmostaion.data.model.req.MoonPayReq
import wannabit.io.cosmostaion.data.model.res.AppVersion
import wannabit.io.cosmostaion.data.model.res.NetworkResult
import wannabit.io.cosmostaion.data.repository.wallet.WalletRepository
import wannabit.io.cosmostaion.database.AppDatabase
import wannabit.io.cosmostaion.database.CryptoHelper
import wannabit.io.cosmostaion.database.model.Password
import wannabit.io.cosmostaion.ui.viewmodel.event.SingleLiveEvent
import java.math.BigDecimal
import java.util.concurrent.TimeUnit

class WalletViewModel(private val walletRepository: WalletRepository) : ViewModel() {

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _hasPassword = MutableLiveData<Boolean>()
    val hasPassword: LiveData<Boolean> get() = _hasPassword

    fun hasPassword() = viewModelScope.launch(Dispatchers.IO) {
        when (val response = walletRepository.selectPassword()) {
            is NetworkResult.Success -> {
                if (response.data.isNotEmpty()) {
                    _hasPassword.postValue(true)
                } else {
                    _hasPassword.postValue(false)
                }
            }

            is NetworkResult.Error -> {
                _errorMessage.postValue("error type : ${response.errorType}  error message : ${response.errorMessage}")
            }
        }
    }

    private val _insertPasswordResult = MutableLiveData<Password>()
    val insertPasswordResult: LiveData<Password> get() = _insertPasswordResult

    fun insertPassword(userInput: String) = viewModelScope.launch(Dispatchers.IO) {
        CryptoHelper.signData(userInput, CosmostationConstants.ENCRYPT_PASSWORD_KEY)
            ?.let { resource ->
                val password = Password(0, resource)
                walletRepository.insertPassword(password)
                _insertPasswordResult.postValue(password)
            }
    }

    private var _walletAppVersionResult = MutableLiveData<AppVersion>()
    val walletAppVersionResult: LiveData<AppVersion> get() = _walletAppVersionResult

    fun walletAppVersion() = viewModelScope.launch(Dispatchers.IO) {
        when (val response = walletRepository.version()) {
            is NetworkResult.Success -> {
                response.data.let { data ->
                    if (data.isSuccessful) {
                        _walletAppVersionResult.postValue(data.body())
                    } else {
                        _errorMessage.postValue("Error")
                    }
                }
            }

            is NetworkResult.Error -> {
                _errorMessage.postValue("error type : ${response.errorType}  error message : ${response.errorMessage}")
            }
        }
    }

    fun chain() = viewModelScope.launch(Dispatchers.IO) {
        when (val response = walletRepository.chain()) {
            is NetworkResult.Success -> {
                response.data.let { data ->
                    if (data.isSuccessful) {
                        BaseData.chains = data.body()?.chains
                    } else {
                        _errorMessage.postValue("Error")
                    }
                }
            }

            is NetworkResult.Error -> {
                _errorMessage.postValue("error type : ${response.errorType}  error message : ${response.errorMessage}")
            }
        }
    }

    fun param() = viewModelScope.launch(Dispatchers.IO) {
        when (val response = walletRepository.param()) {
            is NetworkResult.Success -> {
                response.data?.let { data ->
                    if (!data.isJsonNull) {
                        BaseData.chainParam = data
                    } else {
                        _errorMessage.postValue("Error")
                    }
                }
            }

            is NetworkResult.Error -> {
                _errorMessage.postValue("error type : ${response.errorType}  error message : ${response.errorMessage}")
            }
        }
    }

    var updatePriceResult = SingleLiveEvent<String>()

    fun price(currency: String, force: Boolean? = false) = viewModelScope.launch(Dispatchers.IO) {
        if (!BaseData.priceUpdateIfNeed() && force == false) {
            return@launch
        }
        when (val response = walletRepository.price(currency)) {
            is NetworkResult.Success -> {
                response.data.let { data ->
                    if (data.isSuccessful) {
                        BaseData.prices = data.body()
                        BaseData.setLastPriceTime()
                        BaseData.baseAccount?.updateAllValue()
                        updatePriceResult.postValue(currency)

                    } else {
                        _errorMessage.postValue("Error")
                    }
                }
            }

            is NetworkResult.Error -> {
                _errorMessage.postValue("error type : ${response.errorType}  error message : ${response.errorMessage}")
            }
        }

        when (val response = walletRepository.usdPrice()) {
            is NetworkResult.Success -> {
                response.data.let { data ->
                    if (data.isSuccessful) {
                        BaseData.usdPrices = data.body()

                    } else {
                        _errorMessage.postValue("Error")
                    }
                }
            }

            is NetworkResult.Error -> {
                _errorMessage.postValue("error type : ${response.errorType}  error message : ${response.errorMessage}")
            }
        }
    }

    var pushStatusResult = SingleLiveEvent<Boolean>()
    fun pushStatus(fcmToken: String) = viewModelScope.launch(Dispatchers.IO) {
        when (val response = walletRepository.pushStatus(fcmToken)) {
            is NetworkResult.Success -> {
                response.data.let { data ->
                    if (data.isSuccessful) {
                        pushStatusResult.postValue(data.body()?.subscribe)
                    } else {
                        _errorMessage.postValue("Error")
                    }
                }
            }

            is NetworkResult.Error -> {
                _errorMessage.postValue("error type : ${response.errorType}  error message : ${response.errorMessage}")
            }
        }
    }

    fun supportConfig() = viewModelScope.launch(Dispatchers.IO) {
        when (val response = walletRepository.supportConfig()) {
            is NetworkResult.Success -> {
                response.data.let { data ->
                    if (data.isSuccessful) {
                        BaseData.supportConfig = data.body()
                    } else {
                        _errorMessage.postValue("Error")
                    }
                }
            }

            is NetworkResult.Error -> {
                _errorMessage.postValue("error type : ${response.errorType}  error message : ${response.errorMessage}")
            }
        }
    }

    fun asset() = viewModelScope.launch(Dispatchers.IO) {
        when (val response = walletRepository.asset()) {
            is NetworkResult.Success -> {
                response.data.let { data ->
                    if (data.isSuccessful) {
                        BaseData.assets = data.body()?.assets
                    } else {
                        _errorMessage.postValue("Error")
                    }
                }
            }

            is NetworkResult.Error -> {
                _errorMessage.postValue("error type : ${response.errorType}  error message : ${response.errorMessage}")
            }
        }
    }

    private val _chainDataErrorMessage = MutableLiveData<String>()
    val chainDataErrorMessage: LiveData<String> get() = _chainDataErrorMessage

    fun loadGrpcStakeData(
        line: CosmosLine
    ) = viewModelScope.launch(Dispatchers.IO) {
        if (line.cosmosValidators.size > 0) {
            return@launch
        }

        val channel = getChannel(line)
        try {
            val loadRewardAddrDeferred = async { walletRepository.rewardAddress(channel, line) }
            val loadBondedDeferred = async { walletRepository.bondedValidator(channel) }
            val loadUnBondedDeferred = async { walletRepository.unBondedValidator(channel) }
            val loadUnBondingDeferred = async { walletRepository.unBondingValidator(channel) }

            val responses = awaitAll(
                loadRewardAddrDeferred,
                loadBondedDeferred,
                loadUnBondedDeferred,
                loadUnBondingDeferred
            )

            responses.forEach { response ->
                when (response) {
                    is NetworkResult.Success -> {
                        when (response.data) {
                            is String -> {
                                line.rewardAddress = response.data
                            }

                            else -> {
                                line.cosmosValidators.addAll(response.data as Collection<StakingProto.Validator>)
                            }
                        }
                        val tempValidators = line.cosmosValidators.toMutableList()
                        tempValidators.sortWith { o1, o2 ->
                            when {
                                o1.description.moniker == "Cosmostation" -> -1
                                o2.description.moniker == "Cosmostation" -> 1
                                o1.jailed && !o2.jailed -> 1
                                !o1.jailed && o2.jailed -> -1
                                o1.tokens.toDouble() > o2.tokens.toDouble() -> -1
                                o1.tokens.toDouble() < o2.tokens.toDouble() -> 1
                                else -> 0
                            }
                        }
                        line.cosmosValidators = tempValidators
                    }

                    is NetworkResult.Error -> {
                        _chainDataErrorMessage.postValue("error type : ${response.errorType}  error message : ${response.errorMessage}")
                    }
                }
            }

        } finally {
            channel.shutdown()
            try {
                if (!channel.awaitTermination(5, TimeUnit.SECONDS)) {
                    channel.shutdownNow()
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }

    private var _balanceResult = MutableLiveData<String>()
    val balanceResult: LiveData<String> get() = _balanceResult

    fun evmBalance(line: EthereumLine) = viewModelScope.launch(Dispatchers.IO) {
        when (val response = walletRepository.evmBalance(line)) {
            is NetworkResult.Success -> {
                line.evmBalance = response.data.toBigDecimal()
                line.fetched = true
                _balanceResult.postValue(line.tag)
            }

            is NetworkResult.Error -> {
                line.evmBalance = BigDecimal.ZERO
                line.fetched = true
                _balanceResult.postValue("null")
            }
        }
    }

    fun balance(line: CosmosLine) = viewModelScope.launch(Dispatchers.IO) {
        when (line) {
            is ChainBinanceBeacon -> {
                when (val response = walletRepository.binanceAccountInfo(line)) {
                    is NetworkResult.Success -> {
                        line.lcdAccountInfo = response.data
                        line.fetched = true
                        _balanceResult.postValue(line.tag)
                    }

                    is NetworkResult.Error -> {
                        line.lcdAccountInfo = null
                        line.fetched = true
                        _balanceResult.postValue("null")
                    }
                }
            }

            is ChainOkt996Keccak -> {
                when (val response = walletRepository.oktAccountInfo(line)) {
                    is NetworkResult.Success -> {
                        line.oktLcdAccountInfo = response.data
                        line.fetched = true
                        _balanceResult.postValue(line.tag)
                    }

                    is NetworkResult.Error -> {
                        line.oktLcdAccountInfo = null
                        line.fetched = true
                        _balanceResult.postValue("null")
                    }
                }
            }

            else -> {
                val channel = getChannel(line)
                when (val response = walletRepository.balance(channel, line)) {
                    is NetworkResult.Success -> {
                        response.data?.balancesList?.let {
                            line.cosmosBalances = it
                            line.fetched = true
                            _balanceResult.postValue(line.tag)
                        }
                    }

                    is NetworkResult.Error -> {
                        line.cosmosBalances = null
                        line.fetched = true
                        _balanceResult.postValue("null")
                    }
                }
            }
        }
    }

    private var _pwCheckResult = MutableLiveData<String>()
    val pwCheckResult: LiveData<String> get() = _pwCheckResult
    fun checkPassword(input: String) = viewModelScope.launch(Dispatchers.IO) {
        val checkPw = AppDatabase.getInstance().passwordDao().selectAll()
        checkPw.forEach { password ->
            if (!CryptoHelper.verifyData(
                    input, password.resource, CosmostationConstants.ENCRYPT_PASSWORD_KEY
                )
            ) {
                _pwCheckResult.postValue(BaseConstant.FAIL)
            } else {
                _pwCheckResult.postValue(BaseConstant.SUCCESS)
            }
        }
    }

    private val _moonPayDataErrorMessage = MutableLiveData<String>()
    val moonPayDataErrorMessage: LiveData<String> get() = _moonPayDataErrorMessage

    private var _moonPayResult = MutableLiveData<String>()
    val moonPayResult: LiveData<String> get() = _moonPayResult
    fun moonPay(data: MoonPayReq) = CoroutineScope(Dispatchers.IO).launch {
        when (val response = walletRepository.moonPay(data)) {
            is NetworkResult.Success -> {
                _moonPayResult.postValue(response.data.body()?.signature)
            }

            is NetworkResult.Error -> {
                _moonPayDataErrorMessage.postValue("error type : ${response.errorType}  error message : ${response.errorMessage}")
            }
        }
    }
}
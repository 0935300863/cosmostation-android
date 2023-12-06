package wannabit.io.cosmostaion.common

import java.math.BigDecimal

object BaseConstant {
    const val SUPPORT_BEP3_SWAP = true
    const val DB_NAME = "WannaBit"
    const val DB_VERSION = 7
    const val DB_TABLE_PASSWORD = "paswd"
    const val DB_TABLE_ACCOUNT = "accnt"
    const val DB_TABLE_MNEMONIC = "mnemonic"
    const val DB_TABLE_BALANCE = "balan"
    const val DB_TABLE_BONDING = "bondi"
    const val DB_TABLE_UNBONDING = "unbond"

    const val SUCCESS = "Success"
    const val FAIL = "Fail"

    const val CONST_PW_CONFIRM_MNEMONIC = 1001
    const val CONST_PW_CONFIRM_PRIVATE = 1002

    const val CONST_NEW_ACCOUNT = 2000
    const val CONST_RESTORE_MNEMONIC_ACCOUNT = 2001
    const val CONST_RESTORE_PRIVATE_ACCOUNT = 2002

    //gRPC
    const val TASK_GRPC_FETCH_BALANCE = 4001
    const val TASK_GRPC_FETCH_BONDED_VALIDATORS = 4002
    const val TASK_GRPC_FETCH_UNBONDED_VALIDATORS = 4003
    const val TASK_GRPC_FETCH_UNBONDING_VALIDATORS = 4004
    const val TASK_GRPC_FETCH_DELEGATIONS = 4005
    const val TASK_GRPC_FETCH_UNDELEGATIONS = 4006
    const val TASK_GRPC_FETCH_ALL_REWARDS = 4007
    const val TASK_GRPC_FETCH_COMMISSION = 4008
    const val TASK_GRPC_FETCH_STAKING_POOL = 4012
    const val TASK_GRPC_FETCH_VALIDATOR_INFO = 4014
    const val TASK_GRPC_FETCH_SELF_BONDING = 4015
    const val TASK_GRPC_FETCH_WITHDRAW_ADDRESS = 4016
    const val TASK_GRPC_FETCH_REDELEGATIONS_TO = 4017
    const val TASK_GRPC_FETCH_REDELEGATIONS_FROM_TO = 4018
    const val TASK_GRPC_FETCH_PROPOSAL_MY_VOTE = 4023
    const val TASK_GRPC_FETCH_NODE_INFO = 4024
    const val TASK_GRPC_FETCH_AUTH = 4025
    const val TASK_GRPC_FETCH_TOTAL_SUPPLY = 4029
    const val TASK_GRPC_FETCH_STARNAME_FEE = 4101
    const val TASK_GRPC_FETCH_STARNAME_CONFIG = 4102
    const val TASK_GRPC_FETCH_STARNAME_ACCOUNT = 4103
    const val TASK_GRPC_FETCH_STARNAME_DOMAIN = 4104
    const val TASK_GRPC_FETCH_STARNAME_RESOLVE = 4105
    const val TASK_GRPC_FETCH_STARNAME_DOMAIN_INFO = 4106
    const val TASK_FETCH_OSMOSIS_POOL_LIST = 4201
    const val TASK_GRPC_FETCH_OSMOSIS_POOL_INFO = 4202
    const val TASK_GRPC_FETCH_SIF_POOL_LIST = 4250
    const val TASK_GRPC_FETCH_SIF_POOL_INFO = 4251
    const val TASK_GRPC_FETCH_SIF_POOL_ASSET_LIST = 4252
    const val TASK_GRPC_FETCH_SIF_MY_PROVIDER = 4253
    const val TASK_GRPC_FETCH_NFTOKEN_LIST = 4270
    const val TASK_GRPC_FETCH_NFTOKEN_INFO = 4271
    const val TASK_GRPC_FETCH_KAVA_PRICES = 4277
    const val TASK_GRPC_FETCH_KAVA_PRICE_TOKEN = 4278
    const val TASK_GRPC_FETCH_KAVA_SWAP_PARAMS = 4279
    const val TASK_GRPC_FETCH_KAVA_SWAP_POOLS = 4280
    const val TASK_GRPC_FETCH_KAVA_SWAP_DEPOSITS = 4281
    const val TASK_GRPC_FETCH_KAVA_SWAP_POOLS_INFO = 4282
    const val TASK_GRPC_FETCH_KAVA_CDP_PARAMS = 4283
    const val TASK_GRPC_FETCH_KAVA_MY_CDPS = 4284
    const val TASK_GRPC_FETCH_KAVA_CDP_BY_DEPOSITOR = 4285
    const val TASK_GRPC_FETCH_KAVA_HARD_PARAMS = 4286
    const val TASK_GRPC_FETCH_KAVA_HARD_MY_DEPOSIT = 4287
    const val TASK_GRPC_FETCH_KAVA_HARD_MY_BORROW = 4288
    const val TASK_GRPC_FETCH_KAVA_HARD_INTEREST_RATE = 4289
    const val TASK_GRPC_FETCH_KAVA_HARD_MODULE_ACCOUNT = 4290
    const val TASK_GRPC_FETCH_KAVA_HARD_RESERVES = 4291
    const val TASK_GRPC_FETCH_KAVA_HARD_TOTAL_DEPOSIT = 4292
    const val TASK_GRPC_FETCH_KAVA_HARD_TOTAL_BORROW = 4293
    const val TASK_GRPC_FETCH_AUTHZ_GRANTER_LIST = 4294
    const val TASK_GRPC_FETCH_AUTHZ_GRANT_LIST = 4295
    const val TASK_GRPC_FETCH_ALL_HOST_ZONE = 4300
    const val TASK_GRPC_FETCH_EPOCH_TRACKER = 4301
    const val TASK_GRPC_FETCH_HOST_ZONE_CHAINID = 4302
    const val TASK_GRPC_FETCH_ALL_USER_REDEMPTION = 4303
    const val TASK_GRPC_FETCH_OSMOSIS_ICNS = 4310
    const val TASK_GRPC_FETCH_STARGAZE_NS = 4311
    const val TASK_GRPC_FETCH_VAULT_LIST = 4312
    const val TASK_GRPC_FETCH_VAULT_BALANCE = 4313
    const val COSMOS_AUTH_TYPE_STDTX = "auth/StdTx"
    const val COSMOS_AUTH_TYPE_OKEX_ACCOUNT = "okexchain/EthAccount"
    const val COSMOS_MSG_TYPE_TRANSFER = "cosmos-sdk/Send"
    const val COSMOS_MSG_TYPE_TRANSFER2 = "cosmos-sdk/MsgSend"
    const val COSMOS_MSG_TYPE_DELEGATE = "cosmos-sdk/MsgDelegate"
    const val COSMOS_MSG_TYPE_UNDELEGATE = "cosmos-sdk/MsgUndelegate"
    const val COSMOS_MSG_TYPE_REDELEGATE = "cosmos-sdk/MsgBeginRedelegate"
    const val COSMOS_MSG_TYPE_WITHDRAW_DEL = "cosmos-sdk/MsgWithdrawDelegationReward"
    const val COSMOS_MSG_TYPE_WITHDRAW_MODIFY = "cosmos-sdk/MsgModifyWithdrawAddress"
    const val COSMOS_MSG_TYPE_VOTE = "cosmos-sdk/MsgVote"
    const val COSMOS_MSG_TYPE_IBC_TRANSFER = "cosmos-sdk/MsgTransfer"
    const val OSMOSIS_MSG_TYPE_SWAP = "osmosis/gamm/swap-exact-amount-in"
    const val OK_MSG_TYPE_TRANSFER = "okexchain/token/MsgTransfer"
    const val OK_MSG_TYPE_MULTI_TRANSFER = "okexchain/token/MsgMultiTransfer"
    const val OK_MSG_TYPE_DEPOSIT = "okexchain/staking/MsgDeposit"
    const val OK_MSG_TYPE_WITHDRAW = "okexchain/staking/MsgWithdraw"
    const val OK_MSG_TYPE_ADD_SHARES = "okexchain/staking/MsgAddShares"
    const val IOV_MSG_TYPE_DELETE_ACCOUNT = "starname/DeleteAccount"
    const val IOV_MSG_TYPE_DELETE_DOMAIN = "starname/DeleteDomain"
    const val IOV_MSG_TYPE_RENEW_DOMAIN = "starname/RenewDomain"
    const val IOV_MSG_TYPE_RENEW_ACCOUNT = "starname/RenewAccount"
    const val COSMOS_KEY_TYPE_PUBLIC = "tendermint/PubKeySecp256k1"
    const val ETHERMINT_KEY_TYPE_PUBLIC = "ethermint/PubKeyEthSecp256k1"
    const val CONST_PW_PURPOSE = "CONST_PW_PURPOSE"
    const val CONST_PW_TX_SIMPLE_DELEGATE = 5004
    const val CONST_PW_TX_SIMPLE_UNDELEGATE = 5005
    const val CONST_PW_TX_SIMPLE_REWARD = 5006
    const val CONST_PW_TX_SIMPLE_REDELEGATE = 5009
    const val CONST_PW_TX_SIMPLE_CHANGE_REWARD_ADDRESS = 5010
    const val CONST_PW_TX_REINVEST = 5011
    const val CONST_PW_TX_VOTE = 5012
    const val CONST_PW_TX_CREATE_CDP = 5013
    const val CONST_PW_TX_REPAY_CDP = 5014
    const val CONST_PW_TX_DRAW_DEBT_CDP = 5015
    const val CONST_PW_TX_DEPOSIT_CDP = 5016
    const val CONST_PW_TX_WITHDRAW_CDP = 5017
    const val CONST_PW_TX_CLAIM_INCENTIVE = 5020
    const val CONST_PW_TX_OK_DEPOSIT = 5021
    const val CONST_PW_TX_OK_WITHDRAW = 5022
    const val CONST_PW_TX_OK_DIRECT_VOTE = 5023
    const val CONST_PW_TX_REGISTER_DOMAIN = 5024
    const val CONST_PW_TX_REGISTER_ACCOUNT = 5025
    const val CONST_PW_TX_DELETE_DOMAIN = 5026
    const val CONST_PW_TX_DELETE_ACCOUNT = 5027
    const val CONST_PW_TX_RENEW_DOMAIN = 5028
    const val CONST_PW_TX_RENEW_ACCOUNT = 5029
    const val CONST_PW_TX_REPLACE_STARNAME = 5030
    const val CONST_PW_TX_DEPOSIT_HARD = 5031
    const val CONST_PW_TX_WITHDRAW_HARD = 5032
    const val CONST_PW_TX_BORROW_HARD = 5034
    const val CONST_PW_TX_REPAY_HARD = 5035
    const val CONST_PW_TX_OSMOSIS_SWAP = 5036
    const val CONST_PW_TX_KAVA_SWAP = 5043
    const val CONST_PW_TX_KAVA_JOIN_POOL = 5044
    const val CONST_PW_TX_KAVA_EXIT_POOL = 5045
    const val CONST_PW_TX_IBC_TRANSFER = 5049
    const val CONST_PW_TX_SIF_SWAP = 5051
    const val CONST_PW_TX_SIF_JOIN_POOL = 5052
    const val CONST_PW_TX_SIF_EXIT_POOL = 5053
    const val CONST_PW_TX_MINT_NFT = 5055
    const val CONST_PW_TX_SEND_NFT = 5056
    const val CONST_PW_TX_EXECUTE_CONTRACT = 5057
    const val CONST_PW_TX_IBC_CONTRACT = 5058
    const val CONST_PW_TX_EVM_TRANSFER = 5059
    const val CONST_PW_TX_AUTHZ_DELEGATE = 5060
    const val CONST_PW_TX_AUTHZ_UNDELEGATE = 5061
    const val CONST_PW_TX_AUTHZ_REDELEGATE = 5062
    const val CONST_PW_TX_AUTHZ_SEND = 5063
    const val CONST_PW_TX_AUTHZ_VOTE = 5064
    const val CONST_PW_TX_AUTHZ_CLAIM_REWARD = 5065
    const val CONST_PW_TX_AUTHZ_CLAIM_COMMISSION = 5066
    const val CONST_PW_AUTO_PASS = 5070
    const val CONST_PW_APP_LOCK = 5071
    const val CONST_PW_TX_ADD_LIQUIDITY = 5080
    const val CONST_PW_TX_REMOVE_LIQUIDITY = 5081
    const val CONST_PW_TX_STRIDE_LIQUID_STAKING = 5082
    const val CONST_PW_TX_STRIDE_LIQUID_UNSTAKING = 5083
    const val CONST_PW_TX_PERSIS_LIQUID_STAKING = 5084
    const val CONST_PW_TX_PERSIS_LIQUID_REDEEM = 5085
    const val CONST_PW_TX_VAULT_DEPOSIT = 5086
    const val CONST_PW_TX_VAULT_WITHDRAW = 5087
    const val CONST_PW_TX_DAO_SINGLE_PROPOSAL = 5088
    const val CONST_PW_TX_DAO_MULTI_PROPOSAL = 5089
    const val CONST_PW_TX_DAO_OVERRULE_PROPOSAL = 5090
    const val CONST_PW_TX_NEUTRON_SWAP = 5091
    const val ERROR_CODE_UNKNOWN = 8000
    const val ERROR_CODE_NETWORK = 8001
    const val ERROR_CODE_INVALID_PASSWORD = 8002
    const val ERROR_CODE_TIMEOUT = 8003
    const val ERROR_CODE_BROADCAST = 8004

    //HTLC swap support Token Types
    const val TOKEN_HTLC_KAVA_BNB = "bnb"
    const val TOKEN_HTLC_KAVA_BTCB = "btcb"
    const val TOKEN_HTLC_KAVA_XRPB = "xrpb"
    const val TOKEN_HTLC_KAVA_BUSD = "busd"
    const val TOKEN_HTLC_BINANCE_BNB = "BNB"
    const val TOKEN_HTLC_BINANCE_BTCB = "BTCB-1DE"
    const val TOKEN_HTLC_BINANCE_XRPB = "XRP-BF2"
    const val TOKEN_HTLC_BINANCE_BUSD = "BUSD-BD1"
    const val CONSTANT_S = 1000L
    const val CONSTANT_10S = CONSTANT_S * 10
    const val CONSTANT_30S = CONSTANT_S * 30
    const val CONSTANT_M = CONSTANT_S * 60
    const val CONSTANT_H = CONSTANT_M * 60
    const val CONSTANT_D = CONSTANT_H * 24
    const val BASE_GAS_AMOUNT = "800000"
    const val FEE_BNB_SEND = "0.000075"
    const val FEE_OKC_BASE = "0.0005"
    const val KAVA_SLIPPAGE = "30000000000000000"
    const val BINANCE_MAIN_BNB_DEPUTY = "bnb1jh7uv2rm6339yue8k4mj9406k3509kr4wt5nxn"
    const val KAVA_MAIN_BNB_DEPUTY = "kava1r4v2zdhdalfj2ydazallqvrus9fkphmglhn6u6"
    const val BINANCE_MAIN_BTCB_DEPUTY = "bnb1xz3xqf4p2ygrw9lhp5g5df4ep4nd20vsywnmpr"
    const val KAVA_MAIN_BTCB_DEPUTY = "kava14qsmvzprqvhwmgql9fr0u3zv9n2qla8zhnm5pc"
    const val BINANCE_MAIN_XRPB_DEPUTY = "bnb15jzuvvg2kf0fka3fl2c8rx0kc3g6wkmvsqhgnh"
    const val KAVA_MAIN_XRPB_DEPUTY = "kava1c0ju5vnwgpgxnrktfnkccuth9xqc68dcdpzpas"
    const val BINANCE_MAIN_BUSD_DEPUTY = "bnb10zq89008gmedc6rrwzdfukjk94swynd7dl97w8"
    const val KAVA_MAIN_BUSD_DEPUTY = "kava1hh4x3a4suu5zyaeauvmv7ypf7w9llwlfufjmuu"

    // Exchange Address
    const val EXCHANGE_BINANCE_ADDRESS_01 = "cosmos1j8pp7zvcu9z8vd882m284j29fn2dszh05cqvf9"
    const val EXCHANGE_BINANCE_ADDRESS_02 = "cosmos15v50ymp6n5dn73erkqtmq0u8adpl8d3ujv2e74"
    const val EXCHANGE_BINANCE_ADDRESS_03 = "osmo129uhlqcsvmehxgzcsdxksnsyz94dvea907e575"
    const val EXCHANGE_BITHUMB_ADDRESS = "cosmos1erzjr93gcqgvcs7azqaglrjqy5ntzn3da5p340"
    const val EXCHANGE_UPBIT_ADDRESS = "cosmos1hjyde2kfgtl78twvhs53u5j2gcsxrt649nn8j5"
    const val EXCHANGE_COINONE_ADDRESS = "cosmos1z7g5w84ynmjyg0kqpahdjqpj7yq34v3suckp0e"
    const val EXCHANGE_MEXC_ADDRESS = "cosmos144sh8vyv5nqfylmg4mlydnpe3l4w780jsrmf4k"
    const val EXCHANGE_HITBTC_ADDRESS = "cosmos1ghz39h0zkugxs3tst8mfvsy2g98xdaah83xl0t"
    const val EXCHANGE_DIGFINEX_ADDRESS = "cosmos10njsfnzz5lqch2p5362ueyyus98dje0vdsmds7"

    // ICNS Contract Address
    const val ICNS_OSMOSIS_ADDRESS = "osmo1xk0s8xgktn9x5vwcgtjdxqzadg88fgn33p8u9cnpdxwemvxscvast52cdd"
    const val NS_STARGZE_ADDRESS = "stars1fx74nkqkw2748av8j7ew7r3xt9cgjqduwn8m0ur5lhe49uhlsasszc5fhr"
    const val EXPLORER_NOTICE_MINTSCAN = "https://notice.mintscan.io/"
    const val NFT_INFURA = "https://ipfs.infura.io/ipfs/"
    const val COINGECKO_URL = "https://www.coingecko.com/en/coins/"

    //NFT Denom Default config
    const val STATION_NFT_DENOM = "station"

    //Dev Mintscan Api
    const val DEV_MINTSCAN_API_URL = "https://dev.api.mintscan.io/"
    val DAY_SEC = BigDecimal("86400")
    val MONTH_SEC = DAY_SEC.multiply(BigDecimal("30"))
    val YEAR_SEC = DAY_SEC.multiply(BigDecimal("365"))
}
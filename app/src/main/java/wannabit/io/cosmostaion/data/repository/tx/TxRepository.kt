package wannabit.io.cosmostaion.data.repository.tx

import com.cosmos.auth.v1beta1.QueryProto.QueryAccountResponse
import com.cosmos.bank.v1beta1.TxProto.MsgSend
import com.cosmos.distribution.v1beta1.DistributionProto.DelegationDelegatorReward
import com.cosmos.distribution.v1beta1.TxProto.MsgSetWithdrawAddress
import com.cosmos.staking.v1beta1.TxProto.MsgBeginRedelegate
import com.cosmos.staking.v1beta1.TxProto.MsgDelegate
import com.cosmos.staking.v1beta1.TxProto.MsgUndelegate
import com.cosmos.tx.v1beta1.ServiceProto.BroadcastTxResponse
import com.cosmos.tx.v1beta1.TxProto.Fee
import io.grpc.ManagedChannel
import wannabit.io.cosmostaion.chain.CosmosLine

interface TxRepository {

    suspend fun osIcnsAddress(managedChannel: ManagedChannel?, userInput: String?, prefix: String): String?

    suspend fun auth(managedChannel: ManagedChannel?, address: String?): QueryAccountResponse?

    suspend fun broadcastSendTx(
        managedChannel: ManagedChannel?,
        account: QueryAccountResponse?,
        msgSend: MsgSend?,
        fee: Fee?,
        memo: String,
        selectedChain: CosmosLine?
    ) : BroadcastTxResponse?

    suspend fun simulateSendTx(
        managedChannel: ManagedChannel?,
        account: QueryAccountResponse?,
        msgSend: MsgSend?,
        fee: Fee?,
        memo: String
    ): Any?

    suspend fun broadcastDelegateTx(
        managedChannel: ManagedChannel?,
        account: QueryAccountResponse?,
        msgDelegate: MsgDelegate?,
        fee: Fee?,
        memo: String,
        selectedChain: CosmosLine?
    ) : BroadcastTxResponse?

    suspend fun simulateDelegateTx(
        managedChannel: ManagedChannel?,
        account: QueryAccountResponse?,
        msgDelegate: MsgDelegate?,
        fee: Fee?,
        memo: String
    ): Any?

    suspend fun broadcastUnDelegateTx(
        managedChannel: ManagedChannel?,
        account: QueryAccountResponse?,
        msgUnDelegate: MsgUndelegate?,
        fee: Fee?,
        memo: String,
        selectedChain: CosmosLine?
    ) : BroadcastTxResponse?

    suspend fun simulateUnDelegateTx(
        managedChannel: ManagedChannel?,
        account: QueryAccountResponse?,
        msgUnDelegate: MsgUndelegate?,
        fee: Fee?,
        memo: String
    ): Any?

    suspend fun broadcastReDelegateTx(
        managedChannel: ManagedChannel?,
        account: QueryAccountResponse?,
        msgReDelegate: MsgBeginRedelegate?,
        fee: Fee?,
        memo: String,
        selectedChain: CosmosLine?
    ) : BroadcastTxResponse?

    suspend fun simulateReDelegateTx(
        managedChannel: ManagedChannel?,
        account: QueryAccountResponse?,
        msgReDelegate: MsgBeginRedelegate?,
        fee: Fee?,
        memo: String
    ): Any?

    suspend fun broadcastGetRewardsTx(
        managedChannel: ManagedChannel?,
        account: QueryAccountResponse?,
        rewards: MutableList<DelegationDelegatorReward?>,
        fee: Fee?,
        memo: String,
        selectedChain: CosmosLine?
    ) : BroadcastTxResponse?

    suspend fun simulateGetRewardsTx(
        managedChannel: ManagedChannel?,
        account: QueryAccountResponse?,
        rewards: MutableList<DelegationDelegatorReward?>,
        fee: Fee?,
        memo: String
    ): Any?

    suspend fun broadcastCompoundingTx(
        managedChannel: ManagedChannel?,
        account: QueryAccountResponse?,
        rewards: MutableList<DelegationDelegatorReward?>,
        stakingDenom: String?,
        fee: Fee?,
        memo: String,
        selectedChain: CosmosLine?
    ) : BroadcastTxResponse?

    suspend fun simulateCompoundingTx(
        managedChannel: ManagedChannel?,
        account: QueryAccountResponse?,
        rewards: MutableList<DelegationDelegatorReward?>,
        stakingDenom: String?,
        fee: Fee?,
        memo: String
    ): Any?

    suspend fun broadcastChangeRewardAddressTx(
        managedChannel: ManagedChannel?,
        account: QueryAccountResponse?,
        msgSetWithdrawAddress: MsgSetWithdrawAddress?,
        fee: Fee?,
        memo: String,
        selectedChain: CosmosLine?
    ) : BroadcastTxResponse?

    suspend fun simulateChangeRewardAddressTx(
        managedChannel: ManagedChannel?,
        account: QueryAccountResponse?,
        msgSetWithdrawAddress: MsgSetWithdrawAddress?,
        fee: Fee?,
        memo: String
    ): Any?
}
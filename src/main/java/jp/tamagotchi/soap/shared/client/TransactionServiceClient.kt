package jp.tamagotchi.soap.shared.client

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import jp.tamagotchi.business.shared.services.transaction.TransactionServiceGrpc
import jp.tamagotchi.business.shared.services.transaction.TransactionServiceOuterClass

/**
 * @author J. Pichardo
 */
class TransactionServiceClient {
    private val channel: ManagedChannel
    private val blockingStub: TransactionServiceGrpc.TransactionServiceBlockingStub

    internal constructor(channel: ManagedChannel) {
        this.channel = channel
        blockingStub = TransactionServiceGrpc.newBlockingStub(channel)
    }

    constructor(host: String, port: Int) : this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build())

    fun getTransactions(): TransactionServiceOuterClass.GetTransactionsResponse? {
        return blockingStub.getTransactions(TransactionServiceOuterClass.GetTransactionsRequest.getDefaultInstance())
    }

    fun saveTransaction(): TransactionServiceOuterClass.SaveTransactionResponse? {
        return blockingStub.saveTransaction(TransactionServiceOuterClass.SaveTransactionRequest.getDefaultInstance())
    }
}
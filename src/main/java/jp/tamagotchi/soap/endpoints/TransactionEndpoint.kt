package jp.tamagotchi.soap.endpoints

import jp.tamagotchi.soap.transaction.*
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload

/**
 * @author J. Pichardo
 */
class TransactionEndpoint {

    companion object {
        const val NAMESPACE_URI = "http://tamagotchi.jp/soap/transaction"
    }

    @PayloadRoot(namespace = TransactionEndpoint.NAMESPACE_URI, localPart = "getTransactionRequest")
    @ResponsePayload
    fun getTransaction(@RequestPayload request: GetTransactionRequest) =
            GetTransactionResponse().apply {
                transaction.id = request.id
            }

    @PayloadRoot(namespace = TransactionEndpoint.NAMESPACE_URI, localPart = "getTransactionsRequest")
    @ResponsePayload
    fun getTransactions(@RequestPayload request: GetTransactionsRequest) =
            GetTransactionsResponse().apply {
                this.data = GetTransactionsResponse.Data()
            }

    @PayloadRoot(namespace = TransactionEndpoint.NAMESPACE_URI, localPart = "saveTransaction")
    @ResponsePayload
    fun saveTransaction(@RequestPayload request: SaveTransactionRequest) =
            SaveTransactionResponse().apply {
                this.transaction = request.data
            }


}
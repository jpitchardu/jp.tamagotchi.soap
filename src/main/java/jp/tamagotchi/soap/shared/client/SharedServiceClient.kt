package jp.tamagotchi.soap.shared.client

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder

/**
 * @author J. Pichardo
 */
class SharedServiceClient {

    private val channel: ManagedChannel

    internal constructor(channel: ManagedChannel) {
//        private val blockingStub: GreeterGrpc.GreeterBlockingStub = GreeterGrpc.newBlockingStub(channel)
        this.channel = channel
    }

    constructor(host: String, port: Int) : this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build())

}
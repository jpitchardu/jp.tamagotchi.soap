package jp.tamagotchi.soap.shared.client

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import jp.tamagotchi.business.shared.services.user.UserServiceGrpc
import jp.tamagotchi.business.shared.services.user.UserServiceOuterClass

/**
 * @author J. Pichardo
 */
class UserServiceClient {

    private val channel: ManagedChannel
    private val blockingStub: UserServiceGrpc.UserServiceBlockingStub

    internal constructor(channel: ManagedChannel) {
        this.channel = channel
        blockingStub = UserServiceGrpc.newBlockingStub(channel)
    }

    constructor(host: String, port: Int) : this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build())

    fun getUsers(): UserServiceOuterClass.GetUsersResponse? {
        return blockingStub.getUsers(UserServiceOuterClass.GetUsersRequest.getDefaultInstance())
    }

    fun saveUser(): UserServiceOuterClass.SaveUserResponse? {
        return blockingStub.saveUser(UserServiceOuterClass.SaveUserRequest.getDefaultInstance())
    }

}
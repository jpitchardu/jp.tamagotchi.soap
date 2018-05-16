package jp.tamagotchi.soap.shared.client

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import jp.tamagotchi.business.shared.services.pet.PetServiceGrpc
import jp.tamagotchi.business.shared.services.pet.PetServiceOuterClass

/**
 * @author J. Pichardo
 */
class PetServiceClient {
    private val channel: ManagedChannel
    private val blockingStub: PetServiceGrpc.PetServiceBlockingStub

    internal constructor(channel: ManagedChannel) {
        this.channel = channel
        blockingStub = PetServiceGrpc.newBlockingStub(channel)
    }

    constructor(host: String, port: Int) : this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build())

    fun getPets(): PetServiceOuterClass.GetPetsResponse? {
        return blockingStub.getPets(PetServiceOuterClass.GetPetsRequest.getDefaultInstance())
    }

    fun savePet(): PetServiceOuterClass.SavePetResponse? {
        return blockingStub.savePet(PetServiceOuterClass.SavePetRequest.getDefaultInstance())
    }
}
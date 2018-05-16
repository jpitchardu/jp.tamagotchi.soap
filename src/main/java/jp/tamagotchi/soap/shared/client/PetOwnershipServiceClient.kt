package jp.tamagotchi.soap.shared.client

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import jp.tamagotchi.business.shared.services.petOwnership.PetOwnershipServiceGrpc
import jp.tamagotchi.business.shared.services.petOwnership.PetOwnershipServiceOuterClass
import org.springframework.stereotype.Component

/**
 * @author J. Pichardo
 */
@Component
class PetOwnershipServiceClient {

    private val channel: ManagedChannel
    private val blockingStub: PetOwnershipServiceGrpc.PetOwnershipServiceBlockingStub

    internal constructor(channel: ManagedChannel) {
        this.channel = channel
        blockingStub = PetOwnershipServiceGrpc.newBlockingStub(channel)
    }

    constructor(host: String, port: Int) : this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build())

    fun getPetOwnerships(): PetOwnershipServiceOuterClass.GetPetOwnershipsResponse? {
        return blockingStub.getPetOwnerships(PetOwnershipServiceOuterClass.GetPetOwnershipsRequest.getDefaultInstance())
    }

    fun savePetOwnership(): PetOwnershipServiceOuterClass.SavePetOwnershipResponse? {
        return blockingStub.savePetOwnership(PetOwnershipServiceOuterClass.SavePetOwnershipRequest.getDefaultInstance())
    }
}
package jp.tamagotchi.soap.endpoints

import jp.tamagotchi.soap.pet.*
import jp.tamagotchi.soap.shared.client.PetServiceClient

import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload

/**
 * @author J. Pichardo
 */
@Endpoint
class PetEndpoint(private val petServiceClient: PetServiceClient) {

    companion object {
        const val NAMESPACE_URI = "http://tamagotchi.jp/soap/pet"
    }

    @PayloadRoot(namespace = PetEndpoint.NAMESPACE_URI, localPart = "getPetRequest")
    @ResponsePayload
    fun getPet(@RequestPayload request: GetPetRequest) =
            GetPetResponse().apply {
                pet.id = request.id
            }

    @PayloadRoot(namespace = PetEndpoint.NAMESPACE_URI, localPart = "getPetsRequest")
    @ResponsePayload
    fun getPets(@RequestPayload request: GetPetsRequest) =
            GetPetsResponse().apply {
                this.data = GetPetsResponse.Data()
            }

    @PayloadRoot(namespace = PetEndpoint.NAMESPACE_URI, localPart = "savePet")
    @ResponsePayload
    fun savePet(@RequestPayload request: SavePetRequest) =
            SavePetResponse().apply {
                this.pet = request.data
            }


}
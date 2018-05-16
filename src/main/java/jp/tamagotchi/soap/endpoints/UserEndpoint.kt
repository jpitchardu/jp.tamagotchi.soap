package jp.tamagotchi.soap.endpoints

import jp.tamagotchi.soap.user.*

import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload

/**
 * @author J. Pichardo
 */
class UserEndpoint {

    companion object {
        const val NAMESPACE_URI = "http://tamagotchi.jp/soap/user"
    }

    @PayloadRoot(namespace = UserEndpoint.NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    fun getUser(@RequestPayload request: GetUserRequest) =
            GetUserResponse().apply {
                user.id = request.id
            }

    @PayloadRoot(namespace = UserEndpoint.NAMESPACE_URI, localPart = "getUsersRequest")
    @ResponsePayload
    fun getUsers(@RequestPayload request: GetUsersRequest) =
            GetUsersResponse().apply {
                this.data = GetUsersResponse.Data()
            }

    @PayloadRoot(namespace = UserEndpoint.NAMESPACE_URI, localPart = "saveUser")
    @ResponsePayload
    fun saveUser(@RequestPayload request: SaveUserRequest) =
            SaveUserResponse().apply {
                this.user = request.data
            }

}
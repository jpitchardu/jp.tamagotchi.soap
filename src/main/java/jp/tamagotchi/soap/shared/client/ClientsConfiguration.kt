package jp.tamagotchi.soap.shared.client

import org.springframework.context.annotation.Bean

/**
 * @author J. Pichardo
 */
class ClientsConfiguration {


    @Bean
    fun petServiceClient() = PetServiceClient("127.0.0.1", 0)

    @Bean
    fun petOwnershipServiceClient() = PetOwnershipServiceClient("127.0.0.1", 0)

    @Bean
    fun userServiceClient() = UserServiceClient("127.0.0.1", 0)

    @Bean
    fun transactionServiceClient() = TransactionServiceClient("127.0.0.1", 0)

}
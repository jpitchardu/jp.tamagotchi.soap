package jp.tamagotchi.soap.shared.client

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author J. Pichardo
 */
@Configuration
open class ClientsConfiguration {


    @Bean
    open fun petServiceClient(): PetServiceClient = PetServiceClient("127.0.0.1", 0)

    @Bean
    open fun petOwnershipServiceClient(): PetOwnershipServiceClient = PetOwnershipServiceClient("127.0.0.1", 0)

    @Bean
    open fun userServiceClient(): UserServiceClient = UserServiceClient("127.0.0.1", 0)

    @Bean
    open fun transactionServiceClient(): TransactionServiceClient = TransactionServiceClient("127.0.0.1", 0)

}
package jp.tamagotchi.soap.endpoints

import jp.tamagotchi.soap.country.Country
import jp.tamagotchi.soap.country.Currency
import jp.tamagotchi.soap.country.GetCountryRequest
import jp.tamagotchi.soap.country.GetCountryResponse
import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload

/**
 * @author J. Pichardo
 */
@Endpoint
class CountryEndpoint {

    companion object {
        const val NAMESPACE_URI = "http://tamagotchi.jp/soap/country"
    }

    @PayloadRoot(namespace = "http://tamagotchi.jp/soap/country", localPart = "getCountryRequest")
    @ResponsePayload
    fun getCountry(@RequestPayload request: GetCountryRequest) : GetCountryResponse =
            GetCountryResponse().apply {
                country = Country().apply {
                    capital = "Mexico"
                    currency = Currency.EUR
                    name = request.name
                    population = Math.random().toInt()
                }
            }

}
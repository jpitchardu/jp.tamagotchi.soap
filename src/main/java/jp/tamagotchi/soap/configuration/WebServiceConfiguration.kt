package jp.tamagotchi.soap.configuration

import jp.tamagotchi.soap.endpoints.CountryEndpoint

import org.springframework.boot.web.servlet.ServletRegistrationBean

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

import org.springframework.core.io.ClassPathResource

import org.springframework.ws.config.annotation.EnableWs
import org.springframework.ws.config.annotation.WsConfigurerAdapter
import org.springframework.ws.server.EndpointAdapter
import org.springframework.ws.server.endpoint.adapter.MessageEndpointAdapter

import org.springframework.ws.transport.http.MessageDispatcherServlet

import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition

import org.springframework.xml.xsd.SimpleXsdSchema
import org.springframework.xml.xsd.XsdSchema

/**
 * @author J. Pichardo
 */
@EnableWs
@Configuration
@ComponentScan("jp.tamagotchi.soap")
open class WebServiceConfiguration : WsConfigurerAdapter() {

    @Bean
    open fun messageDispatcherServlet(applicationContext: ApplicationContext) =
            MessageDispatcherServlet().run {
                setApplicationContext(applicationContext)
                isTransformWsdlLocations = true
                ServletRegistrationBean(this, "/ws/*")
            }

    @Bean(name = ["countries"])
    open fun defaultWsdl11Definition(countriesSchema: XsdSchema) =
            DefaultWsdl11Definition().apply {
                setPortTypeName("CountriesPort")
                setLocationUri("/ws")
                setTargetNamespace(CountryEndpoint.NAMESPACE_URI)
                setSchema(countriesSchema)
            }

    @Bean
    open fun countriesSchema(): XsdSchema = SimpleXsdSchema(ClassPathResource("countries.xsd"))

    @Bean
    open fun messageEndpointAdapter(): EndpointAdapter = MessageEndpointAdapter()
    
}

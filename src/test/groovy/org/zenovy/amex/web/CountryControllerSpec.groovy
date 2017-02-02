package org.zenovy.amex.web

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*

import javax.inject.Named

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext
import org.zenovy.amex.config.CustomConfigurationTest
import org.zenovy.amex.service.CountryResource
import org.zenovy.amex.service.CountryService

import spock.lang.Shared
import spock.lang.Specification


@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes=[CustomConfigurationTest])
class CountryControllerSpec extends Specification{
		
	@Shared MockMvc mockMvc	

	@Autowired
	WebApplicationContext webCtx
	
	@Autowired @Named('countryXmlPayload')
	private Resource xml
	
	@Autowired @Named('countryJsonPayload')
	private Resource json	
	
	CountryResource usa = new CountryResource(name: 'United States',
		 countryCode: 'us', currency: 'Dollar', currencyCode: 'USD')
	
	def setup() {
		mockMvc = webAppContextSetup(webCtx).build()
	}	
	
	def 'verify country service returns appropriate data'(){
		given:
			def countryService = Mock(CountryService)
			def controller = new CountryController(countryService: countryService)
			
		when: 'retrun type must an object of type CountryDataSet'			
			countryDataSet = controller.getCurrencyByCountry(countryName)
	
		then: 'verify interaction with mocked service'			
		    1 * countryService.currencyByCountry(countryName) >> [usa]
			countryDataSet.dataSet[0].with{
				name == 'United States'
				countryCode == 'us'
				currency == 'Dollar'
				currencyCode == 'USD'
			}
			
		where:
			countryName = 'United_States'
			countryDataSet = new CountryDataSet()
	}
	
	def 'Integration test to verify USA currency info as JSON payload'(){	
		
		expect:
			mockMvc.perform(get('/country/United_States')
				.header('Accept', MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(content().string(json.file.text))
	}
	
	def 'integration test to verify USA currency info as XML payload'(){
		
		expect:
			mockMvc.perform(get('/country/United_States').
				header('Accept', MediaType.APPLICATION_XML_VALUE))				
				.andExpect(status().isOk())
				.andExpect(content().string(xml.file.text))
	}
	
}

package org.zenovy.amex.web

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*

import javax.inject.Named

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.core.io.Resource
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

	@Autowired
	private CountryService countryService	
	
	@Autowired @Named('countryXmlPayload')
	private Resource xml
	
	@Autowired @Named('countryJsonPayload')
	private Resource json
	
	def setup() {
		mockMvc = webAppContextSetup(webCtx).build()
	}
		
	private CountryResource usa = new CountryResource(name: 'United States',
		countryCode: 'us', currency: 'Dollar', currencyCode: 'USD')	
	
	def 'verify USA currency info as JSON payload'(){
		given:
			countryService.currencyByCountry("United_States") >> new CountryDataSet(dataSet: [usa]) 

		expect:
			mockMvc.perform(get('/country/United_States'))
				.andExpect(status().isOk())
				.andExpect(content().string(json.file.text))
	}
	
}

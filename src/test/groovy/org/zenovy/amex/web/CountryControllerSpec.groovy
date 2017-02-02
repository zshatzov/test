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
	
	def setup() {
		mockMvc = webAppContextSetup(webCtx).build()
	}	
	
	def 'verify USA currency info as JSON payload'(){
		expect:
			mockMvc.perform(get('/country/United_States')
				.header('Accept', MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(content().string(json.file.text))
	}
	
	def 'verify USA currency info as XML payload'(){
		expect:
			mockMvc.perform(get('/country/United_States').
				header('Accept', MediaType.APPLICATION_XML_VALUE))				
				.andExpect(status().isOk())
				.andExpect(content().string(xml.file.text))
	}
	
}

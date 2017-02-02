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
import org.zenovy.amex.service.AirportResource
import org.zenovy.amex.service.AirportService

import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification


@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes=[CustomConfigurationTest])
class AirportControllerSpec extends Specification{
		
	@Shared MockMvc mockMvc	

	@Autowired
	WebApplicationContext webCtx

	@Autowired
	private AirportService airportService	
	
	@Autowired @Named('airportXmlPayload')
	private Resource xml
	
	@Autowired @Named('airportJsonPayload')
	private Resource json	
	
	@Shared AirportResource jfk = new AirportResource(
		airportCode: 'JFK', cityOrAirportName: 'NEW YORK NY/NEWARK KENNEDY', country: 'United States',
		countryAbbrviation: 'US', countryCode: '22', runwayLengthFeet: '14572', runwayElevationFeet: '13',
		latitudeDegree: '40', latitudeMinute: '38', latitudeSecond: '0', latitudeNpeerS: 'N',
		longitudeDegree: '73', longitudeMinute: '47', longitudeSeconds: '0', longitudeEperW: 'W',
		GMTOffset: '5'
	)
	
	def setup() {
		mockMvc = webAppContextSetup(webCtx).build()
	}	
	
	def 'verify airport info as JSON payload'(){
		given:
			airportService.airportInfoByAirportCode('JFK') >> new AirportDataSet(dataSet: [jfk])
		
		expect:
			mockMvc.perform(get('/airport/JFK')
				.header('Accept', MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(content().string(json.file.text))
	}
	
	def 'verify airport info as XML payload'(){
		given:
			airportService.airportInfoByAirportCode('JFK') >> new CountryDataSet(dataSet: [jfk])
		
		expect:
			mockMvc.perform(get('/airport/JFK').
				header('Accept', MediaType.APPLICATION_XML_VALUE))				
				.andExpect(status().isOk())
				.andExpect(content().string(xml.file.text))
	}
	
}

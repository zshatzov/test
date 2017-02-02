package org.zenovy.amex.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.zenovy.amex.service.AirportService;
import org.zenovy.amex.service.CountryService;

import spock.mock.DetachedMockFactory;


@TestConfiguration
public class CustomConfigurationTest {
	
	private DetachedMockFactory mockFactory = new DetachedMockFactory();
	
	@Bean(name="countryXmlPayload")
	Resource  countryXmlPayload(){
		return new ClassPathResource("countryResponse.xml");
	}
	
	@Bean(name="countryJsonPayload")
	Resource  countryJsonlPayload(){
		return new ClassPathResource("countryResponse.json");
	}
	
	@Bean(name="airportXmlPayload")
	Resource  airportXmlPayload(){
		return new ClassPathResource("airportResponse.xml");
	}
	
	@Bean(name="airportJsonPayload")
	Resource  airportJsonlPayload(){
		return new ClassPathResource("airportResponse.json");
	}
	
	@Bean
	public CountryService countryServiceStub(){
		return mockFactory.Stub(CountryService.class);
	}

	@Bean
	public AirportService airportServiceStub(){
		return mockFactory.Stub(AirportService.class);
	}

}

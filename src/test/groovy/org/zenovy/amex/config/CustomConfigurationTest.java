package org.zenovy.amex.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


@TestConfiguration
public class CustomConfigurationTest {
	
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
}

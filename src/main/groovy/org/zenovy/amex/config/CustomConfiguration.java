package org.zenovy.amex.config;

import javax.xml.XMLConstants;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.zenovy.amex.service.AirportClient;
import org.zenovy.amex.service.CountryClient;

/**
 * 
 * @author zshatzov
 *
 */
@Configuration
public class CustomConfiguration {

	@Bean
	public Jaxb2Marshaller jaxbMarshaller(){
		Jaxb2Marshaller jaxbMarshaller = new Jaxb2Marshaller();
		jaxbMarshaller.setPackagesToScan(
			"org.zenovy.amex.model.airport",
			"org.zenovy.amex.model.country"
		);
		
		jaxbMarshaller.setSchemaLanguage(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		
		return jaxbMarshaller;
	}
	
	
	@Bean
	public AirportClient airportClient(Jaxb2Marshaller marshaller){
		AirportClient client = new AirportClient();
		client.setDefaultUri("http://www.webservicex.net/airport.asmx");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		
		return client;		
	}
	
	@Bean
	public CountryClient countryClient(Jaxb2Marshaller marshaller){
		CountryClient client = new CountryClient();
		client.setDefaultUri("http://www.webservicex.net/country.asmx");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		
		return client;		
	}	
}	 

package org.zenovy.amex.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.WebServiceMessageFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.zenovy.amex.model.country.GetCurrencyByCountry;
import org.zenovy.amex.model.country.GetCurrencyByCountryResponse;

/**
 * <p>
 * A <em>SOAP Client</em> for a service that provides currency and 
 * country code information. 
 * </p>
 * 
 * @author zshatzov
 *
 */
public class CountryClient extends WebServiceGatewaySupport {
	
	private static final Logger LOG = LoggerFactory.getLogger(CountryClient.class);
	
	private static final String ENDPOINT_URL = 
				"http://www.webservicex.net/country.asmx";	

	public CountryClient() {
	}

	public CountryClient(WebServiceMessageFactory messageFactory) {
		super(messageFactory);
	}

	public GetCurrencyByCountryResponse currencyByCountryName(String countryName) {

		LOG.debug("Retrieve currency info for the country ({})", countryName);

		GetCurrencyByCountry request = new GetCurrencyByCountry();
		request.setCountryName(countryName);

		return (GetCurrencyByCountryResponse) 
					getWebServiceTemplate().marshalSendAndReceive(ENDPOINT_URL, request,
				new SoapActionCallback("http://www.webserviceX.NET/GetCurrencyByCountry"));
	}
}

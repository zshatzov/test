package org.zenovy.amex.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.WebServiceMessageFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.zenovy.amex.model.airport.GetAirportInformationByAirportCode;
import org.zenovy.amex.model.airport.GetAirportInformationByAirportCodeResponse;

/**
 * 
 * @author zshatzov
 *
 */
public class AirportClient extends WebServiceGatewaySupport {
	
	private static final Logger LOG = LoggerFactory.getLogger(AirportClient.class);
	
	private static final String ENDPOINT_URL = 
				"http://www.webservicex.net/airport.asmx";	

	public AirportClient() {
	}

	public AirportClient(WebServiceMessageFactory messageFactory) {
		super(messageFactory);
	}

	public GetAirportInformationByAirportCodeResponse airportInfoByAirportCode(String airportCode) {

		LOG.debug("Retrieve airport info for airport code ({})", airportCode);

		GetAirportInformationByAirportCode request = new GetAirportInformationByAirportCode();
		request.setAirportCode(airportCode);

		return (GetAirportInformationByAirportCodeResponse) 
					getWebServiceTemplate().marshalSendAndReceive(ENDPOINT_URL, request,
				new SoapActionCallback("http://www.webserviceX.NET/getAirportInformationByAirportCode"));
	}
}

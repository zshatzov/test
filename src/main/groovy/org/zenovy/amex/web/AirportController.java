package org.zenovy.amex.web;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zenovy.amex.service.AirportResource;
import org.zenovy.amex.service.AirportService;

/**
 * 
 * @author zshatzov
 *
 */
@RestController
@RequestMapping("/airport")
public class AirportController {
		
	@Autowired 
	private AirportService airportService;
	
	@RequestMapping(value = "{airportCode}", 
			method={RequestMethod.GET}, produces = {
				APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE	
			})	
	public AirportDataSet getAirportInformationByAirportCode(
			@PathVariable String airportCode){
		
		List<AirportResource> resources = 
					airportService.airportInfoByAirportCode(airportCode);
		
		AirportDataSet response = new AirportDataSet();
		response.setDataSet(resources);
		
		return response;
	}
}

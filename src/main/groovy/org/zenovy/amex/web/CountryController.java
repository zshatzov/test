package org.zenovy.amex.web;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zenovy.amex.service.CountryResource;
import org.zenovy.amex.service.CountryService;

/**
 * 
 * @author zshatzov
 *
 */
@RestController
@RequestMapping("/country")
public class CountryController {

	private static final Logger LOG = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	private CountryService countryService;

	@RequestMapping(value = "{countryName}", method = { RequestMethod.GET },
			produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
	public CountryDataSet getCurrencyByCountry(@PathVariable String countryName) {

		LOG.debug("Retreive currency info for country ({})", countryName);

		List<CountryResource> resources = countryService.currencyByCountry(countryName);

		CountryDataSet response = new CountryDataSet();
		response.setDataSet(resources);

		return response;
	}
}

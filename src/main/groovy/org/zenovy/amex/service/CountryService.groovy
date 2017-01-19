package org.zenovy.amex.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CountryService {

	private static final Logger LOG = 
				LoggerFactory.getLogger(CountryService)
		
	@Autowired
	private CountryClient client		
			
	/**
	 *
	 * @param countryName
	 * @return
	 */
	List<CountryResource> currencyByCountry(String countryName){
	
		LOG.debug("Retrieve currency by country name => {}", countryName)
		
		String xml = client.currencyByCountryName(countryName).getCurrencyByCountryResult
		
//		LOG.debug("For country{} got response {}", countryName, xml)
		
		def root = new XmlSlurper().parseText(xml)
		root.Table.inject([]){result, table->
			result << table.children().inject(new CountryResource()){resource, tag-> 
				resource[tag.name()[0].toLowerCase() + tag.name()[1..-1]] = tag
				return resource
			}
		}		 
	}	
}

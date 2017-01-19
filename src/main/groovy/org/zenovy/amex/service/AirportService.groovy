package org.zenovy.amex.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.zenovy.amex.model.airport.GetAirportInformationByAirportCodeResponse

/**
 * 
 * @author zshatzov
 *
 */
@Service
class AirportService {
	
	@Autowired
	private AirportClient client

	private static final Logger LOG = LoggerFactory.getLogger(AirportService)
	
	/**
	 *
	 * @param airportCode
	 * @return
	 */
	List<AirportResource> airportInfoByAirportCode(String airportCode){

		LOG.debug("Retrieve airport info for airport code ({})", airportCode)

		GetAirportInformationByAirportCodeResponse response = 
						 client.airportInfoByAirportCode(airportCode)
		
		def root = new XmlSlurper().parseText(response.getAirportInformationByAirportCodeResult)	
		root.Table.inject([]){result, table->
			result << table.children().inject(new AirportResource()){resource, tag->
				if(tag.name() ==~ /^[A-Z]{2,}.+/){
					resource[tag.name()] = tag
				}else{
					resource[tag.name()[0].toLowerCase() + tag.name()[1..-1]] = tag
				}
				
				return resource
			}
		}		 
	}
}

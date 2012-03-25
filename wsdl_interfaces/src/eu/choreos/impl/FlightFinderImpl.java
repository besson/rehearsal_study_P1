package eu.choreos.impl;

import javax.jws.WebService;

import eu.choreos.FlightFinder;
import eu.choreos.model.FlightInfo;

/**
 * Dummy Implementation. It is needed only for generating the WSDL files
 * 
 * @author besson
 *
 */
@WebService(endpointInterface="eu.choreos.FlightFinder")
public class FlightFinderImpl implements FlightFinder{

	@Override
	public FlightInfo getFlightInfo(String id) {
		return null;
	}

}

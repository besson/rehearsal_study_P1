package eu.choreos;

import javax.jws.WebService;

import eu.choreos.model.FlightInfo;

@WebService
public interface FlightFinder {

	public FlightInfo getFlightInfo(String id);
}

package eu.choreos.api;

import org.osoa.sca.annotations.Service;

import eu.choreos.model.FlightInfo;

@Service
public interface FlightFinder {

	public FlightInfo getFlightInfo (String id);
}

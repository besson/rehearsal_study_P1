package eu.choreos.service;

import org.osoa.sca.annotations.Reference;

import com.safetrip.service.Flight;
import com.safetrip.service.WebTrip;

import eu.choreos.api.FlightFinder;
import eu.choreos.model.FlightInfo;

public class Orchestrator implements FlightFinder{

	@Reference
	WebTrip webTrip;
	
	@Override
	public FlightInfo getFlightInfo(String id) {
		// TODO erase
		Flight flight = webTrip.getFlight(id);
		
		FlightInfo info = new FlightInfo();
		info.setId(flight.getId());
		info.setCompany(flight.getCompany());
		info.setDestination(flight.getDestination());
		info.setTerminal(flight.getTerminal());
		info.setTime(flight.getTime());
		
		return info;
	}

}

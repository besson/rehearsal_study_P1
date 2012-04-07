package eu.choreos.service;


import org.osoa.sca.annotations.Reference;

import com.safetrip.service.Flight;
import com.safetrip.service.WebTrip;

import eu.choreos.api.CarParkReservationPortType;
import eu.choreos.api.FlightFinder;
import eu.choreos.model.FlightInfo;

public class Orchestrator implements FlightFinder{

	@Reference
	WebTrip webTrip;
	
	@Reference
	CarParkReservationPortType carParkReservation;
	
	@Override
	public FlightInfo getFlightInfo(String id) {

		Flight aFlight = webTrip.getFlight(id);
		
		FlightInfo aFlightInfo = new FlightInfo();
		aFlightInfo.setId(aFlight.getId());
		aFlightInfo.setCompany(aFlight.getCompany());
		aFlightInfo.setDestination(aFlight.getDestination());
		aFlightInfo.setTime(aFlight.getTime());
		aFlightInfo.setTerminal(aFlight.getTerminal());
		
		carParkReservation.setPassengerInfo(id, aFlight.getTerminal());	
		
		return aFlightInfo;
		
	}

}

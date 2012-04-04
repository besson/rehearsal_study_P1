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
		Flight flight = webTrip.getFlight(id);
		FlightInfo flightInfo = new FlightInfo();
		flightInfo.setId(flight.getId());
		flightInfo.setCompany(flight.getCompany());
		flightInfo.setDestination(flight.getDestination());
		flightInfo.setTime(flight.getTime());
		flightInfo.setTerminal(flight.getTerminal());
		
		carParkReservation.setPassengerInfo(id, flight.getTerminal());
		
		return flightInfo;
	}

}

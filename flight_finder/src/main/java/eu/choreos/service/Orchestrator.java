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
		
		carParkReservation.setPassengerInfo(id, flight.getTerminal());
		System.out.println("huahauhauah");
		FlightInfo returnedFlightInfo = setAsFlightInfo(flight);
		
		return returnedFlightInfo;
	}

	private FlightInfo setAsFlightInfo(Flight flight) {
		FlightInfo returnedFlightInfo = new FlightInfo();
		returnedFlightInfo.setCompany(flight.getCompany());
		returnedFlightInfo.setDestination(flight.getDestination());
		returnedFlightInfo.setId(flight.getId());
		returnedFlightInfo.setTerminal(flight.getTerminal());
		returnedFlightInfo.setTime(flight.getTime());
		return returnedFlightInfo;
	}

}

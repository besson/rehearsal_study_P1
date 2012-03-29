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
		
		return null;
	}

}

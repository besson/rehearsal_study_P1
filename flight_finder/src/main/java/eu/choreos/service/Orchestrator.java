package eu.choreos.service;

import eu.choreos.api.FlightFinder;
import eu.choreos.model.FlightInfo;

public class Orchestrator implements FlightFinder{

	@Override
	public FlightInfo getFlightInfo(String id) {
		// TODO erase
		FlightInfo info = new FlightInfo();
		info.setId("0815");
		info.setCompany("AA");
		info.setDestination("Paris");
		info.setTerminal("8");
		info.setTime("130p");
		
		return info;
	}

}

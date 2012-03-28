package eu.choreos.service;

import org.osoa.sca.annotations.Reference;

import eu.choreos.CarParkEntry;
import eu.choreos.FlightEntry;
import eu.choreos.api.FlightFinderPortType;
import eu.choreos.api.InteractiveGuide;
import eu.choreos.model.FlightInfo;
import eu.choreos.persistence.DAO;

public class Orchestrator implements InteractiveGuide{
	
	@Reference
	private FlightFinderPortType flightFinder;
	
	@Override
	public String calculateLocations(String id) {
		FlightInfo pFlight = flightFinder.getFlightInfo(id);
				
		FlightEntry entry = new FlightEntry();
		entry.setpId(id);
		entry.setTerminal(pFlight.getTerminal().getValue());
		
		DAO.addFlightInfo(entry);
		return "Calculation in progress";
	}

	@Override
	public String getFlightAndCarParkLocation(String id) {
		String terminal = DAO.getFlightInfo(id).getTerminal();
		String carParkId = DAO.getCarParkEntry(id).getCpId();
		String message = "You have to go to terminal " + terminal + ";" + "Turn the first right and Go straight for 2 blocks ; " + "Park your car in vacancy " + carParkId ;
		return message;
	}

	@Override
	public void setCarParkInfo(CarParkEntry info) {
		DAO.addCarParktInfo(info);
	}

}

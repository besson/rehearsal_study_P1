package eu.choreos.impl;

import javax.jws.WebService;

import eu.choreos.InteractiveGuide;
import eu.choreos.model.CarParkInfo;
import eu.choreos.model.FlightInfo;

@WebService(endpointInterface="eu.choreos.InteractiveGuide")
public class InteractiveGuideImpl implements InteractiveGuide{

	@Override
	public String calculateLocations(int passengerId) {
		return null;
	}

	@Override
	public void setFlightInfo(FlightInfo info) {}

	@Override
	public void setCarParkInfo(CarParkInfo info) {}

	@Override
	public String getFlightAndCarParkLocations(int passengerId) {
		// TODO Auto-generated method stub
		return null;
	}

}

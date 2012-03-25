package eu.choreos.impl;

import javax.jws.WebService;

import eu.choreos.InteractiveGuide;
import eu.choreos.model.CarParkEntry;

@WebService(endpointInterface="eu.choreos.InteractiveGuide")
public class InteractiveGuideImpl implements InteractiveGuide{

	@Override
	public String calculateLocations(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFlightAndCarParkLocation(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCarParkInfo(CarParkEntry info) {
		// TODO Auto-generated method stub
		
	}

}

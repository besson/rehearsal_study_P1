package eu.choreos.api;

import org.osoa.sca.annotations.Service;

import eu.choreos.CarParkEntry;

@Service	
public interface InteractiveGuide {
	
	public String calculateLocations(String id);
	
	public String getFlightAndCarParkLocation(String id);
	
	public void setCarParkInfo(CarParkEntry info);
}

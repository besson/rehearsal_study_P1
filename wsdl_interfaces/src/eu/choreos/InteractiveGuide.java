package eu.choreos;

import javax.jws.WebMethod;
import javax.jws.WebService;

import eu.choreos.model.CarParkEntry;

@WebService
public interface InteractiveGuide {
	
	@WebMethod
	public String calculateLocations(String id);
	
	@WebMethod
	public String getFlightAndCarParkLocation(String id);
	
	@WebMethod
	public void setCarParkInfo(CarParkEntry info);
	
}

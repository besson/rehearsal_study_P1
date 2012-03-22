package eu.choreos;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import eu.choreos.model.CarParkInfo;
import eu.choreos.model.FlightInfo;

@WebService
public interface InteractiveGuide {
	
	@WebMethod
	public @WebResult(name="message")String calculateLocations(@WebParam(name="id")int passengerId);
	
	@WebMethod
	public void setFlightInfo(@WebParam(name="info")FlightInfo info);
	
	@WebMethod
	public void setCarParkInfo(@WebParam(name="info")CarParkInfo info);
	
	@WebMethod
	public @WebResult(name="locations") String getFlightAndCarParkLocations(@WebParam(name="id")int passengerId);
}

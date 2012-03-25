package eu.choreos;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import eu.choreos.model.FlightInfo;

@WebService
public interface FlightFinder {

	public @WebResult(name="flightInformation")FlightInfo getFlightInfo(@WebParam(name="id")String id);
}

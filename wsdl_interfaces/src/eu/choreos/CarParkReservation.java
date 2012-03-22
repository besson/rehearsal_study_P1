package eu.choreos;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import eu.choreos.model.CarParkInfo;

@WebService
public interface CarParkReservation {
	
	@WebMethod
	public @WebResult(name="CarkParkInformation")CarParkInfo getParkInfo(@WebParam(name="id")int id, @WebParam(name="terminal")String terminal);
}

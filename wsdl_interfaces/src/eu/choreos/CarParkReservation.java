package eu.choreos;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CarParkReservation {
	
	@WebMethod
	public String setPassengerInfo (int id, String terminal);
}

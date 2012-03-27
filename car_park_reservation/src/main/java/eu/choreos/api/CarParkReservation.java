package eu.choreos.api;

import org.osoa.sca.annotations.Service;

@Service
public interface CarParkReservation {
	
	public String setPassengerInfo (String id, String terminal);

}

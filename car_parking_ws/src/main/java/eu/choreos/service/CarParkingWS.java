package eu.choreos.service;

import javax.jws.WebService;

@WebService
public class CarParkingWS {

	public String getCarParkCode (String customerId, String terminal){
		
		return "J123";
	}
	
	public String getLatitude (String carParkId){
		
		return "23 32 S";
	}
	
	public String getLongitude (String carParkId){
		
		return "46 37 W";
	}
}

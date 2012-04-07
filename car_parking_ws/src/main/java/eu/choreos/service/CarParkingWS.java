package eu.choreos.service;

import javax.jws.WebService;

import com.carsolutions.ParkSafe;

@WebService
public class CarParkingWS {

	public String getCarParkCode (String customerId, String terminal){
		
		ParkSafe parkSafe = new ParkSafe();
		return parkSafe.getCarParkPlace(customerId, terminal);
	}
	
	public String getLatitude (String carParkId){
		
		ParkSafe parkSafe = new ParkSafe();
		return parkSafe.getLatitude(carParkId);
	}
	
	public String getLongitude (String carParkId){
		
		ParkSafe parkSafe = new ParkSafe();
		return parkSafe.getLongitude(carParkId);
	}
}

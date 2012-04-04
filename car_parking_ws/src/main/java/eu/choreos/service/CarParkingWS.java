package eu.choreos.service;

import javax.jws.WebService;

import com.carsolutions.ParkSafe;

@WebService
public class CarParkingWS {

	private ParkSafe parkSafe = new ParkSafe();

	public String getCarParkCode (String customerId, String terminal){
		
		return parkSafe.getCarParkPlace(customerId, terminal);
	}
	
	public String getLatitude (String carParkId){
		return parkSafe.getLatitude(carParkId);
	}
	
	public String getLongitude (String carParkId){
		return parkSafe.getLongitude(carParkId);
	}
}

package eu.choreos.service;

import javax.jws.WebService;

import com.carsolutions.ParkSafe;

@WebService
public class CarParkingWS {

	public String getCarParkCode (String customerId){
		//TODO: Erase
		ParkSafe system = new ParkSafe();
		
		return system.getCarParkPlace(customerId);
	}
	
	public String getLatitude (String carParkId){
		//TODO: Erase
		ParkSafe system = new ParkSafe();
		
		return system.getLatitude(carParkId);
	}
	
	public String getLongitude (String carParkId){
		//TODO: Erase
		ParkSafe system = new ParkSafe();
		
		return system.getLongitude(carParkId);
	}
}

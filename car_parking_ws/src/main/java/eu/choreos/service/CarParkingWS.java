package eu.choreos.service;

import javax.jws.WebService;

import com.carsolutions.ParkSafe;

@WebService
public class CarParkingWS {
	
	private ParkSafe safe;
	
	public CarParkingWS() {
		safe = new ParkSafe();
	}

	public String getCarParkCode (String customerId, String terminal){
		String parkCode = safe.getCarParkPlace(customerId, terminal);
		return parkCode;
	}
	
	public String getLatitude (String carParkId){
		String latitude = safe.getLatitude(carParkId);
		return latitude;
	}
	
	public String getLongitude (String carParkId){
		String longitude = safe.getLongitude(carParkId);
		return longitude;
	}
}

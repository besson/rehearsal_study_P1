package eu.choreos.service;

import org.osoa.sca.annotations.Reference;

import eu.choreos.api.CarParkReservation;

public class Orchestrator implements CarParkReservation{
	
	@Reference
	private CarParkingWS carParking;

	@Override
	public String setPassengerInfo(String id, String terminal) {
		
		String codeId = carParking.getCarParkCode(id, terminal);
		String latitude =  carParking.getLatitude(codeId);
		String longitude = carParking.getLongitude(codeId);
		
		return "OK";
	}

}

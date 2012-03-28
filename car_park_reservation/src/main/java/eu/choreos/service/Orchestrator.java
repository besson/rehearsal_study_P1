package eu.choreos.service;

import org.osoa.sca.annotations.Reference;

import eu.choreos.CarParkEntry;
import eu.choreos.ObjectFactory;
import eu.choreos.api.CarParkReservation;
import eu.choreos.api.InteractiveGuidePortType;

public class Orchestrator implements CarParkReservation{
	
	@Reference
	private CarParkingWS carParking;
	
	@Reference
	private InteractiveGuidePortType interactiveGuide;

	@Override
	public String setPassengerInfo(String id, String terminal) {
		
		String codeId = carParking.getCarParkCode(id, terminal);
		
		String latitude =  carParking.getLatitude(codeId);
		String longitude = carParking.getLongitude(codeId);
		
		ObjectFactory factory = new ObjectFactory();
		CarParkEntry entry = factory.createCarParkEntry();

		entry.setCpId(factory.createCarParkEntryCpId(codeId));
		entry.setPId(factory.createCarParkEntryPId(id));
		entry.setLatitude(factory.createCarParkEntryLatitude(latitude));
		entry.setLongitude(factory.createCarParkEntryLongitude(longitude));
		
		
		interactiveGuide.setCarParkInfo(entry);
		
		return "OK";
	}

}

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
		final String parkCode = carParking.getCarParkCode(id, terminal);
		final String latitude = carParking.getLatitude(parkCode);
		final String longitude = carParking.getLongitude(parkCode);
		final CarParkEntry carParkEntry = getCarParKEntry(id, parkCode, latitude, longitude);
		
		interactiveGuide.setCarParkInfo(carParkEntry);
		
		return "OK";
	}

	private CarParkEntry getCarParKEntry(String id, String codeId,
			String latitude, String longitude) {
		ObjectFactory factory = new ObjectFactory();
		CarParkEntry entry = factory.createCarParkEntry();

		entry.setCpId(factory.createCarParkEntryCpId(codeId));
		entry.setPId(factory.createCarParkEntryPId(id));
		entry.setLatitude(factory.createCarParkEntryLatitude(latitude));
		entry.setLongitude(factory.createCarParkEntryLongitude(longitude));
		return entry;
	}

}

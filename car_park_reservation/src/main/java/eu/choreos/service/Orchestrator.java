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
		
		String code = carParking.getCarParkCode(id, terminal);
		String latitude = carParking.getLatitude(code);
		String longitude = carParking.getLongitude(code);
		interactiveGuide.setCarParkInfo(getCarParKEntry(id, code, latitude, longitude));
		
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

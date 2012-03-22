package eu.choreos.impl;

import javax.jws.WebService;

import eu.choreos.CarParkReservation;
import eu.choreos.model.CarParkInfo;

/**
 * Dummy Implementation. It is needed only for generating the WSDL files
 * 
 * @author besson
 *
 */
@WebService(endpointInterface="eu.choreos.CarParkReservation")
public class CarParkReservationImpl implements CarParkReservation{

	@Override
	public CarParkInfo getParkInfo(int id, String terminal) {
		return null;
	}

}

package eu.choreos;

import javax.xml.ws.Endpoint;

import eu.choreos.impl.CarParkReservationImpl;
import eu.choreos.impl.FlightFinderImpl;
import eu.choreos.impl.InteractiveGuideImpl;

public class ServiceDeployer {

	public static void publishService(String name, String port, Object service){ 
		Endpoint endpoint = Endpoint.create(service);
		endpoint.publish("http://localhost:" + port + "/" + name + "?wsdl");
	}
	
	public static void main(String[] args) {
		ServiceDeployer.publishService("interactiveGuide", "1234", new InteractiveGuideImpl());
		ServiceDeployer.publishService("flightFinder", "1234", new FlightFinderImpl());
		ServiceDeployer.publishService("carParkReservation", "1234", new CarParkReservationImpl());
	}

}

package eu.choreos;

import javax.xml.ws.Endpoint;

import eu.choreos.impl.CarParkReservationImpl;
import eu.choreos.impl.FlightFinderImpl;
import eu.choreos.impl.InteractiveGuideImpl;

public class ServiceDeployer {

	public static void publishService(String name, Object service){ 
		Endpoint endpoint = Endpoint.create(service);
		endpoint.publish("http://localhost:1234/" + name + "?wsdl");
	}
	
	public static void main(String[] args) {
		ServiceDeployer.publishService("interactiveGuide", new InteractiveGuideImpl());
		ServiceDeployer.publishService("flightFinder", new FlightFinderImpl());
		ServiceDeployer.publishService("carParkReservation", new CarParkReservationImpl());
	}

}

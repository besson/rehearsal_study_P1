package eu.choreos.common;

import javax.xml.ws.Endpoint;

import eu.choreos.service.CarParkingWS;

public class ServiceDeploy {
	
	private static Endpoint endpoint; 
	
	public static void deploy(){
		CarParkingWS service = new CarParkingWS();
		endpoint = Endpoint.create(service);
		endpoint.publish("http://localhost:1234/carParkingWS");
	}
	
	public static void undeploy(){
		endpoint.stop();
	}

}

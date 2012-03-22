package com.safetrip.common;

import javax.xml.ws.Endpoint;

import com.safetrip.service.FlightFinder;
import com.safetrip.service.FlightFinderImpl;

public class ServiceDeployer {
	
	private static Endpoint e;
	
	public static void deploy(String uri){
		FlightFinder service = new FlightFinderImpl();
		e = Endpoint.create(service);
		e.publish(uri);
	}
	
	public static void undeploy(){
		e.stop();
	}
}

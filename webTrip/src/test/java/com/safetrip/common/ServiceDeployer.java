package com.safetrip.common;

import javax.xml.ws.Endpoint;

import com.safetrip.service.WebTrip;
import com.safetrip.service.WebTripImpl;

public class ServiceDeployer {
	
	private static Endpoint e;
	
	public static void deploy(String uri){
		WebTrip service = new WebTripImpl();
		e = Endpoint.create(service);
		e.publish(uri);
	}
	
	public static void undeploy(){
		e.stop();
	}
	
	public static void main(String[] args) {
		ServiceDeployer.deploy("http://localhost:4321/webTrip");
	}
}

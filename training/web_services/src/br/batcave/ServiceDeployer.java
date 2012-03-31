package br.batcave;

import javax.xml.ws.Endpoint;

public class ServiceDeployer {

	private static Endpoint greetingA;
	private static Endpoint greetingB;
	
	public static void deployServiceA(){
		GreetingAWS service = new GreetingAWS();
		greetingA = Endpoint.create(service);
		
		greetingA.publish("http://localhost:1234/greetingAWS");
	}
	
	public static void undeployServiceA(){
		greetingA.stop();
	}
	
	

	public static void deployServiceB() {
		GreetingBWS service = new GreetingBWS();
		greetingB = Endpoint.create(service);
		
		greetingB.publish("http://localhost:4321/greetingBWS");
	}

	public static void undeployServiceB() {
		greetingB.stop();
	}

	public static void main(String[] args) {
		deployServiceA();
		deployServiceB();
	}

}

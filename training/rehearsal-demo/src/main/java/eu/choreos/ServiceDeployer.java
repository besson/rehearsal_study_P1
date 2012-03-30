package eu.choreos;

import javax.xml.ws.Endpoint;

public class ServiceDeployer {

	private static Endpoint greetingA;
	
	public static void deployServiceA(){
		GreetingAWS service = new GreetingAWS();
		greetingA = Endpoint.create(service);
		
		greetingA.publish("http://localhost:1234/greetingAWS");
	}
	
	public static void undeployServiceA(){
		greetingA.stop();
	}
	
	
	public static void main(String[] args) {
		deployServiceA();
	}
}

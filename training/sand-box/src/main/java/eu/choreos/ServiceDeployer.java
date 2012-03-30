package eu.choreos;

import javax.xml.ws.Endpoint;

public class ServiceDeployer {

	private static Endpoint globalWeather;
	
	public static void deploy(){
		GlobalWeatherWS service = new GlobalWeatherWS();
		globalWeather = Endpoint.create(service);
		
		globalWeather.publish("http://localhost:9876/globalWeather");
	}
	
	public static void undeploy(){
		globalWeather.stop();
	}
	
	
	public static void main(String[] args) {
		deploy();
	}
}

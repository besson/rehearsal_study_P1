package eu.choreos.mocking;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.ServiceDeployer;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.ItemImpl;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.servicesimulator.MockResponse;
import eu.choreos.vv.servicesimulator.WSMock;

public class GlobalWeatherMockTest {
	
	final String WSDL = "http://localhost:9876/globalWeather?wsdl";
	
	@BeforeClass
	public static void setUp(){
		ServiceDeployer.deploy();
	}
	
	@AfterClass
	public static void tearDown(){
		ServiceDeployer.undeploy();
	}
	
	@Test
	public void shouldReturnTheWeatherOfOtherCountry() throws Exception {
		// Create a mock without conditions and choose you own WeatherResult. 
		// Use item explorer to help to build the response

		String myTime = "03:00 PM";
		String myRelativeHumidity = "77%";
		String myLocation ="Sao Paulo/Congonhas Airport, Brazil";
		String myDate = "Mar 30, 2012";
		String myTemperature = "21C";
		
		WSMock aMock = new WSMock("weatherMock", WSDL, "6000");
		aMock.start();
		
		Item getWeatherResponse = new ItemImpl("getWeatherResponse");
		Item return1 = new ItemImpl("return");
		
		Item time = new ItemImpl("time");
		time.setContent(myTime);
		return1.addChild(time);
		
		Item relativeHumidity = new ItemImpl("relativeHumidity");
		relativeHumidity.setContent(myRelativeHumidity);
		return1.addChild(relativeHumidity);
		
		Item location = new ItemImpl("location");
		location.setContent(myLocation);
		return1.addChild(location);
		
		Item date = new ItemImpl("date");
		date.setContent(myDate);
		return1.addChild(date);
		
		Item temperature = new ItemImpl("temperature");
		temperature.setContent(myTemperature);
		return1.addChild(temperature);
		
		getWeatherResponse.addChild(return1);
		
		MockResponse aMockResponse = new MockResponse().whenReceive("*").replyWith(getWeatherResponse);
		aMock.returnFor("getWeather", aMockResponse);
		
		WSClient aClient = new WSClient(aMock.getWsdl());
		Item aResponse = aClient.request("getWeather", "Brazil", "Sao Paulo");
		
		assertEquals(getWeatherResponse, aResponse);
	}

}


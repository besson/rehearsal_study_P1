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
	public static void setUp() {
		ServiceDeployer.deploy();
	}

	@AfterClass
	public static void tearDown() {
		ServiceDeployer.undeploy();
	}

	@Test
	public void shouldReturnTheWeatherOfOtherCountry() throws Exception {
		// Create a mock without conditions and choose you own WeatherResult. 
		// Use item explorer to help to build the response
		WSMock mock = new WSMock("weatherWSMock", WSDL, "7777");
		mock.start();
		
		
		Item getWeatherResponse = new ItemImpl("getWeatherResponse");
		Item return1 = new ItemImpl("return");
		Item time = new ItemImpl("time");
		time.setContent("13:00 PM");
		return1.addChild(time);
		Item relativeHumidity = new ItemImpl("relativeHumidity");
		relativeHumidity.setContent("37");
		return1.addChild(relativeHumidity);
		Item location = new ItemImpl("location");
		location.setContent("sss");
		return1.addChild(location);
		Item date = new ItemImpl("date");
		date.setContent(" ___");
		return1.addChild(date);
		Item temperature = new ItemImpl("temperature");
		temperature.setContent("77");
		return1.addChild(temperature);
		getWeatherResponse.addChild(return1);
		
		
		//MockResponse response1 = new MockResponse().whenReceive("Peru","Arequipa").replyWith(getWeatherResponse);
		MockResponse response1 = new MockResponse().whenReceive("*","Arequipa").replyWith(getWeatherResponse);
		mock.returnFor("getWeather", response1);
		
		WSClient client = new WSClient(mock.getWsdl());
		Item response = client.request("getWeather","Peru" ,"Arequipa");
		
		
		assertEquals("77", response.getChild("return").getChild("temperature").getContent());
		
	}
}

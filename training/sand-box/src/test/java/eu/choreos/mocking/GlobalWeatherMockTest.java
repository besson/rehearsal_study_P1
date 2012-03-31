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
		
		WSMock mock = new WSMock("teste", WSDL, "1234");
		mock.start();
		
		Item getWeatherResponse = new ItemImpl("getWeatherResponse"); 
		Item result = new ItemImpl("return"); 
		Item time = new ItemImpl("time"); 
		time.setContent("12pm"); 
		result.addChild(time); 
		Item relativeHumidity = new ItemImpl("relativeHumidity"); 
		relativeHumidity.setContent("44%"); 
		result.addChild(relativeHumidity); 
		Item location = new ItemImpl("location"); 
		location.setContent("Argelia"); 
		result.addChild(location); 
		Item date = new ItemImpl("date"); 
		date.setContent("12 march"); result.addChild(date); 
		Item temperature = new ItemImpl("temperature"); 
		temperature.setContent("190C");
		result.addChild(temperature); 
		getWeatherResponse.addChild(result);
		
		MockResponse response = new MockResponse().whenReceive("*").replyWith(getWeatherResponse);
		
		mock.returnFor("getWeather", response);
		
		WSClient client = new WSClient(mock.getWsdl());
		Item getWeather = new ItemImpl("getWeather");
		Item countryName = new ItemImpl("countryName"); 
		countryName.setContent("Brazil"); 
		getWeather.addChild(countryName); 
		Item cityName = new ItemImpl("cityName"); 
		cityName.setContent("Sao Paulo"); 
		getWeather.addChild(cityName);
		
		Item cResponse = client.request("getWeather", getWeather);
		
		assertEquals("Argelia", cResponse.getChild("return").getChild("location").getContent());
	}

}

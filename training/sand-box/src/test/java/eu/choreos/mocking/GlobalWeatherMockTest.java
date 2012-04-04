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
		WSMock mock = new WSMock("globalWeatherMock", WSDL, "4242");
		mock.start();
		Item weatherItem = new ItemImpl("return");
		weatherItem.addChild(newItem("date", "Today"));
		weatherItem.addChild(newItem("time", "now"));
		weatherItem.addChild(newItem("location", "here"));
		weatherItem.addChild(newItem("temperature", "mild"));
		weatherItem.addChild(newItem("relativeHumidity", "100%"));
		
		
		MockResponse response = new MockResponse().whenReceive("Brazil", "Taubaté").replyWith(weatherItem );
		mock.returnFor("getWeather", response);

		WSClient client = new WSClient(mock.getWsdl());
		Item actual = client.request("getWeather", "Brazil", "Taubaté").getChild("return");
		assertEquals("Today", actual.getChild("date").getContent());
	}
	
	private Item newItem(String name, String content){
		Item item = new ItemImpl(name);
		item.setContent(content);
		return item;
	}
}

package eu.choreos.wsclient;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.ServiceDeployer;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;

public class GlobalWeatherTest {
	
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
	public void shouldReturnTheWeatherForSaoPaulo() throws Exception {
		WSClient client = new WSClient(WSDL);
		Item responseItem = client.request("getWeather", "Brazil", "Sao Paulo").getChild("return");
		assertEquals("Sao Paulo/Congonhas Airport, Brazil", responseItem.getChild("location").getContent());
		assertEquals("Mar 30, 2012", responseItem.getChild("date").getContent());
		assertEquals("03:00 PM", responseItem.getChild("time").getContent());
		assertEquals("21C", responseItem.getChild("temperature").getContent());
		assertEquals("77%", responseItem.getChild("relativeHumidity").getContent());
	}

}

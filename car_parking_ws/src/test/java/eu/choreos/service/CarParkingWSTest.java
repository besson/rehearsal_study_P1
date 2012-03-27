package eu.choreos.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.choreos.common.ServiceDeployer;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;

public class CarParkingWSTest {
	
	final private String WSDL_URI = "http://localhost:1234/carParkingWS?wsdl";
	
	@Before
	public void setUp() throws Exception {
		ServiceDeployer.deploy();
	}
	
	@After
	public void tearDown() throws Exception {
		ServiceDeployer.undeploy();
	}
	
	@Test
	public void shouldReturnReturnTheCarParkCode() throws Exception {
		// input: A1, 8
		// output: J123
		//TODO: Erase
		WSClient client = new WSClient(WSDL_URI);
		Item response = client.request("getCarParkCode", "A1", "8");
		
		assertEquals("J123", response.getChild("return").getContent());
	}
	
	@Test
	public void shouldReturnTheLatitude() throws Exception {
		// input: J123
		// output: 23 32 S
		WSClient client = new WSClient(WSDL_URI);
		Item response = client.request("getLatitude", "J123");
		
		assertEquals("23 32 S", response.getChild("return").getContent());
	}
	
	@Test
	public void shouldReturnTheLongitude() throws Exception {
		// input: J123
		// output: 46 37 W
		WSClient client = new WSClient(WSDL_URI);
		Item response = client.request("getLongitude", "J123");
		
		assertEquals("46 37 W", response.getChild("return").getContent());
	}

}

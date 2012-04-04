package eu.choreos.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.choreos.common.ServiceDeployer;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.exceptions.FrameworkException;
import eu.choreos.vv.exceptions.InvalidOperationNameException;

public class CarParkingWSTest {
	
	final private String WSDL_URI = "http://localhost:1234/carParkingWS?wsdl";
	private WSClient client;
	
	@Before
	public void setUp() throws Exception {
		// Deploy and publish the web service
		ServiceDeployer.deploy();
		client = new WSClient(WSDL_URI);
	}
	
	@After
	public void tearDown() throws Exception {
		// Undeploy the web service
		ServiceDeployer.undeploy();
	}
	
	@Test
	public void shouldReturnTheCarParkCode() throws Exception {
		// input: customerId = A1, terminal = 8
		// output: J123
		assertEquals("J123", request("getCarParkCode", "A1", "8"));
	}
	
	@Test
	public void shouldReturnTheLatitude() throws Exception {
		// input: J123
		// output: 23 32 S
		assertEquals("23 32 S", request("getLatitude", "J123"));
	}
	
	@Test
	public void shouldReturnTheLongitude() throws Exception {
		// input: J123
		// output: 46 37 W
		assertEquals("46 37 W", request("getLongitude", "J123"));
	}
	
	private String request(String operation, String... params) throws Exception {
		return client.request(operation, params).getChild("return").getContent();
	}

}

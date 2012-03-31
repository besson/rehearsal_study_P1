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
		// Deploy and publish the web service
		ServiceDeployer.deploy();
	}
	
	@After
	public void tearDown() throws Exception {
		// Undeploy the web service
		ServiceDeployer.undeploy();
	}
	
	@Test
	public void shouldReturnReturnTheCarParkCode() throws Exception {
		// input: A1, 8
		// output: J123
		
		assertTrue(false);
	}
	
	@Test
	public void shouldReturnTheLatitude() throws Exception {
		// input: J123
		// output: 23 32 S
		
		assertTrue(false);
	}
	
	@Test
	public void shouldReturnTheLongitude() throws Exception {
		// input: J123
		// output: 46 37 W
		
		assertTrue(false);
	}

}

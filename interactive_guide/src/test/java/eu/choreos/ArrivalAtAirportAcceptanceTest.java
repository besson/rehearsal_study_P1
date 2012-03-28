package eu.choreos;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.common.MockDeployer;
import eu.choreos.vv.abstractor.Choreography;
import eu.choreos.vv.abstractor.Service;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;

public class ArrivalAtAirportAcceptanceTest {
		
	private static Choreography choreography;
	private static WSClient client;

	@BeforeClass
	public static void setUp() throws Exception{
		choreography = Choreography.build("/home/rehearsal/study/resources/arrivalAtAirport.yml");
		MockDeployer.deployWebTripMock(choreography);
		
		Service interactiveGuide = choreography.getServicesForRole("interactiveGuide").get(0);
		client = new WSClient(interactiveGuide.getUri());
	}
	
	@AfterClass
	public static void tearDown() throws Exception{
		MockDeployer.undeploy();
	}
	
	@Test
	public void shouldReturnAConfirmationMessage() throws Exception {
		Item response = client.request("calculateLocations", "A1");
		
		assertEquals("Calculation in progress", response.getChild("return").getContent());
		
	}
	
	@Test
	public void shouldReturnTerminalAndCarParkLocation() throws Exception {
		client.request("calculateLocations", "A1");
		Item response = client.request("getFlightAndCarParkLocation", "A1");
		
		String expectedMessage = "You have to go to terminal 8" + ";" + 
								 "Turn the first right and Go straight for 2 blocks ; Park your car in vacancy J123"; 
		
		assertEquals(expectedMessage, response.getChild("return").getContent());
	}

}

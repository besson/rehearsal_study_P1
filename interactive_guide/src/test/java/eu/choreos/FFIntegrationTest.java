package eu.choreos;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.common.MockDeployer;
import eu.choreos.vv.abstractor.Choreography;
import eu.choreos.vv.abstractor.Service;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.interceptor.MessageInterceptor;

public class FFIntegrationTest {
	
	private static Choreography choreography;
	private static String flightFinderWSDL;
	
	// flight finder process must be running!
	
	@BeforeClass
	public static void setUp() throws Exception{
		choreography = Choreography.build("/home/rehearsal/study/resources/arrivalAtAirport.yml");
		Service flightFinder = choreography.getServicesForRole("flightFinder").get(0);		
		
		flightFinderWSDL = flightFinder.getUri();
		
		MockDeployer.deployWebTripMock(choreography);
	}
	
	@AfterClass
	public static void tearDown() throws Exception{
		MockDeployer.undeploy();
	}
	
	@Test
	public void shouldSendIdPassengerToFlightFinderWhenAskForLocationCalculation() throws Exception {

		String intGuideWSDL = choreography.getServicesForRole("interactiveGuide").get(0).getUri();
		
		MessageInterceptor interceptor = new MessageInterceptor("6002");
		interceptor.interceptTo(flightFinderWSDL);
		
		WSClient client = new WSClient(intGuideWSDL);
		client.request("calculateLocations", "A1");
		
		List<Item> messages = interceptor.getMessages();
		
		assertEquals("A1", messages.get(0).getChild("arg0").getContent());
	}
	

}

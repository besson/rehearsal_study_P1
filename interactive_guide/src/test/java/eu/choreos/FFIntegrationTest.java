package eu.choreos;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.vv.abstractor.Choreography;
import eu.choreos.vv.abstractor.Service;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.ItemImpl;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.interceptor.MessageInterceptor;
import eu.choreos.vv.servicesimulator.MockResponse;
import eu.choreos.vv.servicesimulator.WSMock;

public class FFIntegrationTest {
	
	private static Choreography choreography;
	private static String flightFinderWSDL;
	
	// flight finder process must be running!
	
	@BeforeClass
	public static void setUp() throws Exception{
		choreography = Choreography.build("/home/rehearsal/study/resources/arrivalAtAirport.yml");
		Service flightFinder = choreography.getServicesForRole("flightFinder").get(0);		
		
		flightFinderWSDL = flightFinder.getUri();
		
		//Retrieve the wsdl uri of the car parking ws
		Service service = flightFinder.getServicesForRole("flightFinder").get(0);
		String webTripWSDL = service.getUri();
		
		// create the Mock here
		WSMock webTripMock = new WSMock("mocks/webTrip", webTripWSDL, "4321", true);
		
		MockResponse response = new MockResponse().whenReceive("A1").replyWith(getFligthResponse());
		
		webTripMock.returnFor("getFlight", response);
		webTripMock.start();

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
	
	private static Item getFligthResponse() {
		Item getFlightInfoResponse = new ItemImpl("getFlightResponse"); 
		Item flightInformation = new ItemImpl("flight"); 
		Item id = new ItemImpl("id"); 
		id.setContent("0815"); 
		flightInformation.addChild(id); 
		Item time = new ItemImpl("time"); 
		time.setContent("130p"); 
		flightInformation.addChild(time); 
		Item terminal = new ItemImpl("terminal"); 
		terminal.setContent("8"); 
		flightInformation.addChild(terminal); 
		Item company = new ItemImpl("company"); 
		company.setContent("AA"); 
		flightInformation.addChild(company); 
		Item destination = new ItemImpl("destination"); 
		destination.setContent("Paris"); 
		flightInformation.addChild(destination); 
		getFlightInfoResponse.addChild(flightInformation);
		 
		return getFlightInfoResponse;
	}

}

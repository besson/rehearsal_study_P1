package eu.choreos.tasks;

import static org.junit.Assert.assertEquals;

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

public class Task03Test {
	
	private static Choreography choreography;
	private static String carParkReservationWSDL;
	private static String interactiveGuideWSDL;
	
	@BeforeClass
	public static void setUp() throws Exception{
		choreography = Choreography.build("/home/rehearsal/study/resources/arrivalAtAirport.yml");
		Service carParkReservation = choreography.getServicesForRole("carParkReservation").get(0);		
		carParkReservationWSDL = carParkReservation.getUri();
		
		Service interactiveGuide = choreography.getServicesForRole("interactiveGuide").get(0);
		interactiveGuideWSDL = interactiveGuide.getUri();
		
		deployWebTripMock();
	}
	
	@Test
	public void shouldSendCarParkInfoToInteractiveGuideCorrectly() throws Exception {
		// input: arg0 = A1, arg1 = 8 (see the contract of carParkReservation by using the item explorer)

		//complete the code below by creating the interceptor and invoking the setPassengerInfo
		MessageInterceptor interceptor = null;
		
		
		List<Item> messages = interceptor.getMessages();
		
		assertEquals("A1", messages.get(0).getChild("arg0").getChild("pId").getContent());
		assertEquals("J123", messages.get(0).getChild("arg0").getChild("cpId").getContent());
		
	}
	
	private static void deployWebTripMock()throws Exception{
		Service flightFinder = choreography.getServicesForRole("flightFinder").get(0);		
		
		Service service = flightFinder.getServicesForRole("flightFinder").get(0);
		String webTripWSDL = service.getUri();
				
		WSMock webTripMock = new WSMock("mocks/webTrip", webTripWSDL, "4321", true);
		MockResponse response = new MockResponse().whenReceive("A1").replyWith(getFligthResponse());
				
		webTripMock.returnFor("getFlight", response);
		webTripMock.start();
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


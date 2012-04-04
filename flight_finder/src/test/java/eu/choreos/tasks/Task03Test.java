package eu.choreos.tasks;

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

public class Task03Test {
	
	private static Choreography choreography;
	private static Service flightFinder;

	@BeforeClass
	public static void setUp() throws Exception {
		choreography = Choreography.build("/home/rehearsal/study/resources/arrivalAtAirport.yml");
		flightFinder = choreography.getServicesForRole("flightFinder").get(0);
		
		deployWebTripMock();
		deployInteractiveGuideProxy();
	}
	
	@Test
	public void shouldForwardPassengerIdAndTerminalToTheCarParkReservation() throws Exception {
		Service carParkReservation = choreography.getServicesForRole("carParkReservation").get(0);
		String carParkReservationWSDL = carParkReservation.getUri();
		
		MessageInterceptor interceptor = new MessageInterceptor("6003");
		interceptor.interceptTo(carParkReservationWSDL);
		
		WSClient client = new WSClient(flightFinder.getUri());
		client.request("getFlightInfo", "A1");
		
		List<Item> messages = interceptor.getMessages();
		
		assertEquals("A1", messages.get(0).getChild("arg0").getContent());
		assertEquals("8", messages.get(0).getChild("arg1").getContent());
	}
	
	private static void deployWebTripMock()throws Exception{
		Service service = flightFinder.getServicesForRole("flightFinder").get(0);
		String webTripWSDL = service.getUri();
				
		WSMock webTripMock = new WSMock("mocks/webTrip", webTripWSDL, "4321", true);
		MockResponse response = new MockResponse().whenReceive("A1").replyWith(getFligthResponse());
				
		webTripMock.returnFor("getFlight", response);
		webTripMock.start();
	}
	
	private static void deployInteractiveGuideProxy() throws Exception {
		Service interactiveGuide = choreography.getServicesForRole("interactiveGuide").get(0); 
		MessageInterceptor interceptor = new MessageInterceptor("6001");
		interceptor.interceptTo(interactiveGuide.getUri());
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




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
import eu.choreos.vv.servicesimulator.MockResponse;
import eu.choreos.vv.servicesimulator.WSMock;


public class Task02Test {

	private static Choreography choreography;
	private static Service flightFinder;
	private static String flightFinderWSDL;
	private static WSMock webTripMock;
	
	@BeforeClass
	public static void setUp() throws Exception{
		choreography = Choreography.build("/home/rehearsal/study/resources/arrivalAtAirport.yml");
		flightFinder = choreography.getServicesForRole("flightFinder").get(0);		
		
		flightFinderWSDL = flightFinder.getUri();
		
		//Retrieve the wsdl uri of the car parking ws
		Service service = flightFinder.getServicesForRole("flightFinder").get(0);
		String webTripWSDL = service.getUri();
		
		// create the Mock here
		webTripMock = new WSMock("mocks/webTrip", webTripWSDL, "4321", true);
		
		MockResponse response = new MockResponse().whenReceive("A1").replyWith(getFligthResponse());
		
		webTripMock.returnFor("getFlight", response);
		webTripMock.start();

	}
	
	@Test
	public void shouldReturnTheFlightInformationForTheGetFlightInfoOperation() throws Exception {
		// input passengerId = A1
		// output a FlightInfo object with the following attributes: id = 0815, company = AA, destination = Paris, time = 130p, terminal = 8 
		
		// TODO erase and put assertTrue(false);
		WSClient client = new WSClient(flightFinderWSDL);
		Item response = client.request("getFlightInfo", "A1");
		
		Item flightInfo = response.getChild("return");
		
		assertEquals("0815", flightInfo.getChild("id").getContent());
		assertEquals("130p", flightInfo.getChild("time").getContent());
		assertEquals("8", flightInfo.getChild("terminal").getContent());
		assertEquals("AA", flightInfo.getChild("company").getContent());
		assertEquals("Paris", flightInfo.getChild("destination").getContent());
	}
	
	@Test
	public void shouldTheCorrectMessageToTheCarParkingService() throws Exception {
		// TODO erase and put assertTrue(false);
		WSClient client = new WSClient(flightFinderWSDL);
		client.request("getFlightInfo", "A1");
		
		List<Item> messages = webTripMock.getInterceptedMessages();
		
		assertEquals("A1", messages.get(0).getChild("id").getContent());
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

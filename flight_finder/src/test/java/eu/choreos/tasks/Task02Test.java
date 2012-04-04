package eu.choreos.tasks;

import static org.junit.Assert.*;
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
		webTripMock = new WSMock("webTripMock", webTripWSDL, "4321", true);
		webTripMock.start();
	}
	
	@Test
	public void shouldReturnFlightInformationForGetFlightInfoOperation() throws Exception {
		// input passengerId = A1
		// output a FlightInfo object with the following attributes:
		// id = 0815, company = AA, destination = Paris, time = 130p, terminal = 8
		WSClient client = new WSClient(flightFinderWSDL);
		
		MockResponse response = new MockResponse().whenReceive("A1").replyWith(getFlightResponse());
		webTripMock.returnFor("getFlight", response);
		
		Item flightInfo = client.request("getFlightInfo", "A1").getChild("return");
		assertEquals("0815", flightInfo.getChild("id").getContent());
		assertEquals("AA", flightInfo.getChild("company").getContent());
		assertEquals("Paris", flightInfo.getChild("destination").getContent());
		assertEquals("130p", flightInfo.getChild("time").getContent());
		assertEquals("8", flightInfo.getChild("terminal").getContent());
		
		Item message = webTripMock.getInterceptedMessages().get(0);
		assertEquals("A1", message.getChild("id").getContent());
	}
	
	@Test
	public void shouldTheCorrectMessageToTheCarParkingService() throws Exception {
		// input passengerId = A1
		// See the web trip contract through item explorer
		
		assertTrue(false);
		
	}
	
	private static Item getFlightResponse() {
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

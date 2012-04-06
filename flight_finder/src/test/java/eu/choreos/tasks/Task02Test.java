package eu.choreos.tasks;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.model.FlightInfo;
import eu.choreos.vv.abstractor.Choreography;
import eu.choreos.vv.abstractor.Service;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.ItemImpl;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.interceptor.MessageInterceptor;
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
		
		webTripMock = new WSMock("webTripMock", webTripWSDL,"4321", true);
		webTripMock.start();
		
		MockResponse mockResponse = new MockResponse().whenReceive("A1").replyWith(getFlightResponse());
		webTripMock.returnFor("getFlight", mockResponse);
		
	}
	
	@Test
	public void shouldReturnTheFlightInformationForTheGetFlightInfoOperation() throws Exception {
		// input passengerId = A1
		// output a FlightInfo object with the following attributes: id = 0815, company = AA, destination = Paris, time = 130p, terminal = 8
		
		WSClient client = new WSClient(flightFinderWSDL);
		Item responseItem = client.request("getFlightInfo","A1");
		String id = responseItem.getChild("return").getChild("id").getContent();
		String company = responseItem.getChild("return").getChild("company").getContent();
		String destination = responseItem.getChild("return").getChild("destination").getContent();
		String time = responseItem.getChild("return").getChild("time").getContent();
		String terminal = responseItem.getChild("return").getChild("terminal").getContent();
		
		assertEquals("0815", id);
		assertEquals("AA", company);
		assertEquals("Paris", destination);
		assertEquals("130p", time);
		assertEquals("8", terminal);
		
	}
	
	@Test
	public void shouldTheCorrectMessageToTheCarParkingService() throws Exception {
		// input passengerId = A1
		// See the web trip contract through item explorer
		
		WSClient client = new WSClient(flightFinderWSDL);
		client.request("getFlightInfo", "A1");
		
		Item interceptedItem = webTripMock.getInterceptedMessages().get(0);
		String id = interceptedItem.getChild("id").getContent();
		
		assertEquals("A1", id);
		assertEquals("getFlight", interceptedItem.getName());
		
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

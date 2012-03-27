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


public class Task02Test {

	private static Choreography choreography;
	private static Service flightFinder;
	private static String flightFinderWSDL;
	
	@BeforeClass
	public static void setUp() throws Exception{
		choreography = Choreography.build("/home/rehearsal/study/resources/arrivalAtAirport.yml");
		flightFinder = choreography.getServicesForRole("flightFinder").get(0);		
		
		flightFinderWSDL = flightFinder.getUri();
	}
	
	@Test
	public void shouldReturnTheFlightInformationForTheGetFlightInfoOperation() throws Exception {
		// input passengerId = 1234
		// output a FlightInfo object with the following attributes: id = 0815, company = AA, destination = Paris, time = 130p, terminal = 8 
		
		// TODO erase
		WSClient client = new WSClient(flightFinderWSDL);
		Item response = client.request("getFlightInfo", "1234");
		
		Item flightInfo = response.getChild("flightInformation");
		
		assertEquals("0815", flightInfo.getChild("id").getContent());
		assertEquals("130pm", flightInfo.getChild("time").getContent());
		assertEquals("8", flightInfo.getChild("terminal").getContent());
		assertEquals("AA", flightInfo.getChild("company").getContent());
		assertEquals("Paris", flightInfo.getChild("destinarion").getContent());
	}
	
	@Test
	public void shouldTheCorrectMessageToTheCarParkingService() throws Exception {

		
	}
	
	private Item getFligthResponse() {
		Item getFlightInfoResponse = new ItemImpl("getFlightInfoResponse"); 
		Item flightInformation = new ItemImpl("flightInformation"); 
		Item id = new ItemImpl("id"); 
		id.setContent("0815"); 
		flightInformation.addChild(id); 
		Item time = new ItemImpl("time"); 
		time.setContent("130pm"); 
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

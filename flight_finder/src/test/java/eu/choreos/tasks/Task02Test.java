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
		
		webTripMock = new WSMock("webTripMock", webTripWSDL , "4321", true);
		MockResponse mockResponse = new MockResponse();
		mockResponse.whenReceive("A1").replyWith(getFligthResponse());
		webTripMock.returnFor("getFlight", mockResponse);
		webTripMock.start();

		
	}
	
	@Test
	public void shouldReturnTheFlightInformationForTheGetFlightInfoOperation() throws Exception {
		// input passengerId = A1
		// output a FlightInfo object with the following attributes: id = 0815, company = AA, destination = Paris, time = 130p, terminal = 8
		
		WSClient client = new WSClient(flightFinderWSDL);
		
		
		Item response = client.request("getFlightInfo", "A1");
		assertEquals("AA",response.getChild("return").getChild("company").getContent());
		assertEquals("0815",response.getChild("return").getChild("id").getContent());
		assertEquals("Paris",response.getChild("return").getChild("destination").getContent());
		assertEquals("8",response.getChild("return").getChild("terminal").getContent());
		
		
	}
	
	@Test
	public void shouldTheCorrectMessageToTheCarParkingService() throws Exception {
		// input passengerId = A1
		// See the web trip contract through item explorer
		Service carParkReservationWS = choreography.getServicesForRole("carParkReservation").get(0);		
		String carParkReservationWSDL = carParkReservationWS.getUri();
		
		Service carParkWS = carParkReservationWS.getServicesForRole("carParkReservation").get(0);		
		String carParkWSDL = carParkWS.getUri();
		
		MessageInterceptor interceptor = new MessageInterceptor("7003");
		interceptor.interceptTo(carParkWSDL);
		
		WSClient client = new WSClient(carParkReservationWSDL);
		client.request("setPassengerInfo", "A1", "8");
		
		List<Item> messages = interceptor.getMessages();
		assertEquals("A1",messages.get(0).getChild("arg0").getContent());
		assertEquals("8",messages.get(0).getChild("arg1").getContent());
	    	
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

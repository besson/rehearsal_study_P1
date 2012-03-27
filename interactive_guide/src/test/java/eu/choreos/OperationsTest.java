package eu.choreos;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.vv.abstractor.Choreography;
import eu.choreos.vv.abstractor.Service;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.ItemImpl;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.servicesimulator.MockResponse;
import eu.choreos.vv.servicesimulator.WSMock;

public class OperationsTest {

	private static Choreography choreography;
	private static Service interactiveGuide;
	private static WSMock ffMock;
	private static WSClient client;
	
	@BeforeClass
	public static void setUp() throws Exception{
		choreography = Choreography.build("/home/rehearsal/study/resources/arrivalAtAirport.yml");
		interactiveGuide = choreography.getServicesForRole("interactiveGuide").get(0);
		String flightFinderWSDL = choreography.getRoles().get(0).getContractUri();
		
		ffMock = new WSMock("mocks/flightFinder", flightFinderWSDL, "9002", true);
		Item flighInfoResponse = getFlightInfoResponse();
		
		MockResponse response = new MockResponse().whenReceive("*").replyWith(flighInfoResponse);
		ffMock.returnFor("getFlightInfo", response);
		ffMock.start();
		
		client = interactiveGuide.getWSClient();
	}
	
	@AfterClass
	public static void tearDown() throws Exception{
		ffMock.stop();
	}
	
	@Test
	public void shouldReturnAConfirmationMessageWhenAskForLocationCalculation() throws Exception {
		Item response = client.request("calculateLocations", "A1");
		
		assertEquals("Calculation in progress", response.getChild("return").getContent());
	}

	@Test
	public void shouldSendIdPassengerToFlightFinderWhenAskForLocationCalculation() throws Exception {
		client.request("calculateLocations", "A1");
		List<Item> messages = ffMock.getInterceptedMessages();
		
		assertEquals("A1", messages.get(0).getChild("id").getContent());
	}
	
	
	@Test
	public void shouldRetrieveTheWholeLocationAfterSetCarParkInfo() throws Exception {
		client.request("calculateLocations", "A1");
		client.request("setCarParkInfo", getCarParkInfo());
		Item response = client.request("getFlightAndCarParkLocation", "A1");
		
		String expectedMessage = "You have to go to terminal 8" + ";" + "Turn the first right and Go straight for 2 blocks ; Park your car in vacancy J123"; 
		assertEquals(expectedMessage, response.getChild("return").getContent());
	}
	
	private static Item getFlightInfoResponse(){
		Item getFlightInfoResponse = new ItemImpl("getFlightInfoResponse"); 
		Item flightInformation = new ItemImpl("return"); 
		Item id = new ItemImpl("id"); 
		id.setContent("A1234"); 
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
		destination.setContent("Sao Paulo"); 
		flightInformation.addChild(destination); 
		getFlightInfoResponse.addChild(flightInformation);
		
		return getFlightInfoResponse;
	}
	
	private static Item getCarParkInfo(){
		Item setCarParkInfo = new ItemImpl("setCarParkInfo"); 
		Item arg0 = new ItemImpl("arg0"); 
		Item pId = new ItemImpl("pId"); 
		pId.setContent("A1"); 
		arg0.addChild(pId); 
		Item cpId = new ItemImpl("cpId"); 
		cpId.setContent("J123"); 
		arg0.addChild(cpId); 
		Item longitude = new ItemImpl("longitude"); 
		longitude.setContent("08000"); 
		arg0.addChild(longitude); 
		Item latitude = new ItemImpl("latitude"); 
		latitude.setContent("09000"); 
		arg0.addChild(latitude); 
		setCarParkInfo.addChild(arg0);
		
		return setCarParkInfo;
	}
		
}

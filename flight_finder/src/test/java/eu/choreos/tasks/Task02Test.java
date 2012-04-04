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
import eu.choreos.vv.interceptor.MessageInterceptor;
import eu.choreos.vv.servicesimulator.MockResponse;
import eu.choreos.vv.servicesimulator.WSMock;

public class Task02Test {

	private static Choreography choreography;
	private static Service flightFinderOrchestrator;
	private static String flightFinderOrchestratorWSDL;
	private static WSMock webTripMock;
	private static WSMock mockedService;
	private static String mockedServiceWSDL;

	@BeforeClass
	public static void setUp() throws Exception {
		choreography = Choreography
				.build("/home/rehearsal/study/resources/arrivalAtAirport.yml");
		flightFinderOrchestrator = choreography.getServicesForRole(
				"flightFinder").get(0);

		flightFinderOrchestratorWSDL = flightFinderOrchestrator.getUri();

		// Retrieve the wsdl uri of the car parking ws
		// Service effectiveService =
		// flightFinderOrchestrator.getServicesForRole(
		// "flightFinder").get(0);
		// String webTripWSDL = effectiveService.getUri();

		mockedService = new WSMock("webTripMock", flightFinderOrchestrator
				.getServicesForRole("flightFinder").get(0).getUri(), "4321",
				true);
		MockResponse response = new MockResponse();

		response.whenReceive("A1").replyWith(getFligthResponse());
		mockedService.returnFor("getFlight", response);

		mockedServiceWSDL = mockedService.getWsdl();
		mockedService.start();
		System.out.println(mockedServiceWSDL);
	}

	@Test
	public void shouldReturnTheFlightInformationForTheGetFlightInfoOperation()
			throws Exception {
		// input passengerId = A1
		// output a FlightInfo object with the following attributes: id = 0815,
		// company = AA, destination = Paris, time = 130p, terminal = 8
		WSClient client = new WSClient(flightFinderOrchestratorWSDL);
		System.out.println(flightFinderOrchestratorWSDL);

		Item response = client.request("getFlightInfo", "A1");

		Item returnedItem = response.getChild("return");

		assertEquals("0815", returnedItem.getChild("id").getContent());
		assertEquals("AA", returnedItem.getChild("company").getContent());
		assertEquals("Paris", returnedItem.getChild("destination").getContent());
		assertEquals("130p", returnedItem.getChild("time").getContent());
		assertEquals("8", returnedItem.getChild("terminal").getContent());

	}

	@Test
	public void shouldBeInvokingTheMockServiceByNow() {
		assertTrue(mockedService.getInterceptedMessages().size() > 0);
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

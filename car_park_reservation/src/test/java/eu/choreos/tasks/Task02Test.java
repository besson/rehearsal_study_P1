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
	private static Service carParkReservation;
	private static String carParkReservationWSDL;
	private static MessageInterceptor interceptor;
	private static MessageInterceptor messageInterceptor;

	@BeforeClass
	public static void setUp() throws Exception {
		choreography = Choreography
				.build("/home/rehearsal/study/resources/arrivalAtAirport.yml");
		carParkReservation = choreography.getServicesForRole(
				"carParkReservation").get(0);
		carParkReservationWSDL = carParkReservation.getUri();


		// Retrieve the wsdl uri of the car parking ws
		Service service = carParkReservation.getServicesForRole(
				"carParkReservation").get(0);
		String carParkingWSWSDL = service.getUri();
		String uri = choreography.getServicesForRole("carParkReservation").get(0).getServicesForRole("carParkReservation").get(0).getUri();
		messageInterceptor = new MessageInterceptor("7003");
		messageInterceptor.interceptTo(uri);
	}

	@Test
	public void shouldReturnAConfirmationMessageForSetPassengerInfoOperation()
			throws Exception {
		// input: arg0 = A1, arg1 = 8 (see the contract of carParkReservation by
		// using the item explorer)
		// output: "OK"
		Service service = choreography.getServicesForRole("carParkReservation")
				.get(0);
		WSClient client = new WSClient(service.getUri());
		Item response = client.request("setPassengerInfo", "A1", "8");

		assertEquals("OK",response.getChild("return").getContent());
	}

	@Test
	public void shouldReturnTheCorrectMessageToTheCarParkingService()
			throws Exception {
		// input: arg0 = A1, arg1 = 8 (see the contract of carParkReservation by
		// using the item explorer)
		
		
		WSClient client = new WSClient(carParkReservationWSDL);
		client.request("setPassengerInfo", "A1","8");
		Item message = messageInterceptor.getMessages().get(0);
		assertEquals("A1",message.getChild("arg0").getContent());
		assertEquals("8",message.getChild("arg1").getContent());
	}
}

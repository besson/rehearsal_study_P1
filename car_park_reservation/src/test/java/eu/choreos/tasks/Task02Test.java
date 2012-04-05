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
	
	@BeforeClass
	public static void setUp() throws Exception{
		choreography = Choreography.build("/home/rehearsal/study/resources/arrivalAtAirport.yml");
		carParkReservation = choreography.getServicesForRole("carParkReservation").get(0);		
		carParkReservationWSDL = carParkReservation.getUri();
		
		interceptor = new MessageInterceptor("7003");
		
		//Retrieve the wsdl uri of the car parking ws
		Service service = carParkReservation.getServicesForRole("carParkReservation").get(0);
		String carParkingWSWSDL = service.getUri();//carParkReservation
		interceptor.interceptTo(carParkingWSWSDL);
	}
	
	@Test
	public void shouldReturnAConfirmationMessageForSetPassengerInfoOperation() throws Exception {
		// input: arg0 = A1, arg1 = 8 (see the contract of carParkReservation by using the item explorer)
		// output: "OK"
		
		WSClient client = new WSClient(carParkReservationWSDL);//orchestrator
		
		Item response = client.request("setPassengerInfo", "A1","8");
		
		assertEquals("OK", response.getChild("return").getContent());
	}
	
	@Test
	public void shouldSendTheCorrectMessageToTheCarParkingService() throws Exception {
		// input: arg0 = A1, arg1 = 8 (see the contract of carParkReservation by using the item explorer)

		WSClient client = new WSClient(carParkReservationWSDL);//orchestrator
		
		Item response = client.request("setPassengerInfo", "A1","8");
		
		List<Item> messages = interceptor.getMessages();
		
		assertTrue(!messages.isEmpty());
		assertEquals("A1", messages.get(0).getChild("arg0").getContent());
		assertEquals("8", messages.get(0).getChild("arg1").getContent());

	}
}

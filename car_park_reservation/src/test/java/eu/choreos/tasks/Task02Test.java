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
		
		//Retrieve the wsdl uri of the car parking ws
		Service service = carParkReservation.getServicesForRole("carParkReservation").get(0);
		String carParkingWSWSDL = service.getUri();
		
		interceptor = new MessageInterceptor("7003");
		interceptor.interceptTo(carParkingWSWSDL);

	}
	
	@Test
	public void shouldReturnAConfirmationMessageForSetPassengerInfoOperation() throws Exception {
		// input: arg0 = A1, arg1 = 8 (see the contract of carParkReservation by using the item explorer)
		// output: "OK"
		
		WSClient client = new WSClient(carParkReservationWSDL);
		Item responseItem = client.request("setPassengerInfo","A1","8");
		String output = responseItem.getChild("return").getContent();
		
		assertEquals("OK", output);
	}
	
	@Test
	public void shouldTheCorrectMessageToTheCarParkingService() throws Exception {
		// input: arg0 = A1, arg1 = 8 (see the contract of carParkReservation by using the item explorer)
		
		WSClient client = new WSClient(carParkReservationWSDL);
		client.request("setPassengerInfo","A1","8");
		
		Item interceptedItem = interceptor.getMessages().get(0);
		String id = interceptedItem.getChild("arg0").getContent();
		String terminal = interceptedItem.getChild("arg1").getContent();
		
		assertEquals("A1", id);
		assertEquals("8", terminal);
	}
}

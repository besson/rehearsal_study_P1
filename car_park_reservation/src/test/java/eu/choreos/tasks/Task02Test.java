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
		
		// create MessageInterceptor for car_reservation service on port 7003
		interceptor = new MessageInterceptor("7003");
		interceptor.interceptTo(carParkingWSWSDL);
		
	}
	
	@Test
	public void shouldReturnConfirmationMessageForSetPassengerInfoOperation() throws Exception {
		// input: arg0 = A1, arg1 = 8 (see the contract of carParkReservation by using the item explorer)
		// output: "OK"
		WSClient client = new WSClient(carParkReservationWSDL);
		
		Item setPassengerInfo = new ItemImpl("setPassengerInfo");
		setPassengerInfo.addChild(createItem("arg0", "A1"));
		setPassengerInfo.addChild(createItem("arg1", "8"));
		
		Item response = client.request("setPassengerInfo", setPassengerInfo);
		
		assertEquals("OK", response.getChild("return").getContent());
	}

	
	@Test
	public void shouldSendCorrectMessageToCarParkingService() throws Exception {
		// input: arg0 = A1, arg1 = 8 (see the contract of carParkReservation by using the item explorer)
		WSClient client = new WSClient(carParkReservationWSDL);
		
		Item setPassengerInfo = new ItemImpl("setPassengerInfo");
		setPassengerInfo.addChild(createItem("arg0", "A1"));
		setPassengerInfo.addChild(createItem("arg1", "8"));
		
		client.request("setPassengerInfo", setPassengerInfo);
		
		List<Item> messagesToCarParking = interceptor.getMessages();
		
		assertEquals("A1", messagesToCarParking.get(0).getChild("arg0").getContent());
		assertEquals("8", messagesToCarParking.get(0).getChild("arg1").getContent());
		
		assertEquals("J123", messagesToCarParking.get(1).getChild("arg0").getContent());
		assertEquals("J123", messagesToCarParking.get(2).getChild("arg0").getContent());
	}
	
	private Item createItem(String name, String content) {
		Item item = new ItemImpl(name);
		item.setContent(content);
		return item;
	}
	
}

package com.carsolutions;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.carsolutions.model.Client;

public class ParkSafeFeaturesTest {
	
	private static ParkSafe system;
	private static Client customer1;
	
	@BeforeClass
	public static void setUp() throws Exception{
		system = new ParkSafe(false);
		customer1 = new Client("1", "John", "Mayer", "Matao 1001 street");
	}
	
	@Test
	public void shouldAddACustomer() throws Exception {
		system.add(customer1);
		
		assertEquals("John", system.getCustomer("1").getFirstName());
	}
	
	@Test
	public void shouldReturnTheListOfCustomers() throws Exception {
		Client customer2 = new Client("2", "Mary", "Mayer", "Matao 1001 street" );

		system.add(customer1);
		system.add(customer2);
		
		List<Client> customers = system.getClients();
		
		assertEquals("John", customers.get(1).getFirstName());
		assertEquals("Mary", customers.get(0).getFirstName());
	}
	
	@Test
	public void shouldAssignACarParkPlaceToACustomer() throws Exception {
		system.assingCarParkPlace("1", "VFH1", "8");
		
		String carPark = system.getCarParkPlace("1", "8");
		
		assertEquals("VFH1", carPark);
	}
	
	@Test
	public void shouldGetLatitudeAndLongitudeOfACarParkPlace() throws Exception {
		system.assingCarParkPlace("1", "VFH1", "8");
		
		String latitude = system.getLatitude("VFH1");
		String longitude = system.getLongitude("VFH1");
		
		assertEquals("23 32 S", latitude);
		assertEquals("46 37 W", longitude);
	}
	
	@Test
	public void shouldLoadTheProductionDataCorrectly() throws Exception {
		ParkSafe system = new ParkSafe();
		List<Client> clients = system.getClients();
		String place = system.getCarParkPlace("A1", "8");
		
		assertEquals("Steve", clients.get(0).getFirstName());
		assertEquals("J123", place);
	}

}

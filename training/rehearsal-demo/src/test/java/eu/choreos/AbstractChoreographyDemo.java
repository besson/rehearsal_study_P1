package eu.choreos;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.vv.abstractor.Choreography;
import eu.choreos.vv.abstractor.Service;

public class AbstractChoreographyDemo {
	
	private static Choreography choreography;
	
	@BeforeClass
	public static void setUp() throws FileNotFoundException{
		choreography = Choreography.build("resource/futureMarket.yml");
	}
	
	@Test
	public void shouldRetrieveAllServicePlayingSupermarketRole() throws Exception {
		List<Service> services = choreography.getServicesForRole("supermarket");
		
		assertEquals("http://localhost:8084/petals/services/supermarket1?wsdl", services.get(0).getUri());
		assertEquals("http://localhost:8084/petals/services/supermarket2?wsdl", services.get(1).getUri());
	}
	
	@Test
	public void shouldRetrieveTheParicipants() throws Exception {
		Service customer = choreography.getServicesForRole("customer").get(0);
		Service participant = customer.getServicesForRole("customer").get(1);
		
		assertEquals("http://localhost:1234/smregistry?wsdl", participant.getUri());
				
	}

}

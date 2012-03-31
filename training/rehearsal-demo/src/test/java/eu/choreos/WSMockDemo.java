package eu.choreos;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;


import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.ItemImpl;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.servicesimulator.MockResponse;
import eu.choreos.vv.servicesimulator.WSMock;

public class WSMockDemo {
	
	final String greetingWSDL = "http://localhost:9080/greeting?wsdl";	
	
	@Test
	public void shouldChangeTheNameIfItIsJohn() throws Exception {
	
		WSMock mock = new WSMock("greetingAWSMock", "http://localhost:1234/greetingAWS?wsdl","5000", true);
		
		MockResponse response = new MockResponse().whenReceive("john").replyWith("hey Mary,");
		mock.start();
		
		
		MockResponse response1 = new MockResponse().whenReceive("*").replyWith("hey world,");
		mock.returnFor("sayHi", response, response1);
		
		
		WSClient client = new WSClient(greetingWSDL);
		Item clientResponse = client.request("hi", "john");
		
		Item clientResponse1 = client.request("hi", "brian");
		
		assertEquals("hey Mary, how are you doing bro?", clientResponse.getChild("return").getContent());
		assertEquals("hey world, how are you doing bro?", clientResponse1.getChild("return").getContent());
	}
}

package eu.choreos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;

public class FFAcceptanceTest {
		
	@Test
	public void shouldReturnAConfirmationMessage() throws Exception {
		
		WSClient client = new WSClient("http://localhost:8001/services/interactiveGuide?wsdl");
		Item response = client.request("calculateLocations", "A1");
		
		assertEquals("Calculation in progress", response.getChild("return").getContent());
		
	}

}

package br.batcave.workflow;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;


public class WorkflowTest {

	@Test
	public void shouldReturnAPartialGreeting() throws Exception {
		WSClient client = new WSClient("http://localhost:9080/greeting?wsdl");
		Item response = client.request("hi", "john");
		
		assertEquals("hi john, how are you doing bro?", response.getChild("return").getContent());
		
	}
}

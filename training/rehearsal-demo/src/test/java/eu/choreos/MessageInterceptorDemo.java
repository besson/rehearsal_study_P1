package eu.choreos;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.interceptor.MessageInterceptor;

public class MessageInterceptorDemo {
	
	final String greetingWSDL = "http://localhost:9080/greeting?wsdl";	
	
	
	@Test
	public void serviceAShouldForwardMessageToServiceB() throws Exception {
		MessageInterceptor interceptor = new MessageInterceptor("6000");
		interceptor.interceptTo("http://localhost:4321/greetingBWS?wsdl");
		
		WSClient client = new WSClient(greetingWSDL);
		client.request("hi", "john");
		
		List<Item> messages = interceptor.getMessages();
		
		assertEquals("hi john,", messages.get(0).getChild("input").getContent());
	}

}

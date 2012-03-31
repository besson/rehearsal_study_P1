package eu.choreos;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.ItemImpl;
import eu.choreos.vv.clientgenerator.WSClient;

public class WSClientDemo {
	
	@BeforeClass
	public static void setUp() {
		ServiceDeployer.deployServiceA();
	}
	
	@AfterClass
	public static void tearDown(){
		ServiceDeployer.undeployServiceA();
	}
	
	@Test
	public void shouldReturnTheMessageHiJohn() throws Exception {
		WSClient client = new WSClient("http://localhost:1234/greetingAWS?wsdl");
		Item response = client.request("sayHi", "John");
		
		assertEquals("hi John,", response.getChild("return").getContent());
	}
	
	@Test
	public void shouldReturnAConfirmationMessage() throws Exception {
		WSClient client = new WSClient("http://localhost:1234/greetingAWS?wsdl");
		
		Item user = new ItemImpl("registerUser");
		
		Item name = new ItemImpl("name");
		name.setContent("Besson");
		user.addChild(name);
		
		Item age = new ItemImpl("age");
		age.setContent("25");
		user.addChild(age);
		
		Item response = client.request("registerUser", user);
		
		assertEquals("user registered", response.getChild("return").getContent());
	}
	

}

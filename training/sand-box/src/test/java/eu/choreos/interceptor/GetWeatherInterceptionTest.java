package eu.choreos.interceptor;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.ServiceDeployer;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.interceptor.MessageInterceptor;

public class GetWeatherInterceptionTest {
	
final String WSDL = "http://localhost:9876/globalWeather?wsdl";
	
	@BeforeClass
	public static void setUp(){
		ServiceDeployer.deploy();
	}
	
	@AfterClass
	public static void tearDown(){
		ServiceDeployer.undeploy();
	}
	
	@Test
	public void shouldValidateMessageContentSentToWS() throws Exception {
		// Intercept the message and validate the data sent to the web service
		
		// create Interceptor
		MessageInterceptor interceptor = new MessageInterceptor("6000");
		interceptor.interceptTo(WSDL);

		// create WSClient for Interceptor
		WSClient client = new WSClient(interceptor.getProxyWsdl());
		client.request("getWeather", "Brazil", "Sao Paulo");
		client.request("getWeather", "Brazil", "Taubaté");
		
		
		List<Item> messagesReceived = interceptor.getMessages();
		assertEquals(2, messagesReceived.size());
		
		Item firstResponse = messagesReceived.get(0);
		assertEquals("Brazil", firstResponse.getChild("countryName").getContent());
		
		Item secondResponse = messagesReceived.get(1);
		assertEquals("Taubaté", secondResponse.getChild("cityName").getContent());
	}

}

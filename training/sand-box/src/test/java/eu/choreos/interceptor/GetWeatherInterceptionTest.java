package eu.choreos.interceptor;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.ServiceDeployer;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.ItemImpl;
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
		MessageInterceptor interceptor = new MessageInterceptor("9089");
		interceptor.interceptTo(WSDL);
		
		Item getWeather = new ItemImpl("getWeather");
		Item countryName = new ItemImpl("countryName"); 
		countryName.setContent("Brazil"); 
		getWeather.addChild(countryName); 
		Item cityName = new ItemImpl("cityName"); 
		cityName.setContent("Sao Paulo"); 
		getWeather.addChild(cityName);
		
		WSClient client = new WSClient(interceptor.getProxyWsdl());
		client.request("getWeather", getWeather );
		
		List<Item> messages = interceptor.getMessages();
		
		assertEquals("Sao Paulo", messages.get(0).getChild("cityName").getContent());
	}

}

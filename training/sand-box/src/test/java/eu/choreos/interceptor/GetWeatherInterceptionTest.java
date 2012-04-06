package eu.choreos.interceptor;

import static org.junit.Assert.assertEquals;

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
		String cityName = "Sao Paulo";
		String countryName = "Brazil";
		
		MessageInterceptor myInterceptor = new MessageInterceptor("6000");
		myInterceptor.interceptTo(WSDL);
		
		WSClient myClient = new WSClient(myInterceptor.getProxyWsdl());
		myClient.request("getWeather", countryName, cityName);
		
		Item aMessageIntercepted = myInterceptor.getMessages().get(0);
		String interceptedCityName = aMessageIntercepted.getChild("cityName").getContent();
		String interceptedCountryName = aMessageIntercepted.getChild("countryName").getContent();
		
		assertEquals(cityName, interceptedCityName);
		assertEquals(countryName, interceptedCountryName);
	}

}

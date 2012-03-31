package eu.choreos.interceptor;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.ServiceDeployer;

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
		
	}

}

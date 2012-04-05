package eu.choreos.interceptor;

import static org.junit.Assert.*;

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
	public static void setUp() {
		ServiceDeployer.deploy();
	}

	@AfterClass
	public static void tearDown() {
		ServiceDeployer.undeploy();
	}

	@Test
	public void shouldValidateMessageContentSentToWS() throws Exception {
		// Intercept the message and validate he data sent to the web service
		MessageInterceptor interceptor = new MessageInterceptor("7777");
		interceptor.interceptTo(WSDL);

		WSClient client = new WSClient(interceptor.getProxyWsdl());

		client.request("getWeather", "Brazil", "Sao Paulo");

		List<Item> messages = interceptor.getMessages();
		
		assertEquals("Brazil", messages.get(0).getChild("countryName").getContent());

	}

}

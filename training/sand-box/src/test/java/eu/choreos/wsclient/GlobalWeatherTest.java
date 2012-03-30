package eu.choreos.wsclient;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.ServiceDeployer;

public class GlobalWeatherTest {
	
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
	public void shouldReturnTheWeatherForSaoPaulo() throws Exception {
		/**
		 *  input: Brazil, Sao Paulo
		 * 
		 *  output:
		 *  location: Sao Paulo/Congonhas Airport, Brazil
		 *  date: Mar 30, 2012
		 *  time: 03:00 PM
		 *  temperature: 21C
		 *  relative humidity: 77%;
		 *  
		 */
	
	}

}

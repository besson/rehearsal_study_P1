package eu.choreos.wsclient;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.xml.internal.ws.addressing.WsaClientTube;

import eu.choreos.ServiceDeployer;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.ItemImpl;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.interceptor.MessageInterceptor;
import eu.choreos.vv.servicesimulator.MockResponse;
import eu.choreos.vv.servicesimulator.WSMock;

public class GlobalWeatherTest {

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
	public void shouldReturnTheWeatherForSaoPauloUsingComplexItem()
			throws Exception {
		/**
		 * input Country: Brazil City : Sao Paulo
		 * 
		 * output: location: Sao Paulo/Congonhas Airport, Brazil date: Mar 30,
		 * 2012 time: 03:00 PM temperature: 21C relative humidity: 77%;
		 * 
		 */

		WSClient client = new WSClient(WSDL);
		Item getWeather = new ItemImpl("getWeather");
		Item countryName = new ItemImpl("countryName");
		countryName.setContent("Brazil");
		getWeather.addChild(countryName);
		Item cityName = new ItemImpl("cityName");
		cityName.setContent("Sao Paulo");
		getWeather.addChild(cityName);

		Item response = client.request("getWeather", getWeather);

		assertEquals("Sao Paulo/Congonhas Airport, Brazil",
				response.getChild("return").getChild("location").getContent());

	}

	@Test
	public void shouldReturnTheWeatherForSaoPauloUsingPrimitiveArguments()
			throws Exception {
		/**
		 * input Country: Brazil City : Sao Paulo
		 * 
		 * output: location: Sao Paulo/Congonhas Airport, Brazil date: Mar 30,
		 * 2012 time: 03:00 PM temperature: 21C relative humidity: 77%;
		 * 
		 */

		WSClient client = new WSClient(WSDL);
		Item response = client.request("getWeather", "Brazil", "Sao Paulo");

		assertEquals("Sao Paulo/Congonhas Airport, Brazil",
				response.getChild("return").getChild("location").getContent());

	}

	@Test
	public void shouldReturnTheCompleteWeatherForSaoPauloUsingPrimitiveArguments()
			throws Exception {
		/**
		 * input Country: Brazil City : Sao Paulo
		 * 
		 * output: location: Sao Paulo/Congonhas Airport, Brazil date: Mar 30,
		 * 2012 time: 03:00 PM temperature: 21C relative humidity: 77%;
		 * 
		 * 
		 * NOTA: Acho que seria interessante que a classe ITEM implementasse o
		 * equals comparando os conteúdos e as árvores de todas as folhas. Dados
		 * internos possivelmente poderiam ser desconsiderados
		 * 
		 * Em outra possibilidade, implementar outra função menos ampla do tipo
		 * equalValues(Item compareTo) que o faça permitindo que se construa a
		 * árvore na mão e popule os valores com o código gerado e simplesmente
		 * dar um assertTrue(expectedItem.equalValues(actualItem));
		 * 
		 */

		WSClient client = new WSClient(WSDL);
		Item response = client.request("getWeather", "Brazil", "Sao Paulo");

		Item returnedItem = response.getChild("return");
		String time = returnedItem.getChild("time").getContent();
		String relativeHumidity = returnedItem.getChild("relativeHumidity")
				.getContent();
		String location = returnedItem.getChild("location").getContent();
		String date = returnedItem.getChild("date").getContent();
		String temperature = returnedItem.getChild("temperature").getContent();

		assertEquals("03:00 PM", time);
		assertEquals("77%", relativeHumidity);
		assertEquals("Sao Paulo/Congonhas Airport, Brazil", location);
		assertEquals("Mar 30, 2012", date);
		assertEquals("21C", temperature);
	}

	/*
	 * Pô Felipe... Throws EXCEPTION CARA?!!?!??!
	 * 
	 * Cria uma exceção específica vai!
	 */
	@Test
	public void shouldReceiveAMessage() throws Exception {

		MessageInterceptor interceptor = new MessageInterceptor("6001");
		interceptor.interceptTo(WSDL);
		WSClient client = new WSClient(interceptor.getProxyWsdl());
		client.request("getWeather", "Brazil", "Sao Paulo");

		List<Item> messages = interceptor.getMessages();

		assertEquals("Brazil", messages.get(0).getChild("countryName")
				.getContent());
		assertEquals("Sao Paulo", messages.get(0).getChild("cityName")
				.getContent());
	}

	/*
	 * Com "Brazil", "Brasilia" funciona... 
	 * 
	 * Com "Brazil", "*" não...
	 */
	@Test
	public void shouldMockAService() throws Exception {

		WSMock mockService = new WSMock("MockedWeather", WSDL, "6002");

		mockService.start();
		
		Item getWeatherExpectedResponse = new ItemImpl("getWeatherResponse");
		Item return1 = new ItemImpl("return");
		Item time = new ItemImpl("time");
		time.setContent("Right now");
		return1.addChild(time);
		Item relativeHumidity = new ItemImpl("relativeHumidity");
		relativeHumidity.setContent("Dry as Hell!");
		return1.addChild(relativeHumidity);
		Item location = new ItemImpl("location");
		location.setContent("Brasilia/DF");
		return1.addChild(location);
		Item date = new ItemImpl("date");
		date.setContent("today");
		return1.addChild(date);
		Item temperature = new ItemImpl("temperature");
		temperature.setContent("Not so hot!");
		return1.addChild(temperature);
		getWeatherExpectedResponse.addChild(return1);
		
		MockResponse expectedResponse = new MockResponse();
		expectedResponse.whenReceive("Brazil", "Brasilia").replyWith(getWeatherExpectedResponse);

		mockService.returnFor("getWeather", expectedResponse);
		
		WSClient client = new WSClient(mockService.getWsdl());
		Item response = client.request("getWeather", "Brazil", "Brasilia");

		Item returnedValue = response.getChild("return");

		assertEquals("Brasilia/DF", returnedValue.getChild("location")
				.getContent());
		assertEquals("Dry as Hell!", returnedValue.getChild("relativeHumidity")
				.getContent());
		assertEquals("Not so hot!", returnedValue.getChild("temperature")
				.getContent());

	}
}

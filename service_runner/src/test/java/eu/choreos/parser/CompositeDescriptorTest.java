package eu.choreos.parser;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import eu.choreos.parser.CompositeDescriptor;
import eu.choreos.parser.MockEntry;
import eu.choreos.parser.ProxyEntry;


public class CompositeDescriptorTest {
	
	@Test
	public void shouldRetrieveTheMockList() throws Exception {
		CompositeDescriptor parser = CompositeDescriptor.parse("./resources/services.yml");
		
		List<MockEntry> mocks = parser.getMocks();
		
		assertEquals("http://localhost:1234/greetingAWS?wsdl", mocks.get(0).getReal());
		assertEquals("greetingAWSMock", mocks.get(0).getName());
		assertEquals("2345", mocks.get(0).getPort());
		
		assertEquals("http://localhost:4321/greetingBWS?wsdl", mocks.get(1).getReal());
		assertEquals("greetingBWSMock", mocks.get(1).getName());
		assertEquals("5432", mocks.get(1).getPort());

	}
	
	@Test
	public void shouldRetrieveTheProxyList() throws Exception {
		CompositeDescriptor parser = CompositeDescriptor.parse("./resources/services.yml");
		
		List<ProxyEntry> proxies = parser.getProxies();
		
		assertEquals("http://localhost:1234/greetingAWS?wsdl", proxies.get(0).getReal());
		assertEquals("9999", proxies.get(0).getPort());
		
	}
}

package eu.choreos.mocker;

import java.io.FileNotFoundException;
import java.util.List;

import eu.choreos.parser.CompositeDescriptor;
import eu.choreos.parser.MockEntry;
import eu.choreos.parser.ProxyEntry;
import eu.choreos.vv.interceptor.MessageInterceptor;
import eu.choreos.vv.servicesimulator.WSMock;

public class ServiceRunner {

	
	private List<MockEntry> mocks;
	private List<ProxyEntry> proxies;
	
	public ServiceRunner(String compositeLocation) throws FileNotFoundException {
		CompositeDescriptor parser = CompositeDescriptor.parse(compositeLocation);
		mocks = parser.getMocks();
		proxies = parser.getProxies();
	}
	
	public void startMocks() throws Exception{
		for (MockEntry mock :mocks) {
			WSMock serviceMock = new WSMock(mock.getName(), mock.getReal());
			serviceMock.setPort(mock.getPort());
			serviceMock.start();
			System.out.println("_------------------------------------------------------------------------------------------ mock deployed on: " + serviceMock.getWsdl());
		}
	}
	
	public void startProxies() throws Exception{
		for (ProxyEntry proxy :proxies) {
			MessageInterceptor interceptor = new MessageInterceptor(proxy.getPort());
			interceptor.interceptTo(proxy.getReal());
			System.out.println("proxy deployed on: " + interceptor.getProxyWsdl());
		}
	}
	
	public static void main(String[] args) throws Exception {
		ServiceRunner composite = new ServiceRunner(args[0]);
		composite.startMocks();
		composite.startProxies();
	}
	
	

}

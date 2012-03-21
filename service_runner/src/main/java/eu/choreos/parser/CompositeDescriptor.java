package eu.choreos.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class CompositeDescriptor {
	
	private List<MockEntry> mocks;
	private List<ProxyEntry> proxies;
	
	public static CompositeDescriptor parse(String path) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(CompositeDescriptor.class));
		InputStream input = new FileInputStream(new File(path));
		CompositeDescriptor descriptor = (CompositeDescriptor) yaml.load(input);
		return descriptor;
	}


	public List<MockEntry> getMocks() {
		return mocks;
	}


	public void setMocks(List<MockEntry> mocks) {
		this.mocks = mocks;
	}

	public void setProxies(List<ProxyEntry> proxies) {
		this.proxies = proxies;
	}
	
	public List<ProxyEntry> getProxies() {
		return proxies;
	}

}

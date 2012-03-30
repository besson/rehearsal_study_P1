package br.batcave.api;

import org.osoa.sca.annotations.Service;

@Service
public interface Greeting {
	
	public String hi(String input);
}

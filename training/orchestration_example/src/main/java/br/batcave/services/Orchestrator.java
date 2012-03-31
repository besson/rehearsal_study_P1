package br.batcave.services;

import javax.swing.JOptionPane;

import org.osoa.sca.annotations.Reference;

import br.batcave.GreetingAWS;
import br.batcave.GreetingBWS;
import br.batcave.api.Greeting;

public class Orchestrator implements Greeting{
	
	@Reference
	private GreetingAWS greetingA;
	
	@Reference
	private GreetingBWS greetingB;

	@Override
	public String hi(String input) {
		
		String result = greetingA.sayHi(input);
		
		return greetingB.sayhow(result);
	}

}

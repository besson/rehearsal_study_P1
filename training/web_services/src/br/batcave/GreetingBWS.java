package br.batcave;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class GreetingBWS {

	@WebMethod
	public String sayhow(@WebParam(name="input") String input){
		return input + " how are you doing bro?";
	}
	
	public static void main(String[] args) {
		GreetingBWS service = new GreetingBWS();
		Endpoint e = Endpoint.create(service);
		e.publish("http://localhost:4321/greetingBWS");
	}
}

package br.batcave;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class GreetingAWS {

	@WebMethod
	public String sayHi(@WebParam(name="input") String input){
		return "hi " + input + ",";
	}
	
	public static void main(String[] args) {
		GreetingAWS service = new GreetingAWS();
		Endpoint e = Endpoint.create(service);
		e.publish("http://localhost:1234/greetingAWS");
	}
}

package br.batcave;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class GreetingAWS {

	@WebMethod
	public String sayHi(@WebParam(name="input") String input){
		return "hi " + input + ",";
	}
}

package eu.choreos;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class GreetingAWS {

	@WebMethod
	public String sayHi(@WebParam(name="input") String input){
		return "hi " + input + ",";
	}
	
	@WebMethod
	public String registerUser(@WebParam(name="name") String name, @WebParam(name="age") String age){
		return "user registered";
	}
	
}

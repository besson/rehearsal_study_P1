package com.safetrip.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.safetrip.model.Flight;

@WebService
public interface WebTrip {
	
	@WebMethod
	public @WebResult(name="result") String addFlight(@WebParam (name="flight")Flight flight);
	
	@WebMethod
	public @WebResult(name="flight") Flight getFlight(@WebParam (name="id") int id);

}

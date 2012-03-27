package com.safetrip.service;

import java.util.HashMap;

import javax.jws.WebService;

import com.safetrip.model.Flight;

@WebService(endpointInterface="com.safetrip.service.WebTrip")
public class WebTripImpl implements WebTrip{

	HashMap<String, Flight> flights;
	
	public WebTripImpl(){
		flights = new HashMap<String, Flight>();
	}
	
	@Override
	public String addFlight(Flight flight) {
		flights.put(flight.getId(), flight);
		return "Flight was addedd with success";
	}

	@Override
	public Flight getFlight(String id) {
		return flights.get(id);
	}

}

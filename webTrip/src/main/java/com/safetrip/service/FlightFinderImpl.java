package com.safetrip.service;

import java.util.HashMap;

import javax.jws.WebService;

import com.safetrip.model.Flight;

@WebService(endpointInterface="com.safetrip.service.FlightFinder")
public class FlightFinderImpl implements FlightFinder{

	HashMap<Integer, Flight> flights;
	
	public FlightFinderImpl(){
		flights = new HashMap<Integer, Flight>();
	}
	
	@Override
	public String addFlight(Flight flight) {
		flights.put(flight.getId(), flight);
		return "Flight was addedd with success";
	}

	@Override
	public Flight getFlight(int id) {
		return flights.get(id);
	}

}

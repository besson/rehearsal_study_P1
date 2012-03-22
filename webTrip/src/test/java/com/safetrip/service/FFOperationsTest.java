package com.safetrip.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.safetrip.common.ServiceDeployer;

import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.ItemImpl;
import eu.choreos.vv.clientgenerator.WSClient;

public class FFOperationsTest {
	
	private final String WSDL_URI = "http://localhost:1234/webTrip";
	
	@Before
	public void setUp(){
		ServiceDeployer.deploy(WSDL_URI);
	}
	
	@After
	public void tearDown(){
		ServiceDeployer.undeploy();
	}
	
	@Test
	public void shouldReturnAConfirmationMessageWhenAddFlights() throws Exception {
		WSClient client = new WSClient(WSDL_URI + "?wsdl");
		
		Item flight = getFlightItem();
		Item response = client.request("addFlight", flight);
		
		assertEquals("Flight was addedd with success", response.getChild("result").getContent());
	}

	@Test
	public void shouldReturnAnExistingFlight() throws Exception {
		WSClient client = new WSClient(WSDL_URI + "?wsdl");
		
		Item flight = getFlightItem();
		client.request("addFlight", flight);
		Item response = client.request("getFlight", "5678");
		
		assertEquals("Paris", response.getChild("flight").getChild("destination").getContent());
		assertEquals("8", response.getChild("flight").getChild("terminal").getContent());
	}
	
	private Item getFlightItem() {
		Item flight = new ItemImpl("flight");
		Item id = new ItemImpl("id");
		id.setContent("5678");
		flight.addChild(id);
		
		Item company = new ItemImpl("company");
		company.setContent("AA");
		flight.addChild(company);
		
		Item destination = new ItemImpl("destination");
		destination.setContent("Paris");
		flight.addChild(destination);
		
		Item time = new ItemImpl("time");
		time.setContent("130p");
		flight.addChild(time);
		
		Item terminal = new ItemImpl("terminal");
		terminal.setContent("8");
		flight.addChild(terminal);
		
		return flight;
	}
	

}

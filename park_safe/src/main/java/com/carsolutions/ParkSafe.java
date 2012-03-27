package com.carsolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.carsolutions.model.Client;

public class ParkSafe {
	
	private HashMap<String, Client> clients;
	private HashMap<String, String> carParkPlaces;
	
	public ParkSafe(boolean productionMode){
		if (productionMode){
			clients = loadClients();
			carParkPlaces = loadCarParks();
		}
		else{
			clients = new HashMap<String, Client>();
			carParkPlaces = new HashMap<String, String>();
		}
	}
	
	public ParkSafe() {
		clients = loadClients();
		carParkPlaces = loadCarParks();
	}

	public void add(Client Client) {
		clients.put(Client.getId(), Client);
	}

	public Client getCustomer(String customerId) {
		return clients.get(customerId);
	}

	public List<Client> getClients() {
		List<Client> customerList = new ArrayList<Client>();
		
		Set<Entry<String, Client>> entries = clients.entrySet();
		
		for (Entry<String, Client> entry : entries) 
			customerList.add(entry.getValue());
		
		return customerList;
	}

	public void assingCarParkPlace(String customerId, String carParkId, String terminal) {
		carParkPlaces.put(customerId, carParkId);
	}

	public String getCarParkPlace(String customerId, String terminal) {
		return carParkPlaces.get(customerId);
	}
	
	public String getLatitude(String carParkId){
		return "23 32 S";
	}
	
	
	public String getLongitude(String carParkId){
		return "46 37 W";
	}

	private HashMap<String, Client> loadClients() {
		HashMap<String, Client> eClients = new HashMap<String, Client>();
		
		eClients.put("A1", new Client("A1", "George", "Ambh", "matao 1001 street"));
		eClients.put("A2", new Client("A2", "Steve", "Vai", "matao 1001 street"));
		
		return eClients;
	}
	
	private HashMap<String, String> loadCarParks() {
		HashMap<String, String> ePlaces = new HashMap<String, String>();
		ePlaces.put("A1", "J123");
		ePlaces.put("A2", "J124");
		
		return ePlaces;
	}
	
	

}

package eu.choreos.persistence;

import java.util.List;

import com.orientechnologies.orient.core.db.object.ODatabaseObjectTx;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;

import eu.choreos.CarParkEntry;
import eu.choreos.FlightEntry;
import eu.choreos.model.FlightInfo;

public class DAO {
	
	private static ODatabaseObjectTx getInstance(){
		ODatabaseObjectTx db = new ODatabaseObjectTx("local:./db/passengerItinerary");
		db.getEntityManager().registerEntityClass(FlightEntry.class);
		db.getEntityManager().registerEntityClass(CarParkEntry.class);
		db.getEntityManager().registerEntityClass(FlightInfo.class);
		
		if(!db.exists())
			db.create();
		else
		 db.open("admin", "admin");
		
		return db;
	}
	
	
	public static void addFlightInfo(FlightEntry entry){
		ODatabaseObjectTx db = getInstance();
		
		db.save(entry);
		db.close();
	}
	
	
	public static void addCarParktInfo(CarParkEntry entry){
		ODatabaseObjectTx db = getInstance();
		
		db.save(entry);
		db.close();
	}
	
	public static FlightEntry getFlightInfo(String id){
		ODatabaseObjectTx db = getInstance();
		List<FlightEntry> result = db.query(new OSQLSynchQuery<FlightEntry>("select from flightEntry where pId = '" + id + "'"));

		FlightEntry resultFlight = null;
		
		for(FlightEntry f : result)
			resultFlight = f;
		
		if (resultFlight != null)
			db.delete(resultFlight);		
		
		db.close();
		return resultFlight;
	}
	
	public static CarParkEntry getCarParkEntry(String id){
		ODatabaseObjectTx db = getInstance();
		List<CarParkEntry> result = db.query(new OSQLSynchQuery<CarParkEntry>("select from carParkEntry where pId = '" + id + "'"));

		CarParkEntry resultCarPark = null;
		
		for(CarParkEntry f : result)
			resultCarPark = f;
		
		if (resultCarPark != null)
			db.delete(resultCarPark);		
		
		db.close();
		return resultCarPark;
	}
	
}

package eu.choreos;


public class FlightEntry {
	
	private String pId;
	private FlightInfo flightInfo;

	public FlightInfo getInfo() {
		return flightInfo;
	}

	public void setInfo(FlightInfo info) {
		this.flightInfo = info;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

}

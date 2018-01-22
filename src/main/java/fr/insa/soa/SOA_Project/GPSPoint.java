package fr.insa.soa.SOA_Project;

public class GPSPoint{
	double lat;
	double lon;
	
	public GPSPoint(){
		this.lat = 0;
		this.lon = 0;
	}
	
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
}

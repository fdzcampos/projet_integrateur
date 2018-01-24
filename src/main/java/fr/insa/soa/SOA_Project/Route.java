package fr.insa.soa.SOA_Project;

import java.util.ArrayList;
import java.util.Iterator;

public class Route {	
	ArrayList<GPSPoint> route;
	double length;

	public Route(){
		route = new ArrayList<GPSPoint>();
	}
	
	public ArrayList<GPSPoint> getRoute() {
		return route;
	}

	public void setRoute(ArrayList<GPSPoint> route) {
		this.route = route;
	}
	
	public void addGPSPoint(double lat, double lon){
		GPSPoint point = new GPSPoint();
		point.setLat(lat);
		point.setLon(lon);
		route.add(point);
	}
	
	public double distanceInKm() {
		  double earthRadiusKm = 6371;
		  double distance = 0;

		  Iterator<GPSPoint> it1 = route.iterator();
		  Iterator<GPSPoint> it2 = route.iterator();
		  it2.next();
		  
		  if(it2.hasNext()){
			  while(it2.hasNext()){
				  GPSPoint p1 = it1.next();
				  GPSPoint p2 = it2.next();
				  
				  double dLat = Math.toRadians(p2.getLat()-p1.getLat());
				  double dLon = Math.toRadians(p2.getLon()-p1.getLon());

				  double lat1 = Math.toRadians(p1.getLat());
				  double lat2 = Math.toRadians(p2.getLat());

				  double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
				          Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2); 
				  double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
				  distance += earthRadiusKm * c;
			  }
		  }
		  return distance;
		}
	
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
}

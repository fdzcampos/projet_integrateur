package fr.insa.soa.SOA_Project;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Path("/shortestpath")
public class ShortestPath {
	static final private String neo4jUsername = "neo4j";
	static final private String neo4jPassword = "pqsszord";
	static final private String neo4jQueryURL = "http://10.20.28.117:7474/db/data/cypher";
	private Client client;
	private WebTarget target;
	
	@POST
	@Path("/route")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Route getRoute(Route route){
		Route shortestRoute = new Route();
		
		GPSPoint p1 = route.getRoute().get(0);
		GPSPoint p2 = route.getRoute().get(1);
		
		System.out.println("P1[ " + p1.getLon() + ", " + p1.getLat() + " ]    P2[ " + p2.getLon() + ", " + p2.getLat() + " ]");
		
		// Take care of neo4j authentication
		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
			    .nonPreemptive()
			    .credentials(neo4jUsername, neo4jPassword)
			    .build();
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(feature) ;
		
		// Create the REST client and target
		client = ClientBuilder.newClient(clientConfig);
	    target = client.target(neo4jQueryURL);
	    
	    // Create the JSON body of the POST request
	    JSONObject neo4jRequestBody = new JSONObject();
	    
	    // Il faudra changer la requète et le body JSON qui contient les paramètres
	    String neo4jQuery = "MATCH (p1:Point{id:678}),(p2:Point{id:677}),p=shortestPath((p1)-[*]-(p2)) return p";
	    
	    JSONObject neo4jParams = new JSONObject();
	    neo4jParams.put("id1", new Integer(2254));
	    //neo4jParams.put("id2", new Integer(2254));
	    
	    neo4jRequestBody.put("query", neo4jQuery);
	    neo4jRequestBody.put("params", neo4jParams);
	    
	    //System.out.println(neo4jRequestBody);

	    Entity<String> postBody = Entity.json(neo4jRequestBody.toJSONString());
	    
	    // Send the POST request
	    Response response = target.request(MediaType.APPLICATION_JSON).post(postBody);
		
	    // Process JSON response
		JSONParser parser = new JSONParser();
		try {
			// Convert JSON string into JSONObject
			JSONObject neoRoute = (JSONObject) parser.parse(response.readEntity(String.class));
			System.out.println(neoRoute.toJSONString());
			
			// Create Route object with the GPS coordinates of each points
			// Iterate over the JSONObject to fetch the points
			
			/*
			JSONArray data = (JSONArray)neoRoute.get("data");
			JSONArray points = (JSONArray) ((JSONArray) data.get(0)).get(0);
			for (int i = 0 ; i < points.size(); i++) {
		        JSONObject p = (JSONObject) points.get(i);
		        JSONObject pData = (JSONObject) p.get("data");
		        double x = 0.1 * Integer.parseInt((String) pData.get("x"));
		        double y = 0.1 * Integer.parseInt((String) pData.get("y"));
		        shortestRoute.addGPSPoint(x, y);
		    }
			*/
		} catch (ParseException e) {
			return route;
		}
		
		// Return dummy route
		shortestRoute.addGPSPoint(40.737102, -73.990318);
		shortestRoute.addGPSPoint(40.749825, -73.987963);
		shortestRoute.addGPSPoint(40.752946, -73.987384);
		shortestRoute.addGPSPoint(40.755823, -73.986397);
		shortestRoute.setLength(shortestRoute.distanceInKm());
		
		System.out.println("Got route");
		return shortestRoute;
	}
}

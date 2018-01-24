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
	    String neo4jQuery = "MATCH (p1:Point{id:{id1}}),(p2:Point{id:{id2}}),p=shortestPath((p1)-[*]-(p2)) return p,nodes(p)";
	    
	    JSONObject neo4jParams = new JSONObject();
	    neo4jParams.put("id1", new Integer(2625));
	    neo4jParams.put("id2", new Integer(2254));
	    
	    neo4jRequestBody.put("query", neo4jQuery);
	    neo4jRequestBody.put("params", neo4jParams);

	    Entity<String> postBody = Entity.json(neo4jRequestBody.toJSONString());
	    
	    // Send the POST request
	    Response response = target.request(MediaType.APPLICATION_JSON).post(postBody);
		
	    // Process JSON response
		JSONParser parser = new JSONParser();
		try {
			JSONObject neoRoute = (JSONObject) parser.parse((String)response.getEntity());
			System.out.println(neoRoute.toJSONString());
			// Construire l'objet Route route à l'aide des informations de neoRoute
		} catch (ParseException e) {
			return route;
		}
		
		// Return dummy route
		route.addGPSPoint(40.737102, -73.990318);
		route.addGPSPoint(40.749825, -73.987963);
		route.addGPSPoint(40.752946, -73.987384);
		route.addGPSPoint(40.755823, -73.986397);

		return route;
	}
}

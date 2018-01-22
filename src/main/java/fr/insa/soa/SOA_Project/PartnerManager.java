package fr.insa.soa.SOA_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("partners")
public class PartnerManager {
	
	@GET
	@Path("/{idPartner}")
	@Produces(MediaType.APPLICATION_JSON)
	public Partner getPartner(@PathParam("idPartner") int id){
		Partner partner = new Partner();
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return partner;	
		}
			
		/*
		 *  Statement is an interface that represents a SQL statement.
		 *  You execute Statement objects, they generate ResultSet objects,
		 *  which is a table of data representing a database result set.
		 *  You need a Connection object to create a Statement object
		 */
		Connection connection = null;
		Statement state = null;
		try {		
			connection = DriverManager.getConnection("jdbc:postgresql://18.194.236.50:5432/ilsoa", "ilsoa",
				"ilsoa");
			state = connection.createStatement();
			String query = "SELECT id, name, email, description FROM partners WHERE id='" + id + "';";
			ResultSet res = state.executeQuery(query);
						
	         while( res.next() ) {
	     		partner.setId(id);
	    		partner.setName(res.getString("name"));
	    		partner.setEmail(res.getString("email"));
	    		partner.setDescription(res.getString("description"));
	         }
	         
	         // close resources
	         res.close();
	         state.close();
	         connection.close();
	         
	         return partner;
		
		} catch (SQLException e) {

			return partner;
		
		}finally{		// close resources
			
			try{	
				if( state != null )
					state.close();	
			}catch( SQLException se2 ) {
				
			}try{	
				if( connection != null) 
					connection.close();	
			}catch(SQLException se){
				
				se.printStackTrace();
			}	
		}
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Partner> getAllPartners(){
		ArrayList<Partner> partners = new ArrayList<Partner>();
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return partners;	
		}
			
		/*
		 *  Statement is an interface that represents a SQL statement.
		 *  You execute Statement objects, they generate ResultSet objects,
		 *  which is a table of data representing a database result set.
		 *  You need a Connection object to create a Statement object
		 */
		Connection connection = null;
		Statement state = null;
		try {		
			connection = DriverManager.getConnection("jdbc:postgresql://18.194.236.50:5432/ilsoa", "ilsoa",
				"ilsoa");
			state = connection.createStatement();
			String query = "SELECT id, name, email, description FROM partners;";
			ResultSet res = state.executeQuery(query);
						
	         while( res.next() ) {
	        	Partner partner = new Partner();
	     		partner.setId(res.getInt("id"));
	    		partner.setName(res.getString("name"));
	    		partner.setEmail(res.getString("email"));
	    		partner.setDescription(res.getString("description"));
	    		partners.add(partner);
	         }
	         
	         // close resources
	         res.close();
	         state.close();
	         connection.close();
	         
	         return partners;
		
		} catch (SQLException e) {

			return partners;
		
		}finally{		// close resources
			
			try{	
				if( state != null )
					state.close();	
			}catch( SQLException se2 ) {
				
			}try{	
				if( connection != null) 
					connection.close();	
			}catch(SQLException se){
				
				se.printStackTrace();
			}	
		}
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addPartner(Partner partner){
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();	
		}
			
		/*
		 *  Statement is an interface that represents a SQL statement.
		 *  You execute Statement objects, they generate ResultSet objects,
		 *  which is a table of data representing a database result set.
		 *  You need a Connection object to create a Statement object
		 */
		Connection connection = null;
		Statement state = null;
		try {		
			connection = DriverManager.getConnection("jdbc:postgresql://18.194.236.50:5432/ilsoa", "ilsoa",
				"ilsoa");
			state = connection.createStatement();
			String query = "INSERT INTO partners(name, email, description) VALUES ('" + partner.getName() + "', '" + partner.getEmail() + "', '" + partner.getDescription() + "');";
			ResultSet res = state.executeQuery(query);
			
	        // close resources
	        res.close();
	        state.close();
	        connection.close();
		
		} catch (SQLException e) {
		
		}finally{		// close resources
			
			try{	
				if( state != null )
					state.close();	
			}catch( SQLException se2 ) {
				
			}try{	
				if( connection != null) 
					connection.close();	
			}catch(SQLException se){
				
				se.printStackTrace();
			}	
		}
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updatePartner(Partner partner){
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();	
		}
			
		/*
		 *  Statement is an interface that represents a SQL statement.
		 *  You execute Statement objects, they generate ResultSet objects,
		 *  which is a table of data representing a database result set.
		 *  You need a Connection object to create a Statement object
		 */
		Connection connection = null;
		Statement state = null;
		try {		
			connection = DriverManager.getConnection("jdbc:postgresql://18.194.236.50:5432/ilsoa", "ilsoa",
				"ilsoa");
			state = connection.createStatement();
			String query = "UPDATE partners SET name = '" + partner.getName() + "', email = '" + partner.getEmail() + "', description = '" + partner.getDescription() + "' WHERE id = " + partner.getId() + ";";
			ResultSet res = state.executeQuery(query);
			
	        // close resources
	        res.close();
	        state.close();
	        connection.close();
		
		} catch (SQLException e) {
		
		}finally{		// close resources
			
			try{	
				if( state != null )
					state.close();	
			}catch( SQLException se2 ) {
				
			}try{	
				if( connection != null) 
					connection.close();	
			}catch(SQLException se){
				
				se.printStackTrace();
			}	
		}
	}
	
	// Cette requète devrait être un "DELETE" et non un "GET"
	// Mais avec "DELETE" il y a une erreur 405: "Method not allowed"...
	@GET
	@Path("/remove/{idPartner}")
	public void removePartner(@PathParam("idPartner") int id){
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();	
		}
			
		/*
		 *  Statement is an interface that represents a SQL statement.
		 *  You execute Statement objects, they generate ResultSet objects,
		 *  which is a table of data representing a database result set.
		 *  You need a Connection object to create a Statement object
		 */
		Connection connection = null;
		Statement state = null;
		try {		
			connection = DriverManager.getConnection("jdbc:postgresql://18.194.236.50:5432/ilsoa", "ilsoa",
				"ilsoa");
			state = connection.createStatement();
			String query = "DELETE FROM partners WHERE id = " + id + ";";
			ResultSet res = state.executeQuery(query);
			
	        // close resources
	        res.close();
	        state.close();
	        connection.close();
		
		} catch (SQLException e) {
		
		}finally{		// close resources
			
			try{	
				if( state != null )
					state.close();	
			}catch( SQLException se2 ) {
				
			}try{	
				if( connection != null) 
					connection.close();	
			}catch(SQLException se){
				
				se.printStackTrace();
			}	
		}
	}

	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return "Where is your PostgreSQL JDBC Driver? Include in your library path!";	
		}
			
		/*
		 *  Statement is an interface that represents a SQL statement.
		 *  You execute Statement objects, they generate ResultSet objects,
		 *  which is a table of data representing a database result set.
		 *  You need a Connection object to create a Statement object
		 */
		Connection connection = null;
		Statement state = null;
		try {
					
			connection = DriverManager.getConnection("jdbc:postgresql://18.194.236.50:5432/ilsoa", "ilsoa",
				"ilsoa");
			state = connection.createStatement();
			String query = "SELECT id, name FROM users WHERE name='" + "Alexis" + "';";
			ResultSet res = state.executeQuery(query);
						
	         //Retrieve by column name         
	         int count = 0;
	         int id = 0;
	         String usr = null;
	         
	         while( res.next() ) {
	        	 count ++;
	        	 id  = res.getInt("id");
		         usr = res.getString("name");
	         }
	         
	         // close resources
	         res.close();
	         state.close();
	         connection.close();
	         
	         if( count == 1) {
	        	 return "id = " + id + ", name = " + usr;
	         } else {
	        	 return "No result";
	         }
		
		} catch (SQLException e) {

			return "Connection Failed! Check output console";
		
		}finally{		// close resources
			
			try{
				
				if( state != null )
					state.close();
				
			}catch( SQLException se2 ) {
				
			}try{
				
				if( connection != null) 
					connection.close();
				
			}catch(SQLException se){
				
				se.printStackTrace();
			}
			
			
		}
	}
}

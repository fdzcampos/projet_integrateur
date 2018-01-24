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

@Path("forum")
public class ForumManager {

	static final private int topicsPerPage = 20;
	static final private int messagesPerPage = 20;
	
	@POST
	@Path("/topic")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Topic createTopic(Topic topic){
		System.out.println("CREATE TOPIC");		
		Topic topicRes = new Topic();
		
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
			connection = DriverManager.getConnection("jdbc:postgresql://18.194.236.50:5432/ilsoa", "ilsoa", "ilsoa");
			state = connection.createStatement();
			String query = "INSERT INTO topics(title, date, userId) VALUES ('" + topic.getTitle() + "', now(), " + topic.getUser().getId() + ") RETURNING id, title;";
			ResultSet res = state.executeQuery(query);
			System.out.println(query);		
			
			if(res.next()){
				System.out.println("Res query: " + res.getInt("id") + " " + res.getInt("id"));
				topicRes.setId(res.getInt("id"));
				topicRes.setTitle(res.getString("title"));
			}else{
				topicRes.setId(-1);
			}
			
				
			query = "INSERT INTO messages(text, date, topicId, userId) VALUES ('" + topic.getMessages().get(0).getText() + "', now(), ( SELECT id FROM topics ORDER BY id DESC LIMIT 1 ), " + topic.getUser().getId() + ");";
			query += "UPDATE topics SET nbMessages = 1 WHERE id = " + topicRes.getId() + ";";
			
			//( SELECT id FROM topics ORDER BY id DESC LIMIT 1 )

			 // close resources
			 res.close();
			 state.close();
			 connection.close();
			 return topicRes;
			 
		} catch (SQLException e) {
			e.printStackTrace();
			return topicRes;
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
	@Path("/topic/page/{numPage}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Topic> getTopics(@PathParam("numPage") int page){
		ArrayList<Topic> topics = new ArrayList<Topic>();
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return topics;
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
			String query = "SELECT t.id, t.title, t.date, t.nbMessages, u.username "
						 + "FROM topics t, users u "
						 + "WHERE t.userId = u.id "
						 + "ORDER BY t.date ASC "
						 + "OFFSET " + topicsPerPage * (page - 1) + " "
						 + "LIMIT " + (topicsPerPage * page + 1)+ ";";
			ResultSet res = state.executeQuery(query);
						
			System.out.println(query);
			
	         while( res.next() ) {
	        	User user = new User();
	        	user.setUsername(res.getString("username"));
	        	Topic topic = new Topic();
	        	topic.setId(res.getInt("id"));
	        	topic.setTitle(res.getString("title"));
	        	topic.setDate(res.getTimestamp("date"));
	        	topic.setNbMessages(res.getInt("nbMessages"));
	        	topic.setUser(user);
	    		topics.add(topic);
	         }
	         
	         // close resources
	         res.close();
	         state.close();
	         connection.close();
	         
	         return topics;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			return topics;
		
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
	@Path("/message")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createMessage(Message message){
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
			String query = "INSERT INTO messages(text, date, topicId, userId) VALUES ('" + message.getText() + "', now(), " + message.getTopic().getId() + ", " + message.getUser().getId() + ");";
			query += "UPDATE topics SET nbMessages = nbMessages + 1 WHERE id = " + message.getTopic().getId() + ";";
			ResultSet res = state.executeQuery(query);
			System.out.println(query);
			
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
	@Path("/topic/{idTopic}/page/{idPage}")
	@Produces(MediaType.APPLICATION_JSON)
	public Topic getMessages(@PathParam("idTopic") int idTopic,
										@PathParam("idPage") int page){
		Topic topic = new Topic();
		ArrayList<Message> messages = new ArrayList<Message>();
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return topic;
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
			String query = "SELECT DISTINCT m.text, m.date, u.username "
						 + "FROM messages m, users u, topics t "
						 + "WHERE m.userId = u.id "
						 + "AND m.topicId = " + idTopic + " "
						 + "ORDER BY m.date ASC "
						 + "OFFSET " + messagesPerPage * (page - 1) + " "
						 + "LIMIT " + (messagesPerPage * page + 1) + " ";
			ResultSet res = state.executeQuery(query);
						
			System.out.println(query);
			
	         while( res.next() ) {
	        	User user = new User();
	        	user.setUsername(res.getString("username"));
	        	Message message = new Message();
	        	message.setText(res.getString("text"));
	        	//message.setDate(res.getTimestamp("date"));
	        	message.setUser(user);
	    		messages.add(message);
	         }
	         
			 query = "SELECT title FROM topics where id = " + idTopic + ";";
			 res = state.executeQuery(query);
	         
			 if( res.next() ){
				 topic.setId(idTopic);
				 topic.setTitle(res.getString("title"));
				 topic.setMessages(messages);
				 System.out.println(idTopic + ", " + res.getString("title") + ", " + messages);
			 }
			 
	         // close resources
	         res.close();
	         state.close();
	         connection.close();
	         
	         return topic;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			return topic;
		
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
	
	@DELETE
	@Path("/message/{idMessage}")
	public void deleteMessage(@PathParam("idMessage") int message){
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
			String query = "UPDATE topics SET nbMessages = nbMessages - 1 WHERE id = ( SELECT t.id FROM topics t, messages m WHERE t.id = m.topicId AND m.id = " + message +  ");";
			query += "DELETE FROM messages WHERE id = " + message + ";";
			ResultSet res = state.executeQuery(query);
			System.out.println(query);		
			
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
}

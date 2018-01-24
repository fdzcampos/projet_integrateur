package psql;

import java.sql.*;

public class Postgres {
	
	/**
	 * 
	 * @param user
	 * @param pwd
	 * @return true if user has been matched in database, false otherwise
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws noUserWithThatNameException if user is not registered under the given email in the database
	 */
	public static boolean connect(String user, String pwd) throws ClassNotFoundException, SQLException, noUserWithThatNameException {
		
		try {
		
			Class.forName("org.postgresql.Driver");
		
		} catch (ClassNotFoundException e) {
		
			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
			e.printStackTrace();
			return false;
			
		}
		
		Connection connection = null;
		Statement state = null;
		try {
					
			connection = DriverManager.getConnection("jdbc:postgresql://18.194.236.50:5432/ilsoa", "ilsoa","ilsoa");
			state = connection.createStatement();
			
			
			String query = "SELECT id, isadmin FROM users WHERE email='"+user+"' and hash=crypt('"+pwd+"',hash);";
			ResultSet res = state.executeQuery(query);
			
			//Retrieve by column name         
	        int count = 0;
	        boolean isadmin = false;
	        while( res.next() ) {
	        	count += 1 ;
	        	isadmin = res.getBoolean("isadmin");
	        }			
			
	         // close resources
	         res.close();
	         state.close();
	         connection.close();
		
	         if( count == 1) {
		        	return true;
		        } else {
		        	 throw new noUserWithThatNameException(user);
		        }
	         
		} catch (SQLException e) {
		
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return false;
		
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
	
	/**
	 * 
	 * @param email
	 * @param pwd
	 * @param fn : first name
	 * @param ln :  last name
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void registry(String email, String pwd, String fn, String ln) throws ClassNotFoundException, SQLException {
		
		try {
		
			Class.forName("org.postgresql.Driver");
		
		} catch (ClassNotFoundException e) {
		
			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
			e.printStackTrace();
			return;
		}
			
		Connection connection = null;
		Statement state = null;
		try {
					
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres","admin");
			state = connection.createStatement();
			
			//creates entry in users, with id, email, hash
			String qusers = "INSERT INTO users (email, hash) VALUES ( '" + email +"', '"+ pwd+"' );";
			state.executeUpdate(qusers);
			
			String qid = "SELECT id FROM users WHERE email='" + email + "' and hash='" + pwd +"';";
			ResultSet resId = state.executeQuery(qid);
			
			if(resId.next()) {
				int id = resId.getInt("id");
				
				String qinfo = "INSERT INTO info_users VALUES ( " + id + ", '"+ fn +"', '"+ ln +"' );";
				state.executeUpdate(qinfo);
			}
			
			resId.close();         
			state.close();
	        connection.close();
		
		} catch (SQLException e) {
		
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		
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

	/**
	 * 
	 * @param email
	 * @return true if user exists, false otherwise
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean exists(String email) throws ClassNotFoundException, SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
			e.printStackTrace();
			return false;
		}
			
		Connection connection = null;
		Statement state = null;
		try {
					
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres","admin");
			state = connection.createStatement();
			
			String qid = "SELECT id FROM users WHERE email='" + email +"';";
			ResultSet resId = state.executeQuery(qid);
			
			//if the query resultset is empty the querys result was null
			if( resId.next() ) {
				return true;
			}
			
	         // close resources
	         resId.close();
	         state.close();
	         connection.close();
		
		} catch (SQLException e) {
		
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return false;
		
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
		
		return false;
	}
	
	
	/**
	 * 
	 * @param email
	 * @return true if user exists, false otherwise
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean isAdmin(String email) throws ClassNotFoundException, SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
			e.printStackTrace();
			return false;
		}
			
		Connection connection = null;
		Statement state = null;
		try {
					
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres","admin");
			state = connection.createStatement();
			
			String qid = "SELECT isadmin FROM users WHERE email='" + email +"';";
			ResultSet resId = state.executeQuery(qid);
			
			//if the query resultset is empty the querys result was null
			boolean isadmin = false;
			while( resId.next() ) {
				isadmin = resId.getBoolean("isadmin");
			}
			
	         // close resources
	         resId.close();
	         state.close();
	         connection.close();
	         
	         return isadmin;
	         
		} catch (SQLException e) {
		
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return false;
		
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
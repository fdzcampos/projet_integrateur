package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import psql.Postgres;

/**
 * Servlet implementation class Servlet_register
 */
@WebServlet("/servlet_register")
public class Servlet_register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String first = request.getParameter("first_name");
		String last = request.getParameter("last_name");
		String pwd = request.getParameter("password");
		String conf = request.getParameter("password_confirmation");
		
		//check that both passwords are the same
		if( pwd.equals(conf) == false ) {

			//careful, passwords don't match!
			getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
		
		}else if( first.isEmpty() ) {
			
			// invalid first name, it cannot be empty
			getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
		
		}else if( last.isEmpty() ){
			
			// invalid last name, it cannot be empty
			getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			
		}else {
			
			//check that the user hasn't already registered
			try {
				
				if(Postgres.exists(email) == true ) {
				
					//print "user already exists, log in!"
					getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
					
				}else {
					
					try {
						
						Postgres.registry(email,pwd,first,last);
						
					} catch (ClassNotFoundException | SQLException e) {
							
						e.printStackTrace();
						
						//print, "there was a problem connecting to our database, please try again"
						getServletContext().getRequestDispatcher("/register.jsp");
						return;	
					}
					
				}
				
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
				//print, "there was a problem connecting to our database, please try again"
				getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
		}
		
		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		
	}
	
	
	
}

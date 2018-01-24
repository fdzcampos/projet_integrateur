package servlets;

import psql.Postgres;
import psql.noUserWithThatNameException;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_login
 */
@WebServlet("/servlet_login")
public class Servlet_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		if( pwd == null) {
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		try {
			
			Postgres.connect(email,pwd);
			
		} catch (ClassNotFoundException | SQLException e) {
				
			e.printStackTrace();
		
		} catch ( noUserWithThatNameException e) {
			
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		//do not erase this id or the return from the catch 
		if(response.isCommitted() == false) {
			
			HttpSession session = request.getSession();
			session.setAttribute("user", email);
		
			getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);
		}			
	}

}

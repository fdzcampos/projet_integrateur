package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Servlet implementation class Servlet_report
 */
@WebServlet("/report")
public class Servlet_report extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Client client;
	private WebTarget target;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_report() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		client = ClientBuilder.newClient();
	    target = client.target("http://localhost:8080/SOA_Project/webapi/report/pdf");
	    Response resp = target.request(MediaType.APPLICATION_JSON)
	    				 .get(Response.class);
	    System.out.println(resp.getLocation());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import fr.insa.soa.SOA_Project.Topic;
import fr.insa.soa.SOA_Project.Message;

/**
 * Servlet implementation class Servlet_topic
 */
@WebServlet("/topic")
public class Servlet_topic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Client client;
	private WebTarget target;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_topic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTopic = 1;
		if(request.getParameter("idTopic") != null){
			idTopic = Integer.parseInt(request.getParameter("idTopic"));
		}else if(request.getSession().getAttribute("idTopic") != null){
			idTopic = (int) request.getSession().getAttribute("idTopic");
		}
		
		int page = 1;
		String pageParam = request.getParameter("page");
		if(pageParam != null){
			page = Integer.parseInt(pageParam);
		}
		
		Topic topic = new Topic();
		client = ClientBuilder.newClient();
	    target = client.target("http://localhost:8080/SOA_Project/webapi/forum/topic/" + idTopic + "/page/" + page);
	    topic = target.request(MediaType.APPLICATION_JSON)
	    				 .get(Topic.class);
	    
	    boolean moreMessages = topic.getMessages().size() > 20;
	    
		request.setAttribute("topic", topic);
		request.setAttribute("moreMessages", moreMessages);
		request.getRequestDispatcher("topic.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String messageText = request.getParameter("message"); // A faire correspondre avec les noms des champs du formulaire
		int topicId = 1;
		if(request.getParameter("idTopic") != null){
			topicId = Integer.parseInt(request.getParameter("idTopic"));
		}else{
			topicId = (int) request.getSession().getAttribute("idTopic");
		}
		
		int userId = 6;
		// int userId = request.getSession().getAttribute("userId"); // Le vrai userId
		
		System.out.println("Text: [" + messageText + "]");
		System.out.println("topicID: [" + topicId + "]");
		JSONObject jsonBody = new JSONObject();
	   
	    JSONObject user = new JSONObject();
	    user.put("id", new Integer(userId));
	    
	    JSONObject topic = new JSONObject();
	    topic.put("id", new Integer(topicId));
	  
	    jsonBody.put("text", messageText);
	    jsonBody.put("topic", topic);
	    jsonBody.put("user", user);

	    Entity<String> postBody = Entity.json(jsonBody.toJSONString());
	
	    System.out.println("BODY: [" + postBody.getEntity() + "]");
	    
		client = ClientBuilder.newClient();
	    target = client.target("http://localhost:8080/SOA_Project/webapi/forum/message");
	    
	    Response serviceResponse = target.request(MediaType.APPLICATION_JSON).post(postBody);
	    
	    // ADD ANY KAFKA THINGY HERE
	    request.getSession().setAttribute("idTopic", topicId);
	    response.sendRedirect("topic");
		//request.setAttribute("idTopic", topicId);
		//request.getRequestDispatcher("topic.jsp").forward(request, response);
	}

}

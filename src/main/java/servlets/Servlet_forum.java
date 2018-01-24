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
 * Servlet implementation class Servlet_forum
 */
@WebServlet("/forum")
public class Servlet_forum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Client client;
	private WebTarget target;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_forum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
		String pageParam = request.getParameter("page");
		if(pageParam != null){
			page = Integer.parseInt(pageParam);
		}
		
		ArrayList<Topic> topics = new ArrayList<Topic>();
		client = ClientBuilder.newClient();
	    target = client.target("http://localhost:8080/SOA_Project/webapi/forum/topic/page/" + page);
	    topics = target.request(MediaType.APPLICATION_JSON)
	    			   .get(ArrayList.class);
	    
	    boolean moreTopics = topics.size() > 20;
	    
		request.setAttribute("topics", topics);
		request.setAttribute("moreTopics", moreTopics);
		request.getRequestDispatcher("forum.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String messageText = request.getParameter("message"); // A faire correspondre avec les noms des champs du formulaire
		String title = request.getParameter("title");
		int userId = 2;
		// int userId = request.getSession().getAttribute("userId"); // Le vrai userId
		
		JSONObject jsonBody = new JSONObject();
	   
	    JSONObject user = new JSONObject();
	    user.put("id", new Integer(userId));
	  
	    List<Message> messages = new ArrayList<Message>();
	    Message message = new Message();
	    message.setText(messageText);
	    messages.add(message);
	    
	    jsonBody.put("title", title);
	    jsonBody.put("user", user);
	    jsonBody.put("messages", messages);

	    Entity<String> postBody = Entity.json(jsonBody.toJSONString());
	
		client = ClientBuilder.newClient();
	    target = client.target("http://localhost:8080/SOA_Project/webapi/forum/topic");
	    
	    Response serviceResponse = target.request(MediaType.APPLICATION_JSON).post(postBody);
	    
	    
	    // ADD ANY KAFKA THINGY HERE

		request.getRequestDispatcher("/forum/topic").forward(request, response);
	}

}

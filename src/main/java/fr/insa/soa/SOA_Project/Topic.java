package fr.insa.soa.SOA_Project;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Topic {
	int id;
	String title;
	Timestamp date;
	int nbMessages;
	User user;
	ArrayList<Message> messages;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public int getNbMessages() {
		return nbMessages;
	}
	public void setNbMessages(int nbMessages) {
		this.nbMessages = nbMessages;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ArrayList<Message> getMessages() {
		return messages;
	}
	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}
	public void addMessage(Message message){
		this.messages.add(message);
	}
	
}

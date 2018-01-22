package fr.insa.soa.SOA_Project;

public class Partner {
	int id;
	String name;
	String email;
	String description;
	
	public Partner(){
		id = -1;
		name = "no name";
		email = "no email";
		description = "no description";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

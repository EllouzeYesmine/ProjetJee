package tn.iit.model;

public class Agent extends User{

	public Agent() {
		super();
		this.setRole("agent");
	}

	public Agent(String username, String lastName, String email, String password) {
		super(username, lastName, email, password, "agent");
	}
	

}

package tn.iit.model;

public class Agent extends User{

	public Agent() {
		super();
		this.setRole("agent");
	}

	public Agent(int id, String username, String lastName, String email, String password) {
		super(id, username, lastName, email, password, "agent");
	}
	

}

package tn.iit.model;

public class Admin extends User{

	public Admin() {
		this.setRole("admin");
	}

	public Admin(String username, String lastName, String email, String password) {
		super(username, lastName, email, password, "admin");
	}
	

}

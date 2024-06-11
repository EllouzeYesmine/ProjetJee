package tn.iit.model;

public class Admin extends User{

	public Admin() {
		this.setRole("admin");
	}

	public Admin(int id, String username, String lastName, String email, String password) {
		super(id, username, lastName, email, password, "admin");
	}
	

}

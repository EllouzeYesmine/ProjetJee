package tn.iit.model;

public class Teacher extends User{

	public Teacher(String username, String lastName, String email, String password) {
		super(username, lastName, email, password, "enseignant");
		
	}
	
	  public Teacher() {
	        this.setRole("enseignant");
	    }

}

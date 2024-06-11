package tn.iit.model;

public class Teacher extends User{

	public Teacher(int id, String username, String lastName, String email, String password) {
		super(id, username, lastName, email, password, "enseignant");
		
	}
	
	  public Teacher() {
	        this.setRole("enseignant");
	    }

}

package tn.iit.model;

public class User {
	private int id;
	private String username;
	private String lastName;
	private String email;
	private String password;
	private String role;
	public User() {}

	public User(int id, String username, String lastName, String email, String password, String role) {
		this.id = id;
		this.username = username;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

// Getters and Setters
	public int getIdUser() {
		return id;
	}

	public void setIdUser(int idUser) {
		this.id = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
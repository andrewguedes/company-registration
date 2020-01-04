package br.com.andrew.registration.model;

public class Login {
	
	private String password;
	private String login;
	
	public Login() {
		
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean checkLogin(String login, String password) {
		
		if(!this.login.equals(login.toLowerCase())) {
			return false;
		}
		
		if(!this.password.equals(password)) {
			return false;
		}
		
		return true;
	}
	
}

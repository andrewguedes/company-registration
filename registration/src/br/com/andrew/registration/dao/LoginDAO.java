package br.com.andrew.registration.dao;

import br.com.andrew.registration.model.Login;

public class LoginDAO {
	
	private DataBase conn;
	
	public LoginDAO(DataBase conn) {
		this.conn = conn;
	}
	
	public void addLogin(Login login) {
		conn.getUsers().add(login);		
	}
	
	public void removeLogin(Login login) {
		conn.getUsers().remove(login);
	}
	
	public void ChangePassword() {
		
	}
	
	public Login checkUser(String login, String password) {
		
		for(Login user : conn.getUsers()) {
			if(user.checkLogin(login, password)) {
				return user;
			}
		}
		
		return null;
	}

}

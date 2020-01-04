package br.com.andrew.registration.dao;

public class ConnectionFactory {
	
	public ConnectionFactory() {}
	
	public DataBase getConnection() {
		return new DataBase();
	}

}

package br.com.andrew.registration.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.andrew.registration.model.Company;
import br.com.andrew.registration.model.Login;

public class DataBase {
	
	private static List<Login> users = new ArrayList<>();
	private static List<Company> companies = new ArrayList<>();
	private static Integer id = 1;
	
	static {
		Company empresa = new Company();
		empresa.setId(id++);
		empresa.setName("Andrew");
		
		Company empresa2 = new Company();
		empresa2.setId(id++);
		empresa2.setName("Guedes");
		
		Company empresa3 = new Company();
		empresa3.setId(id++);
		empresa3.setName("Siqueira");
		
		Company empresa4 = new Company();
		empresa4.setId(id++);
		empresa4.setName("Siqueira Guedes");
		
		companies.add(empresa);
		companies.add(empresa2);
		companies.add(empresa3);
		companies.add(empresa4);
		
		Login lg = new Login();
		lg.setLogin("andrew");
		lg.setPassword("123");

		Login lg2 = new Login();
		lg2.setLogin("guedes");
		lg2.setPassword("321");
		
		users.add(lg);
		users.add(lg2);
		
	}
	
	public Integer getId() {
		return DataBase.id;
	}
	public void setId() {
		DataBase.id++;
	}
	public void setId(Integer id) {
		DataBase.id = id;
	}
	
	public List<Company> getCompanies(){
		return DataBase.companies;
	}
	
	public List<Login> getUsers(){
		return DataBase.users;
	}

}

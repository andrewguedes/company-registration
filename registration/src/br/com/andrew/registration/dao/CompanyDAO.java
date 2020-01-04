package br.com.andrew.registration.dao;

import java.util.Iterator;
import java.util.List;

import br.com.andrew.registration.model.Company;

public class CompanyDAO {

	private DataBase conn;
	
	public CompanyDAO(DataBase conn) {
		this.conn = conn;
	}
	
	public Company getCompany(Integer id) {
		for(Company comp : conn.getCompanies()) {
			if(comp.getId().equals(id)) {
				return comp;
			}
		}
		return null;
	}
	
	public List<Company> getCompanies(){
		return conn.getCompanies();
	}
	
	public void addCompany(Company company) {
		
		if((company.getId() == null) || ((company.getId() < conn.getId()) && (company.getId() != null))) {
			company.setId(conn.getId() + 1);
			conn.setId();
		}else {
			conn.setId(company.getId() + 1);
		}
		
		conn.getCompanies().add(company);
	}
	
	public void removeCompany(Integer id) {
		
		Iterator<Company> it = conn.getCompanies().iterator();
		
		while(it.hasNext()) {
			Company company = it.next();
			
			if(company.getId() == id) {
				it.remove();
			}
		}
	}
	
	public Company searchCompanyById(Integer id) {
		for (Company company : conn.getCompanies()) {
			if(company.getId() == id) {
				return company;
			}
		}
		return null;
	}

}

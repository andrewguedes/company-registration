package br.com.andrew.registration.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.andrew.registration.dao.CompanyDAO;
import br.com.andrew.registration.dao.DataBase;
import br.com.andrew.registration.model.Company;
import br.com.andrew.registration.util.ConstantsUtil;

public class ListCompanies extends ActionResult {

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("Listando empresas cadastradas");
		
		List<Company> companies = new CompanyDAO((DataBase)request.getAttribute(ConstantsUtil.CONNECTION)).getCompanies();
		
		request.setAttribute("companies", companies);
		
		return view(ConstantsUtil.LIST_COMPANIES_JSP, ConstantsUtil.FORWARD);
		
	}
}

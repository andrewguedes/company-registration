package br.com.andrew.registration.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.andrew.registration.dao.CompanyDAO;
import br.com.andrew.registration.dao.DataBase;
import br.com.andrew.registration.model.Company;
import br.com.andrew.registration.util.ConstantsUtil;

public class ShowCompany extends ActionResult {

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		Company company = new CompanyDAO((DataBase)request.getAttribute(ConstantsUtil.CONNECTION)).searchCompanyById(id);
		
		System.out.println("Empresa: " + company.getName() + " foi consultada.");

		request.setAttribute("company", company);
		
		return view(ConstantsUtil.FORM_CHANGE_COMPANY_JSP, ConstantsUtil.FORWARD);
		
				
	}

}

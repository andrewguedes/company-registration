package br.com.andrew.registration.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.andrew.registration.dao.CompanyDAO;
import br.com.andrew.registration.dao.DataBase;
import br.com.andrew.registration.util.ConstantsUtil;

public class RemoveCompany extends ActionResult {

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Integer id =  Integer.valueOf(request.getParameter("id"));
		
		new CompanyDAO((DataBase)request.getAttribute(ConstantsUtil.CONNECTION)).removeCompany(id);
		
		System.out.println("Empresa: "+ id + " foi removida.");
		
		return view(ConstantsUtil.LIST_COMPANIES, ConstantsUtil.REDIRECT);
		
	}

}

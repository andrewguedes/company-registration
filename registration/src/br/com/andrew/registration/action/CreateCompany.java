package br.com.andrew.registration.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.andrew.registration.dao.CompanyDAO;
import br.com.andrew.registration.dao.DataBase;
import br.com.andrew.registration.model.Company;
import br.com.andrew.registration.util.ConstantsUtil;
import br.com.andrew.registration.util.FormatDate;

public class CreateCompany extends ActionResult {

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String dateCompany = request.getParameter("date");
		String nameCompany = request.getParameter("name");
		Date openingDate = null;

		try {

			openingDate = FormatDate.FormatDateBr(dateCompany);

		} catch (ParseException e) {

			throw new ServletException(e);

		}

		Company company = new Company();
		company.setName(nameCompany);
		company.setOpeningDate(openingDate);

		new CompanyDAO((DataBase)request.getAttribute(ConstantsUtil.CONNECTION)).addCompany(company); 

		request.setAttribute("company", company.getName());
		
		return view(ConstantsUtil.LIST_COMPANIES, ConstantsUtil.REDIRECT);
	}

}

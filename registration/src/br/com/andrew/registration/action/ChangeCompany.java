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

public class ChangeCompany extends ActionResult {

	public ActionResult execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String openinDateOld = request.getParameter("date");
		String nameCompany = request.getParameter("name");
		Integer id = Integer.valueOf(request.getParameter("id"));

		Date openingDate = null;

		try {

			openingDate = FormatDate.FormatDateBr(openinDateOld);

		} catch (ParseException e) {

			throw new ServletException(e);

		}

		Company company = new CompanyDAO((DataBase)request.getAttribute(ConstantsUtil.CONNECTION)).searchCompanyById(id);

		System.out.println("Empresa: " + company.getName() + " está sendo alterada.");

		company.setName(nameCompany);
		company.setOpeningDate(openingDate);

		return view(ConstantsUtil.LIST_COMPANIES, ConstantsUtil.REDIRECT);
	}

}

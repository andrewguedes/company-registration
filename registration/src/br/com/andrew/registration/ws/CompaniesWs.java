package br.com.andrew.registration.ws;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.andrew.registration.dao.CompanyDAO;
import br.com.andrew.registration.dao.DataBase;
import br.com.andrew.registration.model.Company;
import br.com.andrew.registration.util.ConstantsUtil;
import br.com.andrew.registration.util.RideResponse;

@WebServlet("/ws/v1/companies")
public class CompaniesWs  extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Company> companies = new CompanyDAO((DataBase)request.getAttribute(ConstantsUtil.CONNECTION)).getCompanies();
		RideResponse.rideResponse(companies, request, response);

	}

}

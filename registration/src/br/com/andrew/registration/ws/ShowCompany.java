package br.com.andrew.registration.ws;

import java.io.IOException;

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

@WebServlet("/ws/v1/showCompany")
public class ShowCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowCompany() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		Company company = new CompanyDAO((DataBase)request.getAttribute(ConstantsUtil.CONNECTION)).getCompany(id);
		RideResponse.rideResponse(company, request, response);
	}

}

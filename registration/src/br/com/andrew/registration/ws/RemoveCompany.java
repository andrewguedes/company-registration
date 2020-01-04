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

@WebServlet("/ws/v1/removeCompany")
public class RemoveCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RemoveCompany() {
        super();
    }
    
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		CompanyDAO db = new CompanyDAO((DataBase)request.getAttribute(ConstantsUtil.CONNECTION));
		Company company = db.getCompany(id);
		db.removeCompany(id);
		RideResponse.rideResponse(company, request, response);
		
	}

}

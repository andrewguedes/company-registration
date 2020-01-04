package br.com.andrew.registration.ws;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.andrew.registration.dao.CompanyDAO;
import br.com.andrew.registration.dao.DataBase;
import br.com.andrew.registration.model.Company;
import br.com.andrew.registration.util.BodyRequest;
import br.com.andrew.registration.util.ConstantsUtil;
import br.com.andrew.registration.util.FormatDate;
import br.com.andrew.registration.util.RideResponse;

@WebServlet("/ws/v1/addCompany")
public class AddCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddCompany() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String aux = BodyRequest.GetBody(request);
		HashMap<String, String> map = (HashMap<String, String>) BodyRequest
				.MapBody(aux, Company.class.getDeclaredFields().length);
		
		Company company = new Company();
		Date date = null;
		
		company.setId(Integer.valueOf(map.get("id").toString()));
		company.setName(map.get("name").toString());
		
		try {
			date = FormatDate.FormatDateBr(map.get("openingDate").toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		company.setOpeningDate(date);
		
		new CompanyDAO((DataBase)request.getAttribute(ConstantsUtil.CONNECTION)).addCompany(company);
		RideResponse.rideResponse(company, request, response);
		
	}

}

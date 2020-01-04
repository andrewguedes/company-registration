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

@WebServlet("/ws/v1/changeCompany")
public class ChangeCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangeCompany() {
        super();
    }

	protected void doPut(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String aux = BodyRequest.GetBody(request);
		HashMap<String, String> map = (HashMap<String, String>) BodyRequest
				.MapBody(aux, Company.class.getDeclaredFields().length);
		
		Company company = new CompanyDAO((DataBase)request.getAttribute(ConstantsUtil.CONNECTION))
				.getCompany(Integer.valueOf(map.get("id")));
		company.setName(map.get("name"));
		
		Date date = null;
		try {
			date = FormatDate.FormatDateBr(map.get("openingDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		company.setOpeningDate(date);
		RideResponse.rideResponse(company, request, response);
		
		
	}

}

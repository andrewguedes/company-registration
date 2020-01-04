package br.com.andrew.registration.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.andrew.registration.util.ConstantsUtil;

public class LeadLogin extends ActionResult {

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return view(ConstantsUtil.FORM_LOGIN_JSP, ConstantsUtil.FORWARD);
		
	}

}

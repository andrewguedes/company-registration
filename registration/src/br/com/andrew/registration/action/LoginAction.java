package br.com.andrew.registration.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.andrew.registration.dao.DataBase;
import br.com.andrew.registration.dao.LoginDAO;
import br.com.andrew.registration.model.Login;
import br.com.andrew.registration.util.ConstantsUtil;

public class LoginAction extends ActionResult {

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Login user = new LoginDAO((DataBase)request.getAttribute(ConstantsUtil.CONNECTION)).checkUser(login, password);
		
		if(user != null) {
			System.out.println("O usuário: " + login + " realizou o login com sucesso.");
			
			HttpSession session = request.getSession(); 
			session.setAttribute("login", user);
			
			return view(ConstantsUtil.LIST_COMPANIES, ConstantsUtil.REDIRECT);
		}else {
			System.out.println("O usuário: " + login + " não está cadastrado.");
			
			return view(ConstantsUtil.LEAD_LOGIN, ConstantsUtil.REDIRECT);
		}
	}

}

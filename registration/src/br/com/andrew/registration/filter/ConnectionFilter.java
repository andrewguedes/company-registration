package br.com.andrew.registration.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.andrew.registration.dao.ConnectionFactory;
import br.com.andrew.registration.dao.DataBase;

//@WebFilter(urlPatterns = {"/ChangeCompany","/CreateCompany","/ListCompanies","/LoginAction","/RemoveCompany","/ShowCompany","/ws/*"})
@WebFilter(urlPatterns = {"/*"})
public class ConnectionFilter implements Filter {

    public ConnectionFilter() {}
    public void init(FilterConfig fConfig) throws ServletException {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		DataBase conn  = new ConnectionFactory().getConnection();
		request.setAttribute("connection", conn);
		chain.doFilter(request, response);
		
	}


}

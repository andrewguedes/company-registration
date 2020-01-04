package br.com.andrew.registration.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.andrew.registration.util.ConstantsUtil;

@WebFilter(urlPatterns = { "/RegisterCompany", "/RemoveCompany", "/LoginAction", "/ShowCompany", 
		"/ChangeCompany", "/CreateCompany", "/ListCompanies" })
public class AuthorizationFilter implements Filter {

	public AuthorizationFilter() {}

	public void init(FilterConfig fConfig) throws ServletException {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Autorização Filter.");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		HttpSession session = req.getSession();

		boolean islogged = (session.getAttribute("login") != null);

		boolean isPageLogin = (req.getRequestURI().split("/")[2].equals("LoginAction")
				|| req.getRequestURI().split("/")[2].equals("LeadLogin"));

		if (!islogged && !isPageLogin) {			
			resp.sendRedirect("LeadLogin");
			return;
		}

		chain.doFilter(request, response);
	}

}

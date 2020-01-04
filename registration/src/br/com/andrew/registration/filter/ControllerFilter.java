package br.com.andrew.registration.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.andrew.registration.action.ActionResult;
import br.com.andrew.registration.action.IActionResult;
import br.com.andrew.registration.util.ConstantsUtil;

@WebFilter("/*")
public class ControllerFilter implements Filter {

	private boolean webServer = false;
	private String requestUri;

	public ControllerFilter() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		RequestDispatcher rd = null;
		
		this.requestUri = request.getRequestURI();
		this.setTypeOfService(this.requestUri);

		if (this.webServer) {
			
			rd = request.getRequestDispatcher(editRequestUri(this.requestUri));
			rd.forward(request, response);
			
		} else {
			
			String nameOfClass = getNameOfClass(request.getRequestURI());
			ActionResult address = null;

			try {
				Class<?> cls = Class.forName(nameOfClass);
				IActionResult actionResult = (IActionResult) cls.newInstance();
				address = actionResult.execute(request, response);

				if (address.isForward()) {
					rd = request.getRequestDispatcher(ConstantsUtil.WEB_INF_VIEW + address.getAction());
					rd.forward(request, response);
				} else {
					response.sendRedirect(address.getAction());
				}

			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {

				e.printStackTrace();
			}
		}

	}

	private String getNameOfClass(String requestUri) {
		String result = null;
		String[] uri = requestUri.split("/");

		result = ConstantsUtil.BR_COM_ANDREW_REGISTRATION_ACTION + uri[2];

		return result;
	}

	private void setTypeOfService(String requestUri) {

		String[] uri = requestUri.split("/");
		List<String> uriList = Arrays.asList(uri);

		if (uriList.contains(ConstantsUtil.WS)) {
			this.webServer = true;
		}else {
			this.webServer = false;
		}

	}
	
	private String editRequestUri(String uri) {
		
		return uri.replaceAll("/registration", "");
		
	}
}

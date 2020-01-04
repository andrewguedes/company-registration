package br.com.andrew.registration.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class MonitoringFilter implements Filter {

    public MonitoringFilter() {}
    
    public void init(FilterConfig fConfig) throws ServletException {}

	public void destroy() {	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		String action = request.getParameter("action");
		
		long before = System.currentTimeMillis();
		chain.doFilter(request, response);
		long after = System.currentTimeMillis();
		
		System.out.println("Tempo de execução da Action: "+ action + " -> " + (after - before));
	}


}

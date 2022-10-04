package com.esiee.tp3.filter;

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

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter(urlPatterns={"/protected/*"}, description="Filtre UTF8")
public class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		System.out.println("Filter enter");
		HttpServletResponse respond = (HttpServletResponse) arg1;
		HttpServletRequest request = (HttpServletRequest) arg0;
		
		HttpSession session = request.getSession(true);
		String id = (String) session.getAttribute("id");
		System.out.println("sesoinID= " + id);
		
		if(id == null) {
			System.out.println("Filter rejected");
			respond.encodeRedirectURL("/tp2/index.jsp");
			respond.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Filter refuse auth");
			return;
		}
		
		System.out.println("Filter passed");
		arg2.doFilter(request, respond);
		
	}

}

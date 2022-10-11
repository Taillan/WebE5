package com.esiee.tp3.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.esiee.tp3.domain.Person;
import com.esiee.tp3.model.Datamodel;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Datamodel database; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("AuthServlet get");
		HttpSession session = request.getSession(true);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		session.invalidate();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String password = request.getParameter("password");
		String id = request.getParameter("id");
		System.out.println("id post " + id);
		System.out.println("password post " + password);
		HttpSession session = request.getSession(true);
		
		Datamodel database = Datamodel.getInstance();
		Map<Long,Person> lPerson = database.getlPerson();
		
		for( int i =0; i < lPerson.size();i++) {
			if(lPerson.get(i).getLogin().equals(id)) {
				if(lPerson.get(i).getPassword().equals(password)) {
					session.setAttribute("id", id);
					response.encodeRedirectURL("/tp2/protected/File.jsp");
				}
			}
		}
		if(session.getAttribute("id") == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Auth Failed");
			response.encodeRedirectURL("/tp3/LoggingFail.jsp");
		}
		else{
			response.encodeRedirectURL("/tp3/protected/File.jsp");
		}
		// TODO	VErif
			//throw ServletEcep unauthorized access
		
	}

}

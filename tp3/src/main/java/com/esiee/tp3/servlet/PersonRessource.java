package com.esiee.tp3.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esiee.tp3.domain.Mail;
import com.esiee.tp3.domain.Person;
import com.esiee.tp3.model.Datamodel;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Function
 */
@WebServlet("/api/ressources/person/*")
public class PersonRessource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonRessource() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String json = null;
		ObjectMapper mapper = new ObjectMapper();

		if (RessourceUriAnalyser.hasIdParameter(req)) {
			Long id = RessourceUriAnalyser.getIdParameter(req);
			json = mapper.writeValueAsString(findOne(id));
			System.out.println();
		} else {
			json = mapper.writeValueAsString(findAll());
		}
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String json = null;
		ObjectMapper mapper = new ObjectMapper();
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		Person pers = mapper.readValue(body, Person.class);
		if (pers.getId() != null) {
			throw new ServletException("id must be null !");
		}
		save(pers);
		json = mapper.writeValueAsString(pers);
		resp.setStatus(201);
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}

	protected Person findOne(Long id) {
		Datamodel database = Datamodel.getInstance();
		return database.getPerson(id);
	}

	protected List<Person> findAll() {
		Datamodel database = Datamodel.getInstance();
		return database.getlPerson();
	}

	protected void save(Person pers) {
		Datamodel database = Datamodel.getInstance();
/*
		for(Mail mail : pers.getMail()) {
			pers.setMail(database.getMail(mail.getId()));
		}*/
		pers.setCivility(database.getCivility(pers.getCivility().getId()));
		pers.setFunction(database.getFunction(pers.getFunction().getId()));
		database.setPerson(pers);
	}


}

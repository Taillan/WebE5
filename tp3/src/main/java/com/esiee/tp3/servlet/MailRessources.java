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
import com.esiee.tp3.model.Datamodel;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Function
 */
@WebServlet("/api/ressources/mail/*")
public class MailRessources extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailRessources() {
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
		Mail mail = mapper.readValue(body, Mail.class);
		if (mail.getId() != null) {
			throw new ServletException("id must be null !");
		}
		save(mail);
		json = mapper.writeValueAsString(mail);
		resp.setStatus(201);
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}

	protected Mail findOne(Long id) {
		Datamodel database = Datamodel.getInstance();
		return database.getMail(id);
	}

	protected List<Mail> findAll() {
		Datamodel database = Datamodel.getInstance();
		return database.getlMail();
	}

	protected void save(Mail mail) {
		Datamodel database = Datamodel.getInstance();
		mail.setType(database.getMailType(mail.getTypeId()));
		database.setMail(mail);
	}


}

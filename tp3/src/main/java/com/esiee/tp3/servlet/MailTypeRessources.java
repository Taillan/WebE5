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
import com.esiee.tp3.domain.MailType;
import com.esiee.tp3.model.Datamodel;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Function
 */
@WebServlet("/api/ressources/mailtype/*")
public class MailTypeRessources extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailTypeRessources() {
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
		MailType mType = mapper.readValue(body, MailType.class);
		if (mType.getId() != null) {
			throw new ServletException("id must be null !");
		}
		save(mType);
		json = mapper.writeValueAsString(mType);
		resp.setStatus(201);
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String json = null;
		ObjectMapper mapper = new  ObjectMapper();
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		MailType mType = mapper.readValue(body, MailType.class);
		if(mType.getId() == null) {
			throw new ServletException("id is required !");
		}
		save(mType);
		json = mapper.writeValueAsString(mType);
		resp.setStatus(200);
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}

	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		if(RessourceUriAnalyser.hasIdParameter(req)) {
			Long id = RessourceUriAnalyser.getIdParameter(req);
			MailType obj = findOne(id);
			if(obj == null) {
				throw new ServletException("Product not found for id \'"+id+"\' !");
			}
			delete(obj);
			resp.setStatus(200);
		}else {
			throw new ServletException("id is required");
		}
	}

	protected void delete(MailType obj) {
		Datamodel database = Datamodel.getInstance();
		database.delMailType(obj);
	}
	
	protected MailType findOne(Long id) {
		Datamodel database = Datamodel.getInstance();
		return database.getMailType(id);
	}

	protected List< MailType> findAll() {
		Datamodel database = Datamodel.getInstance();
		return database.getlMailType();
	}

	protected void save(MailType mType) {
		Datamodel database = Datamodel.getInstance();
		database.setMailType(mType);
	}


}

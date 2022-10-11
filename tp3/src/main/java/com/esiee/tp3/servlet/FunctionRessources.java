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

import com.esiee.tp3.domain.Civility;
import com.esiee.tp3.domain.Function;
import com.esiee.tp3.domain.Function;
import com.esiee.tp3.model.Datamodel;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Function
 */
@WebServlet("/api/ressources/function/*")
public class FunctionRessources extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FunctionRessources() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		Function fct = mapper.readValue(body, Function.class);
		if (fct.getId() != null) {
			throw new ServletException("id must be null !");
		}
		save(fct);
		json = mapper.writeValueAsString(fct);
		resp.setStatus(201);
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String json = null;
		ObjectMapper mapper = new  ObjectMapper();
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		Function fct = mapper.readValue(body, Function.class);
		if(fct.getId() == null) {
			throw new ServletException("id is required !");
		}
		save(fct);
		json = mapper.writeValueAsString(fct);
		resp.setStatus(200);
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		if(RessourceUriAnalyser.hasIdParameter(req)) {
			Long id = RessourceUriAnalyser.getIdParameter(req);
			Function obj = findOne(id);
			if(obj == null) {
				throw new ServletException("Product not found for id \'"+id+"\' !");
			}
			delete(obj);
			resp.setStatus(200);
		}else {
			throw new ServletException("id is required");
		}
	}

	protected void delete(Function obj) {
		Datamodel database = Datamodel.getInstance();
		database.delFunction(obj);
	}

	protected Function findOne(Long id) {
		Datamodel database = Datamodel.getInstance();
		return database.getFunction(id);
	}

	protected List< Function> findAll() {
		Datamodel database = Datamodel.getInstance();
		return database.getlFunction();
	}

	protected void save(Function fct) {
		Datamodel database = Datamodel.getInstance();
		database.setFunction(fct);
	}


}

package com.esiee.tp3.servlet;

import javax.servlet.http.HttpServletRequest;

public class RessourceUriAnalyser {
private static final String PATH_SEPARATOR = "/";
	
	public static boolean hasIdParameter(HttpServletRequest req) {
		boolean result = false;
		String pathInfo = req.getPathInfo();
		if (pathInfo != null) {
			result = true;
		}
		return result;
	}
	
	public static Long getIdParameter(HttpServletRequest req) {
		Long id = null;
		String pathInfo = req.getPathInfo();
		if (pathInfo != null) {
			String[] pathParts = pathInfo.split(PATH_SEPARATOR);
			if (pathParts.length > 0) {
				String part1 = pathParts[1];
				id = Long.parseLong(part1);
			}
			
		}
		return id;
	}
	
	public static boolean hasFirstRelationParameter(HttpServletRequest req) {
		boolean result = false;
		String pathInfo = req.getPathInfo();
		if (pathInfo != null) {
			String[] pathParts = pathInfo.split(PATH_SEPARATOR);
			if (pathParts.length > 2) {
				result = true;
			}
		}
		return result;
	}
	
	public static String getFirstRelationParameter(HttpServletRequest req) {
		String result = null;
		String pathInfo = req.getPathInfo();
		if (pathInfo != null) {
			String[] pathParts = pathInfo.split(PATH_SEPARATOR);
			if (pathParts.length > 2) {
				result = pathParts[2];
			}
		}
		return result;
	}
}

package com.esiee.tp3.domain;

import java.io.Serializable;

public class Function implements Serializable {

	private static final long serialVersionUID =1L;

	private int id;
	private String code;
	private String label;
	
	public Function () {
		super();
		this.id = 0 ;
		this.code = "";
		this.label = "";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}

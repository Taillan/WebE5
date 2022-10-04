package com.esiee.tp3.domain;

import java.io.Serializable;

public class Civility  implements Serializable {

	private static final long serialVersionUID =1L;
	private Long id;
	private String code;
	private String label;
	
	public Civility() {
		super();
		this.id = new Long(0);
		this.code = "33";
		this.label = "FR";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = new Long(id);
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

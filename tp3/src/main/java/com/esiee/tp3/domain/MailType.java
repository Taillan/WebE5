package com.esiee.tp3.domain;

import java.io.Serializable;

public class MailType  implements Serializable {

	private static final long serialVersionUID =1L;
	
	private Long id;
	private String code;
	private String label;	

	public MailType() {
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

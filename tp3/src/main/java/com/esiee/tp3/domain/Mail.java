package com.esiee.tp3.domain;

import java.io.Serializable;

import com.esiee.tp3.model.Datamodel;

public class Mail implements Serializable {

	private static final long serialVersionUID =1L;
	private Long id;
	private String address;

	private MailType type;
	
	public Mail() {
	}
	
	public MailType getType() {
		return type;
	}
	
	public Long getTypeId() {
		return type.getId();
	}

	public void setType(MailType type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = new Long(id);
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}

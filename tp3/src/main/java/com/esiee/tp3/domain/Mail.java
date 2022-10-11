package com.esiee.tp3.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Mail implements Serializable {

	private static final long serialVersionUID =1L;
	private int id;
	private String address;

	private MailType type;
	
	public Mail() {
		this.id = 0;
		this.address = "mail@host.com";
		this.type = new MailType();
	}
	
	public MailType getType() {
		return type;
	}

	public void setType(MailType type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}

package com.esiee.tp3.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Person implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	private Long id;
	private String lastname;
	private String firstname;
	private String mobilPhone;
	private String login;
	private String password;
	private Function function;
	private Civility civility;

	@JsonIgnore
	private List<Mail> addMail;
	
	public Person() {
	}
	
    public void finalize()
    {
         this.addMail = null;  
    }
	
	public Function getFunction() {
		return function;
	}
	public void setFunction(Function function) {
		this.function = function;
	}
	public Civility getCivility() {
		return civility;
	}
	public void setCivility(Civility civility) {
		this.civility = civility;
	}
	public Long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = new Long(id);
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public List<Mail> getMail() {
		return addMail;
	}
	public void setMail(Mail Mail) {
		this.addMail.add(Mail);
	}
	public String getMobilPhone() {
		return mobilPhone;
	}
	public void setMobilPhone(String mobilPhone) {
		this.mobilPhone = mobilPhone;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

package com.esiee.tp2.domain;

public class Person {
	
	private int id;
	private String lastname;
	private String firstname;
	private String mail;
	private String mobilPhone;
	private String login;
	private String password;
	private Function function;
	private Civility civility;
	
	
	public Person() {
		super();
		this.id = 0;
		this.lastname = "";
		this.firstname = "";
		this.mail = "";
		this.mobilPhone = "";
		this.login = "admin";
		this.password = "azerty";
		this.function = null ;
		this.civility = null;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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

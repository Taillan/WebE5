package com.esiee.tp3.model;

import java.util.HashMap;
import java.util.Map;

import com.esiee.tp3.domain.Civility;
import com.esiee.tp3.domain.Function;
import com.esiee.tp3.domain.MailType;
import com.esiee.tp3.domain.Person;
import com.esiee.tp3.domain.mail;

public final class Datamodel {
    private static Datamodel instance;
	Map<Integer,Person> lPerson;
	Map<Integer,Civility> lCivility;
	Map<Integer,Function> lFunction;
	Map<Integer,mail> lmail;
	Map<Integer,MailType> lMailType;
	

	private Datamodel() {
		this.lPerson = new HashMap<Integer,Person>();
		this.lCivility = new HashMap<Integer,Civility>();
		this.lFunction = new HashMap<Integer,Function>();
		this.lmail = new HashMap<Integer,mail>();
		this.lMailType = new HashMap<Integer,MailType>();
		
		this.init();
        this.instance = this;
		
	}
	
	private void init() {
		lPerson.put(0, new Person());
		lCivility.put(0, new Civility());
		lFunction.put(0, new Function());
		lmail.put(0, new mail());
		lMailType.put(0, new MailType());
		
	}

	public static Datamodel getInstance() {
        if (instance == null) {
            instance = new Datamodel();
        }
        return instance;
    }
	
	public Map<Integer,Person> getlPerson() {
		return lPerson;
	}
	
	public Person getPerson(int id) {
		return lPerson.get(id);
	}
	
	public Map<Integer,Civility> getlCivility() {
		return lCivility;
	}

	public Civility getCivility(Long id) {
		return lCivility.get(id);
	}

	public void setCivility(Civility civ) {
		lCivility.put(lCivility.size(), civ);
	}
	
	public Map<Integer,Function> getlFunction() {
		return lFunction;
	}

	public Function getFunction(int id) {
		return lFunction.get(id);
	}

	public Map<Integer, mail> getLmail() {
		return lmail;
	}

	public void setLmail(Map<Integer, mail> lmail) {
		this.lmail = lmail;
	}

	public Map<Integer, MailType> getlMailType() {
		return lMailType;
	}

	public void setlMailType(Map<Integer, MailType> lMailType) {
		this.lMailType = lMailType;
	}
}

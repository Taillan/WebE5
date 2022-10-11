package com.esiee.tp3.model;

import java.util.HashMap;
import java.util.Map;

import com.esiee.tp3.domain.Civility;
import com.esiee.tp3.domain.Function;
import com.esiee.tp3.domain.MailType;
import com.esiee.tp3.domain.Person;
import com.esiee.tp3.domain.Mail;

public final class Datamodel {
    private static Datamodel instance;
	HashMap<Long,Person> lPerson;
	HashMap<Long,Civility> lCivility;
	HashMap<Long,Function> lFunction;
	HashMap<Long,Mail> lmail;
	HashMap<Long, MailType> lMailType;
	

	private Datamodel() {
		this.lPerson = new HashMap<Long,Person>();
		this.lCivility = new HashMap<Long,Civility>();
		this.lFunction = new HashMap<Long,Function>();
		this.lmail = new HashMap<Long,Mail>();
		this.lMailType = new HashMap<Long,MailType>();
		
		this.init();
        this.instance = this;
		
	}
	
	private void init() {
		this.setFunction(new Function());
		this.setCivility(new Civility());
		this.setMailType(new MailType());
		lPerson.put(new Long(0), new Person());
		lmail.put(new Long(0), new Mail());
		
	}

	public static Datamodel getInstance() {
        if (instance == null) {
            instance = new Datamodel();
        }
        return instance;
    }
	
	public Map<Long,Person> getlPerson() {
		return lPerson;
	}
	
	public Person getPerson(int id) {
		return lPerson.get(id);
	}
	
	public Map<Long,Civility> getlCivility() {
		return lCivility;
	}

	public Civility getCivility(Long id) {
		return lCivility.get(id);
	}

	public void setCivility(Civility civ) {
		if(civ.getId() == null) {
			civ.setId(lCivility.size());
		}
		lCivility.put(new Long(lCivility.size()), civ);
	}

	public Function getFunction(Long id) {
		return lFunction.get(id);
	}
	
	public void setFunction(Function fct) {
		if(fct.getId() == null) {
			fct.setId(lFunction.size());
		}
		lFunction.put(new Long(lFunction.size()), fct);
	}

	public MailType getMailType(Long id) {
		return lMailType.get(id);
	}
	
	public void setMailType(MailType mailType) {
		if(mailType.getId() == null) {
			mailType.setId(lMailType.size());
		}
		lMailType.put(new Long(lMailType.size()), mailType);
	}
	
	public Map<Long,Function> getlFunction() {
		return lFunction;
	}
	public Map<Long, Mail> getLmail() {
		return lmail;
	}

	public void setLmail(HashMap<Long, Mail> lmail) {
		this.lmail = lmail;
	}

	public Map<Long, MailType> getlMailType() {
		return lMailType;
	}

	public void setlMailType(HashMap<Long, MailType> lMailType) {
		this.lMailType = lMailType;
	}
}

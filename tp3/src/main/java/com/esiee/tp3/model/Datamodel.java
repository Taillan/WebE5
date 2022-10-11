package com.esiee.tp3.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	HashMap<Long,Mail> lMail;
	HashMap<Long, MailType> lMailType;
	

	private Datamodel() {
		this.lPerson = new HashMap<Long,Person>();
		this.lCivility = new HashMap<Long,Civility>();
		this.lFunction = new HashMap<Long,Function>();
		this.lMail = new HashMap<Long,Mail>();
		this.lMailType = new HashMap<Long,MailType>();
		
		this.init();
        this.instance = this;
		
	}
	
	private void init() {
		
	}

	public static Datamodel getInstance() {
        if (instance == null) {
            instance = new Datamodel();
        }
        return instance;
    }
	
	public List<Person> getlPerson() {
		return new ArrayList<Person>(lPerson.values());
	}
	
	public Person getPerson(Long id) {
		return lPerson.get(id);
	}
	
	public void setPerson(Person pers) {
		if(pers.getId() == null) {
			pers.setId(lCivility.size());
		}
		lPerson.put(new Long(lPerson.size()), pers);
	}
	
	public List<Civility> getlCivility() {
		return new ArrayList<Civility>(lCivility.values());
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

	public Mail getMail(Long id) {
		return lMail.get(id);
	}
	
	public void setMail(Mail mail) {
		if(mail.getId() == null) {
			mail.setId(lMail.size());
		}
		lMail.put(new Long(lMail.size()), mail);
	}
	
	public List<Function> getlFunction() {
		return new ArrayList<Function>(lFunction.values());
	}
	public List< Mail> getlMail() {
		return new ArrayList<Mail>(lMail.values());
	}

	public void setLmail(HashMap<Long, Mail> lmail) {
		this.lMail = lmail;
	}

	public List< MailType> getlMailType() {
		return new ArrayList<MailType>(lMailType.values());
	}

	public void setlMailType(HashMap<Long, MailType> lMailType) {
		this.lMailType = lMailType;
	}
}

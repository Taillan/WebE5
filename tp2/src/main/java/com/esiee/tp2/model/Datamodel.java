package com.esiee.tp2.model;

import java.util.HashMap;
import java.util.Map;

import com.esiee.tp2.domain.Civility;
import com.esiee.tp2.domain.Function;
import com.esiee.tp2.domain.Person;

public final class Datamodel {
    private static Datamodel instance;
	Map<Integer,Person> lPerson;
	Map<Integer,Civility> lCivility;
	Map<Integer,Function> lFunction;
	

	private Datamodel() {
		this.lPerson = new HashMap<Integer,Person>();
		this.lCivility = new HashMap<Integer,Civility>();
		this.lFunction = new HashMap<Integer,Function>();
		this.init();
        this.instance = this;
		
	}
	
	private void init() {
		lPerson.put(0, new Person());
		lCivility.put(0, new Civility());
		lFunction.put(0, new Function());
		
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

	public Civility getCivility(int id) {
		return lCivility.get(id);
	}
	
	public Map<Integer,Function> getlFunction() {
		return lFunction;
	}

	public Function getFunction(int id) {
		return lFunction.get(id);
	}
}

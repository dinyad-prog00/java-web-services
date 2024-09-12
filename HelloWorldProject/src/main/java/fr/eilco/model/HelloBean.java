package fr.eilco.model;

import java.io.Serializable;
public class HelloBean implements Serializable {
	private String aName = "";
	public String getName(){
		return aName;
	}
	public void setName(String pName){
		aName = pName;
	}
}
package fr.eilco.ejbmodel;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "HelloBD", name = "HelloTable")
public class HelloBean implements Serializable {
	private int id;
	private String aName = "";

	@Id
	@GeneratedValue
	@Column(name = "pk_hello")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "message")
	public String getName() {
		return aName;
	}

	public void setName(String pName) {
		aName = pName;
	}
}
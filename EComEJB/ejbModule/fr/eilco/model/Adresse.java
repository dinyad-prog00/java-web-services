package fr.eilco.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "ecommerce", name = "adresse")
public class Adresse implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length=45)
	private String name;
	
	

	@Column(length=250)
	private String adresse;
	
	@Column(length=45)
	private String ville;
	
	@Column()
	private int cp;
	
	@ManyToOne
    @JoinColumn(name = "client_id")
	
	
    private Client client;
	public Adresse() {}
	public Adresse(String name,String adresse, String ville, int cp) {
		super();
		this.name=name;
		this.adresse = adresse;
		this.ville = ville;
		this.cp = cp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

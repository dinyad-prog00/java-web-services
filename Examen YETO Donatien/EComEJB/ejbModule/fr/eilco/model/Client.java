package fr.eilco.model;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "ecommerce", name = "client")
public class Client implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length=45)
	private String name;
	
	@Column(length=45, unique=true)
	private String email;
	
	@Column(length=64)
	private String password;
	
	@Column(length=15)
	private String telephone;

	public List<Adresse> getAdresses() {
		return adresses;
	}
	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}
	public void setCommandes(List<CommandeClient> commandes) {
		this.commandes = commandes;
	}

	@Column(length=250)
	private String adresse;

	public Client(){}
	// Constructor with parameters
    public Client(String name, String email, String password, String telephone, String adresse) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.adresse = adresse;
    }
    
	@OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
	private List<CommandeClient> commandes;
	
	@OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
	private List<Adresse> adresses;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<CommandeClient> getCommandes() {
		return commandes;
	}

	
}

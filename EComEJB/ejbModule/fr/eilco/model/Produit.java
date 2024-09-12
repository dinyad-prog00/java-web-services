package fr.eilco.model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(schema = "ecommerce", name = "produit")
public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length=45)
	private String name;
	
	@Column(length=250)
	private String description;
	
	@Column(precision = 5, scale = 2)
	private BigDecimal prix;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dernier_maj;
	
	 
	@ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
	
	@ManyToMany(mappedBy = "produits")
	private List<CommandeClient> commandes;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public Date getDernier_maj() {
		return dernier_maj;
	}

	public void setDernier_maj(Date dernier_maj) {
		this.dernier_maj = dernier_maj;
	}

	public Categorie getCategorie() {
		return categorie;
	}


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<CommandeClient> getCommandes() {
		return commandes;
	}

	
	
}

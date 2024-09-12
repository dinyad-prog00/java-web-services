package fr.eilco.model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(schema = "ecommerce", name = "commande_client")
public class CommandeClient implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(precision = 6, scale = 2)
	private BigDecimal montant;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_creation;
	
	@Column()
	private int no_confirmation;
	
	@ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
	
	@ManyToOne
    @JoinColumn(name = "adresse_livraison")
    private Adresse adresse;
	

	@ManyToMany
    @JoinTable(
        name = "produit_commande",
        joinColumns = @JoinColumn(name = "commande_client_id"),
        inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private List<Produit> produits;
	

	
	@OneToMany(mappedBy = "commandeClient",fetch = FetchType.EAGER)
	private List<ProduitCommande> produitCommandes;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getNo_confirmation() {
		return no_confirmation;
	}

	public void setNo_confirmation(int no_confirmation) {
		this.no_confirmation = no_confirmation;
	}

	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	public List<ProduitCommande> getProduitCommandes() {
		return produitCommandes;
	}

	public void setProduitCommandes(List<ProduitCommande> produitCommandes) {
		this.produitCommandes = produitCommandes;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


}

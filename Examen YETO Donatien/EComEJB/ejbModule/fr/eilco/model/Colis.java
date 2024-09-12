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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(schema = "ecommerce", name = "colis")
public class Colis implements Serializable  {
	
	
	
	@Id
	private int numero;
	
	@Column(precision = 6, scale = 2)
	private BigDecimal poids;
	
	@Column(length=45)
	private String destination;
	
	
	@Column(length=45)
	private String etat;
	
	@Temporal(TemporalType.DATE)
	private Date dateEnvoi;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dernierMAJ;


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public BigDecimal getPoids() {
		return poids;
	}


	public void setPoids(BigDecimal poids) {
		this.poids = poids;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public Date getDateEnvoi() {
		return dateEnvoi;
	}


	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}


	public Date getDernierMAJ() {
		return dernierMAJ;
	}


	public void setDernierMAJ(Date dernierMAJ) {
		this.dernierMAJ = dernierMAJ;
	}
	
	
	
	
}

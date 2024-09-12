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
@Table(schema = "ecommerce", name = "delivery")
public class Delivery implements Serializable  {
	@Id
	private int deliveryId ;
	
	@Column(length=45)
	private String deliveryAddress ;
	
	
	@Column(length=45)
	private String recipientName;
	
	@Temporal(TemporalType.DATE)
	private Date deliveryDate;
	
	public Delivery() {
		super();
		
	};

	public Delivery(int deliveryId, String deliveryAddress, String recipientName, Date deliveryDate) {
		super();
		this.deliveryId = deliveryId;
		this.deliveryAddress = deliveryAddress;
		this.recipientName = recipientName;
		this.deliveryDate = deliveryDate;
	}

	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	
	
}
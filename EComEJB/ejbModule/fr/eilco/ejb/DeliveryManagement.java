package fr.eilco.ejb;

import fr.eilco.model.Delivery;
import jakarta.ejb.Remote;

@Remote
public interface DeliveryManagement {
	public void createDelivery(Delivery delivery) ;
	public void updateDelivery(Delivery delivery) ;
	public void deleteDelivery(int deliveryId) ;
	public Delivery getDelivery(int deliveryId) ;
}

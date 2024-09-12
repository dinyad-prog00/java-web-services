package fr.eilco.ejb;

import fr.eilco.model.Colis;
import fr.eilco.model.Delivery;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Session Bean implementation class DeliveryManagementBean
 */
@Stateless(name = "DeliveryManagementBeanJNDI")
public class DeliveryManagementBean implements DeliveryManagement {

	@PersistenceContext(unitName = "managerECom")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public DeliveryManagementBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void createDelivery(Delivery delivery) {
    	em.persist(delivery);
    }
    
    @Override
	public void updateDelivery(Delivery delivery) {
    	em.merge(delivery);
    }
    
    @Override
	public void deleteDelivery(int deliveryId) {
    	Delivery d = getDelivery(deliveryId);
    	em.remove(d);
    }
    
    @Override
	public Delivery getDelivery(int deliveryId) {
    	Query query = em.createQuery("select h from Delivery h where h.deliveryId=:deliveryId", Delivery.class).setParameter("deliveryId", deliveryId);
    	return (Delivery)query.getSingleResult();
    }

}

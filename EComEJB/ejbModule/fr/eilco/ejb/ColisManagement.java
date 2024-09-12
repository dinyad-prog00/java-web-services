package fr.eilco.ejb;

import java.util.ArrayList;

import fr.eilco.model.Categorie;
import fr.eilco.model.Colis;
import fr.eilco.model.Produit;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Session Bean implementation class ColisManagement
 */
@Stateless(name = "ColisManagementJNDI")
public class ColisManagement implements ColisManagementRemote, ColisManagementLocal {

	@PersistenceContext(unitName = "managerECom")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ColisManagement() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void createColis(Colis colis) {
    	em.persist(colis);
    }
    @Override
	public void updateColis(Colis colis) {
    	em.merge(colis);
    }
    @Override
	public Colis suivreColis(int numero) {
    	Query query = em.createQuery("select h from Colis h where h.numero=:numero", Colis.class).setParameter("numero", numero);
    	return (Colis)query.getSingleResult();
    }
    
    @Override
	public  ArrayList<Colis> getAllColis(){
    	Query query = em.createQuery("select h from Colis h", Colis.class);
		return (ArrayList<Colis>)query.getResultList();
    }

}

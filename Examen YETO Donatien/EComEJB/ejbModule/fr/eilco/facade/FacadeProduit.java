package fr.eilco.facade;

import java.util.ArrayList;
import java.util.List;

import fr.eilco.model.Produit;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class FacadeProduit extends FacadeAbstraite<Produit>{
	@PersistenceContext(unitName = "managerECom")
	EntityManager em;

	@Override
	public void create(Produit entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Produit entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Produit entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produit find(Object id) {
		Query query = em.createQuery("select h from Produit h where h.id=:id", Produit.class).setParameter("id", id);
		return (Produit)query.getSingleResult();
	}

	@Override
	public ArrayList<Produit> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Produit> findCatProducts(int cat_id) {
		Query query = em.createQuery("select h from Produit h where h.categorie.id=:id", Produit.class).setParameter("id", cat_id);
		return (ArrayList<Produit>)query.getResultList();
		
	}
	
	

}

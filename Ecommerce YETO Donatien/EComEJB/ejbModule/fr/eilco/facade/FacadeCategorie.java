package fr.eilco.facade;

import java.util.ArrayList;
import java.util.List;

import fr.eilco.model.Categorie;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Stateless
public class FacadeCategorie extends FacadeAbstraite<Categorie>{
	@PersistenceContext(unitName = "managerECom")
	EntityManager em;
	
//	public FacadeCategorie(EntityManager em) {
//		this.em=em;
//	}
	
	@Override
	public void create(Categorie entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Categorie entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Categorie entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categorie find(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Categorie> findAll() {
		
		Query query = em.createQuery("select h from Categorie h", Categorie.class);
		return (ArrayList<Categorie>)query.getResultList();
	}
	

}

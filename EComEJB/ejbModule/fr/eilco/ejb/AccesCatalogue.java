package fr.eilco.ejb;

import java.util.ArrayList;

import fr.eilco.facade.FacadeCategorie;
import fr.eilco.facade.FacadeProduit;
import fr.eilco.model.Categorie;
import fr.eilco.model.Produit;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class AccesCatalogue
 */
@Stateless(name = "AccesCatalogueJNDI")
public class AccesCatalogue implements AccesCatalogueRemote, AccesCatalogueLocal {
	
	@PersistenceContext(unitName = "managerECom")
	EntityManager em;
	
	@EJB
    private FacadeCategorie facadeCategorie;

	@EJB
    private FacadeProduit facadeProduit;;
    
    
    /**
     * Default constructor. 
     */
    public AccesCatalogue() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public ArrayList<Categorie> getListCategories() {
		return facadeCategorie.findAll();

	}

	@Override
	public ArrayList<Produit> getListCatProduits(int cat_id) {
		
		return facadeProduit.findCatProducts(cat_id);
	}
	
	@Override
	public Produit getProduit(int id) {
		return facadeProduit.find(id);
	}
	

}

package fr.eilco.ejb;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import fr.eilco.facade.FacadeClient;
import fr.eilco.model.Adresse;
import fr.eilco.model.Client;
import fr.eilco.model.CommandeClient;
import fr.eilco.model.Panier;
import fr.eilco.model.PanierItem;
import fr.eilco.model.Produit;
import fr.eilco.model.ProduitCommande;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class OrderManager
 */
@Stateless(name = "OrderManagerJNDI")
public class OrderManager implements OrderManagerRemote, OrderManagerLocal {

	@PersistenceContext(unitName = "managerECom")
	EntityManager em;
	
	@EJB
    private FacadeClient facadeClient;
	
    /**
     * Default constructor. 
     */
    public OrderManager() {
        // TODO Auto-generated constructor stub
    }
    
    public void validerCommande(Client client, Adresse adresse,Panier panier) {
        
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setClient(client);
        commandeClient.setMontant(BigDecimal.valueOf(panier.getTotalPrice()));
        commandeClient.setDate_creation(new Date());
        commandeClient.setNo_confirmation(genererNumeroConfirmation());
        commandeClient.setAdresse(adresse);

       
        em.persist(commandeClient);
        
        for (PanierItem panierItem : panier.getItems()) {
            Produit produit = panierItem.getProduit();

            // Créer une instance de ProduitCommande
            ProduitCommande produitCommande = new ProduitCommande();
            produitCommande.setQuantite(panierItem.getQt());
            produitCommande.setProduit(produit);
            produitCommande.setCommandeClient(commandeClient);
            
            em.persist(produitCommande);
            
        }

        // 4. Vider le Panier
        panier.viderPanier();
    }

    private int genererNumeroConfirmation() {
        long timestamp = System.currentTimeMillis();
        return (int) (timestamp % 1000000);
    }
    
    public List<CommandeClient> getClientCommande(int client_id){
    	Client client = facadeClient.find(client_id);
    	return client.getCommandes();
    }
    
    public List<Adresse> getClientAdresses(int client_id){
    	Client client = facadeClient.find(client_id);
    	return client.getAdresses();
    }
    
    public boolean addAdresse(Adresse adresse) {
    	try {
    		em.persist(adresse);
    		return true;
    	}catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    	
    }

}

package fr.eilco.facade;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import fr.eilco.model.Categorie;
import fr.eilco.model.Client;
import fr.eilco.model.Produit;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Stateless
public class FacadeClient extends FacadeAbstraite<Client>{
	@PersistenceContext(unitName = "managerECom")
	EntityManager em;
	
//	public FacadeCategorie(EntityManager em) {
//		this.em=em;
//	}
	
	@Override
	public void create(Client entity) {
		
		em.persist(entity);	
	}

	@Override
	public void edit(Client entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Client entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client find(Object id) {
		Query query = em.createQuery("select h from Client h where h.id=:id", Client.class).setParameter("id", id);
		return (Client)query.getSingleResult();
	}
	
	public Client findByEmail(String email) {
		Query query = em.createQuery("select h from Client h where h.email=:email", Client.class).setParameter("email", email);
		List<Client> r = (List<Client>)query.getResultList();
		
		if(r.size()==0) {
			return null;
		}
		return r.get(0);
	
	}

	@Override
	public ArrayList<Client> findAll() {
		
		Query query = em.createQuery("select h from Client h", Categorie.class);
		return (ArrayList<Client>)query.getResultList();
	}
	
	public static String hashPassword(String password) {
        try {
            
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Mettre le mot de passe dans le digest
            md.update(password.getBytes());

            
            byte[] hashedBytes = md.digest();

            // Convertir le hachage en format hexadécimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}

package fr.eilco.ejb;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import fr.eilco.facade.FacadeCategorie;
import fr.eilco.facade.FacadeClient;
import fr.eilco.model.Client;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class AuthManager
 */
@Stateless(name = "AuthManagerJNDI")
public class AuthManager implements AuthManagerRemote, AuthManagerLocal {

	@PersistenceContext(unitName = "managerECom")
	EntityManager em;
	
	@EJB
    private FacadeClient facadeClient;
	
    /**
     * Default constructor. 
     */
    public AuthManager() {
        // TODO Auto-generated constructor stub
    }
    
    
    @Override
	public  String hashPassword(String password) {
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
    @Override
    public boolean signup(Client client) {
    	try {
    		Client c = facadeClient.findByEmail(client.getEmail());
    		if(c!=null) {
    			return false;
    		}
    		facadeClient.create(client);
    		return true;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    
    @Override
	public Client verifyAuth(String email, String password) {
    	
		Client c = facadeClient.findByEmail(email);
		if(c!=null && c.getPassword().equals(hashPassword(password))) {
			
			return c;
		}
		return null;	
	}
}

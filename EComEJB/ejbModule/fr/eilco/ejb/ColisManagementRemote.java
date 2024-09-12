package fr.eilco.ejb;

import java.util.ArrayList;

import fr.eilco.model.Colis;
import jakarta.ejb.Remote;

@Remote
public interface ColisManagementRemote {
	public void createColis(Colis colis);
	public void updateColis(Colis colis);
	public Colis suivreColis(int numero);
	public  ArrayList<Colis> getAllColis();
}

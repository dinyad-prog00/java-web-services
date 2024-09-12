package fr.eilco.ejb;

import java.util.ArrayList;

import fr.eilco.model.Colis;
import fr.eilco.model.Produit;
import jakarta.ejb.Local;

@Local
public interface ColisManagementLocal {
	public void createColis(Colis colis);
	public void updateColis(Colis colis);
	public Colis suivreColis(int numero);
	public  ArrayList<Colis> getAllColis();
}

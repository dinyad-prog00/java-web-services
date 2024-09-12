package fr.eilco.ejb;

import java.util.List;

import fr.eilco.model.Adresse;
import fr.eilco.model.Client;
import fr.eilco.model.CommandeClient;
import fr.eilco.model.Panier;
import jakarta.ejb.Remote;

@Remote
public interface OrderManagerRemote {
	public void validerCommande(Client client, Adresse adresse, Panier panier) ;
	public List<CommandeClient> getClientCommande(int client_id);
	public boolean addAdresse(Adresse adresse) ;
	public List<Adresse> getClientAdresses(int client_id);
}

package fr.eilco.ejb;

import fr.eilco.model.Client;
import jakarta.ejb.Remote;

@Remote
public interface AuthManagerRemote {
	public  String hashPassword(String password);
	public boolean signup(Client client);
	public Client verifyAuth(String email, String password);
}

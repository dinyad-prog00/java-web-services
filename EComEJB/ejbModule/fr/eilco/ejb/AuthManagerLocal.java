package fr.eilco.ejb;

import fr.eilco.model.Client;
import jakarta.ejb.Local;

@Local
public interface AuthManagerLocal {
	public  String hashPassword(String password);
	public boolean signup(Client client);
	public Client verifyAuth(String email, String password);
}

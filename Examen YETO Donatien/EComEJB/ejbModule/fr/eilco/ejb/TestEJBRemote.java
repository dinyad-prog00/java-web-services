package fr.eilco.ejb;

import jakarta.ejb.Remote;

@Remote
public interface TestEJBRemote {
	 public String testMe();
}

package fr.eilco.ejb;

import jakarta.ejb.Local;

@Local
public interface TestEJBLocal {
	 public String testMe();
}

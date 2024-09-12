package fr.eilco.ejb;

import fr.eilco.ejbmodel.HelloBean;
import jakarta.ejb.Local;

@Local
public interface HelloEJBLocal {
	public String direBonjour(String name);
	public HelloBean direBonjourEntity(String name) ;
	public String direBonjourEntity2(String name);
}

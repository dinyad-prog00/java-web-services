package fr.eilco.ejb;

import fr.eilco.ejbmodel.HelloBean;
import jakarta.ejb.Remote;

@Remote
public interface HelloEJBRemote {
	public String direBonjour(String name);
	public HelloBean direBonjourEntity(String name) ;
	public String direBonjourEntity2(String name);
}

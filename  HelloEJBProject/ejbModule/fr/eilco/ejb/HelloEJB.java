package fr.eilco.ejb;

import fr.eilco.ejbmodel.HelloBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Session Bean implementation class HelloEJB
 */
@Stateless(name = "HelloJNDI")
public class HelloEJB implements HelloEJBRemote, HelloEJBLocal {
	@PersistenceContext(unitName = "managerHello")
	EntityManager mh;

	/**
	 * Default constructor.
	 */
	public HelloEJB() {
		// TODO Auto-generated constructor stub
	}

	public String direBonjour(String name) {
		System.out.println("Preparation du message pour dire bonjour " + name);
		return "Bonjour " + name;
	}

	public HelloBean direBonjourEntity(String name) {
		Query q = mh.createQuery("select h from HelloBean h");
		HelloBean helloBean = (HelloBean) q.getSingleResult();
		return helloBean;
	}

	public String direBonjourEntity2(String name){
    	Query q = mh.createQuery("select h.name from HelloBean h where h.id=:id").setParameter("id", 1);
    	String helloBean = (String)q.getSingleResult();
    	return helloBean;
    	}

}

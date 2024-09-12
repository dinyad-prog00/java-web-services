package fr.eilco.ejb;

import fr.eilco.model.TestBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Session Bean implementation class TestEJB
 */
@Stateless(name = "TestJNDI")
public class TestEJB implements TestEJBRemote, TestEJBLocal {
	@PersistenceContext(unitName = "managerECom")
	EntityManager mng;
    /**
     * Default constructor. 
     */
    public TestEJB() {
        // TODO Auto-generated constructor stub
    }
    public String testMe() {
//    	TestBean testEntity = new TestBean();
//    	testEntity.setMessage("Hello from ecommerce db");
//    	mng.persist(testEntity);
		System.out.println("Preparation du message");
		//return "Test message, super";
		Query q = mng.createQuery("select h.message from TestBean h where h.id=:id").setParameter("id", 1);
    	String helloBean = (String)q.getSingleResult();
    	return helloBean;
		
	}

}

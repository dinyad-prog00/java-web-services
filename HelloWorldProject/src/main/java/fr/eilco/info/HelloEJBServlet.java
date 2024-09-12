package fr.eilco.info;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import fr.eilco.ejb.HelloEJBRemote;
import fr.eilco.ejbmodel.HelloBean;

import java.io.IOException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;


/**
 * Servlet implementation class HelloEJBServlet
 */
public class HelloEJBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloEJBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String name = request.getParameter("nom");
			
				String message = "";
		//Connexion JNDI (annuaire pour localiser l'EJB)
		try{
			final Hashtable jndiProperties = new Hashtable();
			jndiProperties.put(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
			
			final Context context = new InitialContext(jndiProperties);
			final String appName = "HelloEAR";
			final String moduleName = "_HelloEJBProject";
			//final String distinctName = ""; //localier ejb sur jboss 7.2
			//sur jboss eap n'est plus nécessaire de spécifier distinct name
			final String beanName = "HelloJNDI";
			final String viewClassName = HelloEJBRemote.class.getName();
			
			//HelloEJBRemote remote = (HelloEJBRemote)
			// context.lookup("ejb:"+appName+"/"+moduleName+"/"+
			//"/"+distinctName+"/"+beanName+"!"+viewClassName);
			
			HelloEJBRemote remote = (HelloEJBRemote) context.lookup("ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+viewClassName);
			
			
			//message = remote.direBonjour(name);
			message = remote.direBonjourEntity2(name);
				}
		catch (Exception e) {	
		 e.printStackTrace();
		}
		
		HelloBean bean = new HelloBean();
		bean.setName(message);
		session.setAttribute("beanHello", bean);
		response.sendRedirect("HelloEJB.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

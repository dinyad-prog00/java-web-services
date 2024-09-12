package fr.eilco.utils;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import fr.eilco.ejb.TestEJBRemote;


public class Helpers {
	public static Object getRemoteClass(String JNDIName,String viewClassName) throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
		
		final Context context = new InitialContext(jndiProperties);
		final String appName = "EComEAR";
		final String moduleName = "EComEJB";
		System.out.println("ejb:"+appName+"/"+moduleName+"/"+JNDIName+"!"+viewClassName);
		return context.lookup("ejb:"+appName+"/"+moduleName+"/"+JNDIName+"!"+viewClassName);	
		
	}
}

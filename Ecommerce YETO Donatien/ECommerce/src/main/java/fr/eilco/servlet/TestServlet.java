package fr.eilco.servlet;
import fr.eilco.utils.Helpers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import fr.eilco.ejb.TestEJBRemote;


/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "Vide";
		try{
			final String viewClassName = TestEJBRemote.class.getName();
	
			TestEJBRemote remote = (TestEJBRemote) Helpers.getRemoteClass("TestJNDI",viewClassName);
			
			message = remote.testMe();
				}
		catch (Exception e) {	
		 e.printStackTrace();
		}
		 
		request.setAttribute("name", message);
		//response.sendRedirect("Hello.jsp?");
		request.getRequestDispatcher("Test.jsp").forward(request, response);
	}

}

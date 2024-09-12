package fr.eilco.info;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Vector;

import fr.eilco.ejbmodel.HelloBean;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*PrintWriter out = response.getWriter();
		  out.println("Hello YETO");*/
		
		//response.sendRedirect("Hello.html");
		
		//request.getRequestDispatcher("Hello.html").forward(request, response);
		
		/*String nom = request.getParameter("nom");
		//response.sendRedirect("Hello.jsp?name="+nom);*/
		
		/*String nom = request.getParameter("nom");
		request.setAttribute("name", nom);
		//response.sendRedirect("Hello.jsp?");
		request.getRequestDispatcher("Hello.jsp").forward(request, response);*/
		
		/*String nom = request.getParameter("nom");
		HelloBean bean = new HelloBean();
		bean.setName(nom);
		request.setAttribute("beanHello", bean);
		request.getRequestDispatcher("Hello2.jsp").forward(request, response);
		System.out.println("je continue а travailler " + nom);*/
		
		HttpSession session = request.getSession(true);
		String nom = request.getParameter("nom");
		Collection<HelloBean> listHello = new Vector<HelloBean>();
		for (int i = 0; i < 10; i++) {
		HelloBean bean = new HelloBean();
		bean.setName(nom + " " + i);
		listHello.add(bean);
		}
		session.setAttribute("beanHello", listHello);
		response.sendRedirect("Hello3vEL.jsp");
		System.out.println("je continue а travailler " + nom);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package fr.eilco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;

import fr.eilco.ejb.AccesCatalogueRemote;
import fr.eilco.ejb.OrderManagerRemote;
import fr.eilco.model.Adresse;
import fr.eilco.model.Client;
import fr.eilco.model.Panier;
import fr.eilco.model.PanierItem;
import fr.eilco.utils.Helpers;

/**
 * Servlet implementation class CommandeServlet
 */
public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/commande")) {
		final String viewClassName = OrderManagerRemote.class.getName();
		try {
			OrderManagerRemote remote = (OrderManagerRemote) Helpers.getRemoteClass("OrderManagerJNDI", viewClassName);
			HttpSession session = request.getSession(true);
		    Panier cart = (Panier) session.getAttribute("userCart");
		    Client client = (Client) session.getAttribute("user");
		    Adresse add = (Adresse)session.getAttribute("adresse");
		    System.out.println(cart);
		    System.out.println(client);
		    if(client!=null && cart!=null) {
		    	 System.out.println("hello");
		    	remote.validerCommande(client, add ,cart);
		    }
		    
		    session.removeAttribute("userCart");
		    
		    response.sendRedirect("/ecom/clienthome");
		    
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}else if(path.equals("/commanderesume")) {
			request.getRequestDispatcher("jsp-pages/commanderesume.jsp").forward(request, response);
		}
		else if(path.equals("/adresse")) {
			
			final String viewClassName = OrderManagerRemote.class.getName();
			HttpSession session = request.getSession(true);
				try {
					OrderManagerRemote remote = (OrderManagerRemote) Helpers.getRemoteClass("OrderManagerJNDI", viewClassName);
					Client client = (Client) session.getAttribute("user");
					List<Adresse> adresses =  (List<Adresse>) remote.getClientAdresses(client.getId());
					session.setAttribute("adresses", adresses);
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			request.getRequestDispatcher("jsp-pages/adresse.jsp").forward(request, response);
		}
		else if(path.equals("/chooseadresse")) {
			try {
				String addId = (String)request.getParameter("add");
				int id = Integer.parseInt(addId);
				HttpSession session = request.getSession(true);
				List<Adresse> adresses =(List<Adresse> ) session.getAttribute("adresses");
				
				for (Adresse it : adresses) {
		            if (it.getId() == id) {
		                
		                session.setAttribute("adresse", it);
		            }
		        }
				response.sendRedirect("/ecom/commanderesume");
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect("/ecom/adresse");
			}
		}
		else if(path.equals("/addadresse")) {
			request.getRequestDispatcher("jsp-pages/addadresse.jsp").forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		
		if(path.equals("/addadresse")) {
			try {
				final String viewClassName = OrderManagerRemote.class.getName();
				OrderManagerRemote remote = (OrderManagerRemote) Helpers.getRemoteClass("OrderManagerJNDI", viewClassName);
				HttpSession session = request.getSession(true);
				Client client = (Client) session.getAttribute("user");
				String name = request.getParameter("name");
				String adresse = request.getParameter("adresse");
				String ville  = request.getParameter("ville");
				String cp = request.getParameter("cp");
				int cpint = Integer.parseInt(cp);
				Adresse add = new Adresse(name,adresse,ville,cpint);
				add.setClient(client);
				remote.addAdresse(add);
				response.sendRedirect("/ecom/adresse");
				
			}catch(Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("jsp-pages/addadresse.jsp").forward(request, response);
			}
			
			
		}
	}

}

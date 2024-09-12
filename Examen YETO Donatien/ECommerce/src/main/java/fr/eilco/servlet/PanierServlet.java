package fr.eilco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eilco.ejb.AccesCatalogueRemote;
import fr.eilco.model.Panier;
import fr.eilco.model.PanierItem;
import fr.eilco.model.Produit;
import fr.eilco.utils.Helpers;

/**
 * Servlet implementation class PanierServlet
 */
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("jsp-pages/panier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productId = request.getParameter("productId");
		String opp = request.getParameter("opp");
		
		
		if(productId!=null && opp!=null) {
			try {
				int pId = Integer.parseInt(productId);
			final String viewClassName = AccesCatalogueRemote.class.getName();
			AccesCatalogueRemote remote = (AccesCatalogueRemote) Helpers.getRemoteClass("AccesCatalogueJNDI", viewClassName);
			HttpSession session = request.getSession(true);
		    Panier cart = (Panier) session.getAttribute("userCart");

		    if (cart == null) {
		        cart = new Panier();
		        session.setAttribute("userCart", cart);
		    }
		    
		    switch(opp){
		    	case "add":
		    		Produit p = remote.getProduit(pId);
					PanierItem item = new PanierItem(p,1);
				    cart.addItem(item);
				    break;
		    	case "delete":
		    		cart.deleteItem(pId);
		    		break;
		    	case "decrement":
		    		cart.decrementItem(pId);
		    	case "increment":
		    		cart.incrementItem(pId);
		    	default:
		    		break;
		    }
		    }
		    
			
			catch (Exception e) {
				e.printStackTrace();
		}
			}
		request.getRequestDispatcher("jsp-pages/panier.jsp").forward(request, response);
	}

}

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
import fr.eilco.ejb.AuthManagerRemote;
import fr.eilco.ejb.OrderManagerRemote;
import fr.eilco.model.Adresse;
import fr.eilco.model.Client;
import fr.eilco.model.CommandeClient;
import fr.eilco.utils.Helpers;

/**
 * Servlet implementation class AuthServlet
 */
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		
		if(path.equals("/login")) {
			request.getRequestDispatcher("jsp-pages/login.jsp").forward(request, response);
		}else if(path.equals("/signup")) {
			request.getRequestDispatcher("jsp-pages/signup.jsp").forward(request, response);
		}else if(path.equals("/logout")) {
			HttpSession session = request.getSession(true);
			session.removeAttribute("authenticated");
			session.removeAttribute("user");
			response.sendRedirect("/ecom");
		}else if(path.equals("/clienthome")) {
			final String viewClassName = OrderManagerRemote.class.getName();
			HttpSession session = request.getSession(true);
				try {
					OrderManagerRemote remote = (OrderManagerRemote) Helpers.getRemoteClass("OrderManagerJNDI", viewClassName);
					Client client = (Client) session.getAttribute("user");
					List<CommandeClient> commandes =  (List<CommandeClient>) remote.getClientCommande(client.getId());
					session.setAttribute("commandes", commandes);
					List<Adresse> adresses =  (List<Adresse>) remote.getClientAdresses(client.getId());
					session.setAttribute("adresses", adresses);
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			request.getRequestDispatcher("jsp-pages/clienthome.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		String  email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
        	final String viewClassName = AuthManagerRemote.class.getName();
			AuthManagerRemote remote = (AuthManagerRemote) Helpers.getRemoteClass("AuthManagerJNDI", viewClassName);
			HttpSession session = request.getSession(true);
			
		if(path.equals("/login")) {
		Client client =  remote.verifyAuth(email, password);
			if(client!=null) {
				session.removeAttribute("loginError");
				session.setAttribute("authenticated", true);
				session.setAttribute("user",client);
				String redirect = (String)session.getAttribute("loginRedirect");
				if(redirect!=null) {
					session.removeAttribute("loginRedirect");
					response.sendRedirect(redirect);
				}else {
					response.sendRedirect("/ecom");
				}
				
			}else {
				session.setAttribute("loginError","Email ou mot de passe incorrect !");
				request.getRequestDispatcher("jsp-pages/login.jsp").forward(request, response);
			}
			
		}
		
		else if(path.equals("/signup")) {
			
			String name  = request.getParameter("name");
			String phone = request.getParameter("phone");
			String addresse = request.getParameter("addresse");
	       
			Client client = new Client(name,email,remote.hashPassword(password),phone,addresse);
			
			if(remote.signup(client)) {
				session.removeAttribute("signupError");
				session.setAttribute("authenticated", true);
				session.setAttribute("user",client);
				response.sendRedirect("/ecom");
				
	        }else {
	        	session.setAttribute("signupError","Erreur lors de la création, le mail est peut être déjà utilisé !");
	        	request.getRequestDispatcher("jsp-pages/signup.jsp").forward(request, response);
	        }

			//request.getRequestDispatcher("jsp-pages/signup.jsp").forward(request, response);
		}
		}
        catch (Exception e) {
			e.printStackTrace();
	}
	}

}

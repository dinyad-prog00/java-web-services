package fr.eilco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import fr.eilco.ejb.AccesCatalogueRemote;
import fr.eilco.model.Categorie;
import fr.eilco.model.Produit;
import fr.eilco.utils.Helpers;

/**
 * Servlet implementation class ControleurServlet
 */
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControleurServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String path = request.getServletPath();
        System.out.println("path");
		System.out.println(path);

		if (path == null || path.equals("/")) {
			request.getRequestDispatcher("jsp-pages/index.jsp").forward(request, response);
		} else if (path.equals("/categories")) {
			try {
				final String viewClassName = AccesCatalogueRemote.class.getName();

				AccesCatalogueRemote remote = (AccesCatalogueRemote) Helpers.getRemoteClass("AccesCatalogueJNDI",
						viewClassName);

				ArrayList<Categorie> categories = remote.getListCategories();

				session.setAttribute("categories", categories);

				String catIdStr = request.getParameter("id");
				if (catIdStr != null) {
					try {
						int catId = Integer.parseInt(catIdStr);
						ArrayList<Produit> produits = remote.getListCatProduits(catId);
						session.setAttribute("produits", produits);
						session.setAttribute("id", catId);

					} catch (NumberFormatException e) {

						System.err.println("Invalid id format: " + e.getMessage());
					}
				}

				request.getRequestDispatcher("jsp-pages/categories.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (path.equals("/enregistrement")) {

		} else if (path.equals("/confirmation")) {

		} else {
			
			//response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

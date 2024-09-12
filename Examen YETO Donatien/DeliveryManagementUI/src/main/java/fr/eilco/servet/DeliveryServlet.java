package fr.eilco.servet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Date;

import javax.naming.NamingException;

import fr.eilco.ejb.AccesCatalogueRemote;
import fr.eilco.ejb.DeliveryManagement;
import fr.eilco.model.Delivery;
import fr.eilco.utils2.Helpers;

/**
 * Servlet implementation class DeliveryServlet
 */
public class DeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String viewClassName = DeliveryManagement.class.getName();

		try {
			DeliveryManagement remote = (DeliveryManagement) Helpers.getRemoteClass("DeliveryManagementBeanJNDI",
					viewClassName);
			String idStr = request.getParameter("id");
			
			int id = Integer.parseInt(idStr);
			Delivery test = remote.getDelivery(id);
			HttpSession session = request.getSession(true);
			session.setAttribute("delivery", test);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("delivery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String viewClassName = DeliveryManagement.class.getName();
		
		
		String action = request.getParameter("action");

		try {
			DeliveryManagement remote = (DeliveryManagement) Helpers.getRemoteClass("DeliveryManagementBeanJNDI",
					viewClassName);
			
			
			if(action.equals("create")) {
				String idStr = request.getParameter("id");
				int id = Integer.parseInt(idStr);
				String deliveryAddress = request.getParameter("deliveryAddress");
				String deliveryDate  = request.getParameter("deliveryDate");
				String recipientName  = request.getParameter("recipientName");
				Delivery delivery = new Delivery(id,deliveryAddress,recipientName ,new Date(deliveryDate ));
				remote.createDelivery(delivery);
				
			}
			else if(action.equals("update")) {
				String idStr = request.getParameter("id");
				int id = Integer.parseInt(idStr);
				String deliveryAddress = request.getParameter("deliveryAddress");
				String deliveryDate  = request.getParameter("deliveryDate");
				String recipientName  = request.getParameter("recipientName");
				Delivery delivery = new Delivery(id,deliveryAddress,recipientName ,new Date(deliveryDate ));
				remote.updateDelivery(delivery);
			}
			else if(action.equals("delete")) {
				String idStr = request.getParameter("id");
				int id = Integer.parseInt(idStr);
				remote.deleteDelivery(id);
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("delivery.jsp").forward(request, response);
	}

}

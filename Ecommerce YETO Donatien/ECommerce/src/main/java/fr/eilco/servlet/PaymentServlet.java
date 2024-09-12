package fr.eilco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

/**
 * Servlet implementation class PaymentServlet
 */
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Configurez votre clé secrète Stripe
		
		/*
       Stripe.apiKey = "sk_test_...";

        // Récupérez le token de la carte de crédit depuis le formulaire JSP
        String token = request.getParameter("stripeToken");

        // Créez une charge avec le token
        Map<String, Object> params = new HashMap<>();
        params.put("amount", 2000);
        params.put("currency", "usd");
        params.put("source", token);

        try {
            Charge charge = Charge.create(params);
            // Le paiement a réussi, vous pouvez effectuer des actions supplémentaires ici
        } catch (Exception e) {
            // Gérer les erreurs de paiement
        }*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

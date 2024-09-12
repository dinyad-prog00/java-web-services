package fr.eilco.services;

import fr.eilco.model.Panier;
import fr.eilco.model.PanierItem;
import jakarta.servlet.http.HttpSession;

public class GestionPanier {

    private static final String CART_SESSION_KEY = "userCart";

    public static Panier getCartFromSession(HttpSession session) {
        Panier cart = (Panier) session.getAttribute(CART_SESSION_KEY);
        if (cart == null) {
            cart = new Panier();
            session.setAttribute(CART_SESSION_KEY, cart);
        }
        return cart;
    }

    public static void addToCart(HttpSession session, PanierItem item) {
        Panier cart = getCartFromSession(session);
        cart.addItem(item);
    }
}

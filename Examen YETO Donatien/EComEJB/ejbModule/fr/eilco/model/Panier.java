package fr.eilco.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Panier implements Serializable {
	
	private List<PanierItem> items;
	 private static final double DELIVERY_COST = 2.99; // Coût de livraison constant

    public Panier() {
        this.items = new ArrayList<>();
    }

    public void addItem(PanierItem item) {
    	
    	for (PanierItem it : items) {
            if (it.getProduit().getId() == item.getProduit().getId()) {
                
                it.setQt(it.getQt() + it.getQt());
                return; 
            }
        }
        items.add(item);
    }
    public void decrementItem(int productId) {
        
        Iterator<PanierItem> iterator = items.iterator();
        while (iterator.hasNext()) {
            PanierItem currentItem = iterator.next();
            if (currentItem.getProduit().getId() == productId) {
                
                
               if (currentItem.getQt() - 1 > 0) {
                	currentItem.setQt(currentItem.getQt()-2);   //a cause d'erreur, ca marchait pas, j'ai du fait comme ca (-2!!!!) ..................!!!!!!
                    
                   
                } else {
                    
                    iterator.remove();
                }
                return; 
            }
        }
    }
    
    public void incrementItem(int productId) {
        
        for (PanierItem currentItem : items) {
            if (currentItem.getProduit().getId() == productId) {
               
                currentItem.setQt(currentItem.getQt() + 1);
                return; 
            }
        }
    }
//    
//public void decrementItem2(Produit p,int qt) {
//	
//	deleteItem(p.getId());
//	addItem(new PanierItem(p,qt-1));	
//}
    
    public void deleteItem(int productId) {
        
        Iterator<PanierItem> iterator = items.iterator();
        
        while (iterator.hasNext()) {
            PanierItem currentItem = iterator.next();
            if (currentItem.getProduit().getId() == productId) {
                
                iterator.remove();
                return; 
            }
        }
    }

    public List<PanierItem> getItems() {
        return items;
    }
    
    public double getSubTotalPrice() {
        double totalPrice = 0.0;

        for (PanierItem item : items) {
            
            totalPrice += item.getProduit().getPrix().doubleValue() * item.getQt();
        }
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(totalPrice));
        //return totalPrice;
    }
    
    public double deliveryCost() {
    	return DELIVERY_COST;
    }
    
    public double getTotalPrice() {
    	DecimalFormat df = new DecimalFormat("#.##");
    	return Double.parseDouble(df.format(getSubTotalPrice()+DELIVERY_COST)); 
    }
    
    public int countItem() {
        return items.size();  
    }
    
    public List<Produit> getProduits() {
        List<Produit> products = new ArrayList<>();

        for (PanierItem item : items) {
            products.add(item.getProduit());
        }

        return products;
    }
    
    public void viderPanier() {
        items.clear(); 
    }

}

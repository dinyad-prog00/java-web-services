package fr.eilco.ejb;
import java.util.ArrayList;

import fr.eilco.model.Categorie;
import fr.eilco.model.Produit;
import jakarta.ejb.Remote;

@Remote
public interface AccesCatalogueRemote {
	public ArrayList<Categorie> getListCategories();
	public ArrayList<Produit> getListCatProduits(int cat_id);
	public Produit getProduit(int id);
}

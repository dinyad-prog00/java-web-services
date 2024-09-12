package fr.eilco.model;

import java.io.Serializable;

public class PanierItem implements Serializable {
		private Produit produit;
		private int qt;
		
		public PanierItem(Produit produit, int qt) {
			super();
			this.produit = produit;
			this.qt = qt;
		}

		public Produit getProduit() {
			return produit;
		}

		public void setProduit(Produit produit) {
			this.produit = produit;
		}

		public int getQt() {
			return qt;
		}

		public void setQt(int qt) {
			this.qt = qt;
		}
		
}

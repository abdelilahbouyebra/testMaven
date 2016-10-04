package org.net.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.net.eboutique.entities.LigneCommandes;

public class Panier implements Serializable {
	private Map<Long, LigneCommandes> items = new HashMap<Long, LigneCommandes>();

	public void addItem(Produits p, int quantite) {
		LigneCommandes lc = items.get(p.getIdProduit());
		if (lc == null) {
			LigneCommandes art = new LigneCommandes();
			art.setProduits(p);
			art.setQte(quantite);
			art.setPrix(p.getPrix());
			items.put(p.getIdProduit(), art);
		} else {
			lc.setQte(lc.getQte() + quantite);
		}
	}

	public Collection<LigneCommandes> getItems() {
		return items.values();
	}

	public int getSize() {
		return items.size();
	}

	public double getTotal() {
		double total = 0;
		for (LigneCommandes lc : items.values()) {
			total += lc.getPrix() * lc.getQte();
		}
		return total;
	}

	public void deleteItem(Long idproduit) {
		items.remove(idproduit);
	}
}

package org.net.eboutique.Metiers;

import java.util.List;

import org.net.eboutique.entities.*;

public interface IinternauteMetier {
	public List<Categories> listCategories();
	public Categories getCategorie(Long idCat);
	public List<Produits> listproduits();
	public List<Produits> produitsParMotCle(String mc);
	public List<Produits> produitsParCategorie(Long idCat);
	public List<Produits> produitsSelectionnes();
	public Produits getProduit(Long idP);
	public Commandes enregistrerCommande(Panier p,Clients c);

}

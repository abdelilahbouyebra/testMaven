package org.net.eboutique.Dao;

import java.util.List;

import org.net.eboutique.entities.Categories;
import org.net.eboutique.entities.Clients;
import org.net.eboutique.entities.Commandes;
import org.net.eboutique.entities.Panier;
import org.net.eboutique.entities.Produits;
import org.net.eboutique.entities.Roles;
import org.net.eboutique.entities.Users;

public interface IBoutiqueDao {

	public Long ajouterCategorie(Categories c);
	public List<Categories> listCategories();
	public Categories getCategorie(Long idCat);
	public void supprimerCategrorie(Long idcat);
	public void modifierCategorie(Categories c);
	public Long ajouterProduit(Produits p, Long idCat);
	public List<Produits> listproduits();
	public List<Produits> produitsParMotCle(String mc);
	public List<Produits> produitsParCategorie(Long idCat);
	public List<Produits> produitsSelectionnes();
	public Produits getProduit(Long idP);
	public void supprimerProduit(Long idP);
	public void modifierProduit(Produits p);
	public void ajouterUser(Users u);
	public void attribuerRole(Roles r,Long userID);
	public Commandes enregistrerCommande(Panier p,Clients c);
}

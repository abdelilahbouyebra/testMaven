package org.net.eboutique.Metiers;

import java.util.List;



import org.net.eboutique.Dao.IBoutiqueDao;
import org.net.eboutique.entities.Categories;
import org.net.eboutique.entities.Clients;
import org.net.eboutique.entities.Commandes;
import org.net.eboutique.entities.Panier;
import org.net.eboutique.entities.Produits;
import org.net.eboutique.entities.Roles;
import org.net.eboutique.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class EboutiqueMetierImpl implements IAdminCategoriesMetier {
	
	

	private IBoutiqueDao dao;
	
//l'injection via Setter
	@Autowired
	@Qualifier("dao")
	public void setDao(IBoutiqueDao dao) {
		this.dao = dao;
	}
	

	@Override
	public Long ajouterProduit(Produits p, Long idCat) {
		// TODO Auto-generated method stub
		return dao.ajouterProduit(p, idCat);
	}


	@Override
	public void supprimerProduit(Long idP) {
		dao.supprimerProduit(idP);
	}

	@Override
	public void modifierProduit(Produits p) {
		// TODO Auto-generated method stub
		dao.modifierProduit(p);
		
	}

	@Override
	public Categories getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.getCategorie(idCat);
	}

	@Override
	public List<Produits> listproduits() {
		// TODO Auto-generated method stub
		return dao.listproduits();
	}

	@Override
	public List<Produits> produitsParMotCle(String mc) {
		// TODO Auto-generated method stub
		return dao.produitsParMotCle(mc);
	}

	@Override
	public List<Produits> produitsParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.produitsParCategorie(idCat);
	}

	@Override
	public List<Produits> produitsSelectionnes() {
		// TODO Auto-generated method stub
		return dao.produitsSelectionnes();
	}

	@Override
	public Produits getProduit(Long idP) {
		// TODO Auto-generated method stub
		return dao.getProduit(idP);
	}

	@Override
	public Commandes enregistrerCommande(Panier p, Clients c) {
		// TODO Auto-generated method stub
		return dao.enregistrerCommande(p, c);
	}

	@Override
	public Long ajouterCategorie(Categories c) {
		// TODO Auto-generated method stub
		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategrorie(Long idcat) {
		dao.supprimerCategrorie(idcat);
		
	}

	@Override
	public void modifierCategorie(Categories c) {
		
		dao.modifierCategorie(c);
		
	}

	@Override
	public void ajouterUser(Users u) {
		dao.ajouterUser(u);
		
	}

	@Override
	public void attribuerRole(Roles r, Long userID) {
		
		dao.attribuerRole(r, userID);
		
	}


	@Override
	public List<Categories> listCategories() {
		// TODO Auto-generated method stub
		return dao.listCategories();
	}

}

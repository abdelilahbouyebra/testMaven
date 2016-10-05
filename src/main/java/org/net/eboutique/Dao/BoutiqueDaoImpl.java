package org.net.eboutique.Dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.net.eboutique.entities.Categories;
import org.net.eboutique.entities.Clients;
import org.net.eboutique.entities.Commandes;
import org.net.eboutique.entities.LigneCommandes;
import org.net.eboutique.entities.Panier;
import org.net.eboutique.entities.Produits;
import org.net.eboutique.entities.Roles;
import org.net.eboutique.entities.Users;
import org.springframework.stereotype.Repository;

public class BoutiqueDaoImpl implements IBoutiqueDao{
	sqsqs
	
	private EntityManager em;
	

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Long ajouterCategorie(Categories c) {
		em.persist(c);
		return c.getIdCategorie();
	}

	@Override
	public List<Categories> listCategories() {
		Query q= em.createQuery("select c from Categories c");
		return q.getResultList();
	}

	@Override
	public Categories getCategorie(Long idCat) {
		Categories categorie=em.find(Categories.class,idCat);
		return categorie;
	}

	@Override
	public void supprimerCategrorie(Long idcat) {
		Categories cat=getCategorie(idcat);
		em.remove(cat);
		
	}

	@Override
	public void modifierCategorie(Categories c) {
		em.merge(c);
		
	}

	@Override
	public Long ajouterProduit(Produits p, Long idCat) {
		Categories categorie=getCategorie(idCat);
		p.setCategories(categorie);
		em.persist(p);
		return p.getIdProduit();
	}

	@Override
	public List<Produits> listproduits() {
		Query req=em.createQuery("select p from Produits p");
		return req.getResultList();
	}

	@Override
	public List<Produits> produitsParMotCle(String mc) {
		Query req=em.createQuery("select p from Produits p where p.designation like :x or p.description like :x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public List<Produits> produitsParCategorie(Long idCat) {
		Query req=em.createQuery("select p from Produits p where p.categories.idCategorie like:x");
		req.setParameter("x","%"+idCat+"%");
		return req.getResultList();
	}

	@Override
	public List<Produits> produitsSelectionnes() {
		
		Query req=em.createQuery("select p from Produits p where p.selectionner=true");
		return req.getResultList();
	}

	@Override
	public Produits getProduit(Long idP) {
		Produits prod=em.find(Produits.class,idP);
		return prod;
	}

	@Override
	public void supprimerProduit(Long idP) {
		Produits prod=getProduit(idP);
		em.remove(prod);
		
	}

	@Override
	public void modifierProduit(Produits p) {
		em.merge(p);
		
	}

	@Override
	public void ajouterUser(Users u) {
		em.persist(u);
		
	}

	@Override
	public void attribuerRole(Roles r, Long userID) {
		// TODO Auto-generated method stub
		Users user=em.find(Users.class,userID);
		user.getRoles().add(r);
		em.persist(r);

	}

	@Override
	public Commandes enregistrerCommande(Panier p, Clients c) {

		em.persist(c);
        Commandes cmd=new Commandes();
        cmd.setDateCommande(new Date());
        cmd.setItems(p.getItems());   
        for (LigneCommandes lc : p.getItems()) {
			em.persist(lc);
		}
        em.persist(cmd);
		
		return cmd;
	}

}

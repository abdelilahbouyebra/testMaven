package org.net.eboutique.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommandes implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLigneCommande;
	private double prix;
	private int qte;
	@ManyToOne
	@JoinColumn(name="idCommande")
	private Commandes  commandes;
	@ManyToOne
	@JoinColumn(name="idProduit")
	private Produits produits;
	public LigneCommandes() {
		super();
	}
	public LigneCommandes(double prix, int qte) {
		super();
		this.prix = prix;
		this.qte = qte;
	}
	public LigneCommandes(Long idLigneCommande, double prix, int qte,
			Commandes commandes, Produits produits) {
		super();
		this.idLigneCommande = idLigneCommande;
		this.prix = prix;
		this.qte = qte;
		this.commandes = commandes;
		this.produits = produits;
	}
	public Long getIdLigneCommande() {
		return idLigneCommande;
	}
	public void setIdLigneCommande(Long idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public Commandes getCommandes() {
		return commandes;
	}
	public void setCommandes(Commandes commandes) {
		this.commandes = commandes;
	}
	public Produits getProduits() {
		return produits;
	}
	public void setProduits(Produits produits) {
		this.produits = produits;
	}
	

	
}

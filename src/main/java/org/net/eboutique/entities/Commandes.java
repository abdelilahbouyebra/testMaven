package org.net.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commandes implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCommande;
	private Date DateCommande;
	@ManyToOne
	@JoinColumn(name="idClient")
	private Clients clients;
	@OneToMany(mappedBy="commandes")
    private Collection<LigneCommandes> items;
	public Commandes() {
		super();
	}
	public Long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	public Date getDateCommande() {
		return DateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		DateCommande = dateCommande;
	}
	public Clients getClients() {
		return clients;
	}
	public void setClients(Clients clients) {
		this.clients = clients;
	}
	public Collection<LigneCommandes> getItems() {
		return items;
	}
	public void setItems(Collection<LigneCommandes> ligneCommandes) {
		this.items = ligneCommandes;
	}
    
	
}

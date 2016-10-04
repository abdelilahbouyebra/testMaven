package org.net.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Clients  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClient;
	private String nomClient;
	private String Adreese;
	private String telephone;
	private String email;
	@OneToMany(mappedBy="clients")
	private Collection<Commandes> collection;
	public Clients() {
		super();
	}
	public Clients(String nomClient, String adreese, String telephone,
			String email) {
		super();
		this.nomClient = nomClient;
		Adreese = adreese;
		this.telephone = telephone;
		this.email = email;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getAdreese() {
		return Adreese;
	}
	public void setAdreese(String adreese) {
		Adreese = adreese;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Collection<Commandes> getCollection() {
		return collection;
	}
	public void setCollection(Collection<Commandes> collection) {
		this.collection = collection;
	}
	

}

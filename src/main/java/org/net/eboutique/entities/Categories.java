package org.net.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Categories implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategorie;
	@NotEmpty
	@Size(max=15,min=2)
	private String nomCategorie;
	private String nomPhoto;
	private  String description;
	@Lob
	private byte[] photo;
	@OneToMany(mappedBy="categories")
	private Collection<Produits> produits;
	
	public Categories() {
		super();
	}
	
	public Categories(String nomCategorie, String nomPhoto, String description,
			byte[] photo) {
		super();
		this.nomCategorie = nomCategorie;
		this.nomPhoto = nomPhoto;
		this.description = description;
		this.photo = photo;
	}

	public Long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public String getNomPhoto() {
		return nomPhoto;
	}
	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Collection<Produits> getProduits() {
		return produits;
	}

	public void setProduits(Collection<Produits> produits) {
		this.produits = produits;
	}
	
	
}

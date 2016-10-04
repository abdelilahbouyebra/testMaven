package org.net.eboutique.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Produits implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit;
	@NotEmpty
	@Size(max=15,min=2)
	private String designation;
	private String description;
	private Double prix;
	private int qte;
	private Boolean selectionner;
	private String photo;
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categories categories;
	public Produits() {
		super();
	}
	public Produits(String designation, String description, Double prix,
			int qte, Boolean selectionner, String photo) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.qte = qte;
		this.selectionner = selectionner;
		this.photo = photo;
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public Boolean getSelectionner() {
		return selectionner;
	}
	public void setSelectionner(Boolean selectionner) {
		this.selectionner = selectionner;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Categories getCategories() {
		return categories;
	}
	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	
	

}

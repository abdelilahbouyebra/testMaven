package org.net.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Users implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser;
	private String nomUser;
	private String passwordUser;
	private Boolean actived;
	@OneToMany
	@JoinColumn(name="id_user")
	private Collection<Roles> roles;
	public Users() {
		super();
	}
	public Users(String nomUser, String passwordUser, Boolean actived) {
		super();
		this.nomUser = nomUser;
		this.passwordUser = passwordUser;
		this.actived = actived;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getNomUser() {
		return nomUser;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	public String getPasswordUser() {
		return passwordUser;
	}
	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}
	public Boolean getActived() {
		return actived;
	}
	public void setActived(Boolean actived) {
		this.actived = actived;
	}
	public Collection<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}
	
	
}

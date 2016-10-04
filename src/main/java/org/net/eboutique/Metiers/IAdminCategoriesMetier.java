package org.net.eboutique.Metiers;

import org.net.eboutique.entities.Categories;
import org.net.eboutique.entities.Roles;
import org.net.eboutique.entities.Users;

public interface IAdminCategoriesMetier  extends IAdminProduitsMetier{

	public Long ajouterCategorie(Categories c);
	public void supprimerCategrorie(Long idcat);
	public void modifierCategorie(Categories c);
	public void ajouterUser(Users u);
	public void attribuerRole(Roles r,Long userID);
}

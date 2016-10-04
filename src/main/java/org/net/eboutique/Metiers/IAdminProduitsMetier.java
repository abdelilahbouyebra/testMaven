package org.net.eboutique.Metiers;

import org.net.eboutique.entities.Produits;

public interface IAdminProduitsMetier extends IinternauteMetier {
	public Long ajouterProduit(Produits p, Long idCat);
	public void supprimerProduit(Long idP);
	public void modifierProduit(Produits p);

}

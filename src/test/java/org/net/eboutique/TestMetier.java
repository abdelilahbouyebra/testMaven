package org.net.eboutique;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.net.eboutique.Metiers.EboutiqueMetierImpl;
import org.net.eboutique.Metiers.IAdminCategoriesMetier;
import org.net.eboutique.Metiers.IAdminProduitsMetier;
import org.net.eboutique.entities.Categories;
import org.net.eboutique.entities.Produits;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMetier {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		try {
			ClassPathXmlApplicationContext context=
			new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			IAdminProduitsMetier metier=(IAdminProduitsMetier) context.getBean("metier");
			IAdminCategoriesMetier mCat=(IAdminCategoriesMetier) context.getBean("metier");
			List<Categories> listCat=mCat.listCategories();
			mCat.ajouterCategorie(new Categories("Ordinateur", "ordinateur.gjp", "ordinateursordinateurs", null));
			List<Categories> listCat2=mCat.listCategories();
			  assertTrue(listCat.size()+1==listCat2.size());
			} catch (Exception e) {
			assertTrue(e.getMessage(),false);
			}
	}

}

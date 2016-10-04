package org.net.eboutique.Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.net.eboutique.Metiers.IAdminProduitsMetier;
import org.net.eboutique.entities.Produits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/AdminProd")
public class AdminProduitContoller implements HandlerExceptionResolver{

	@Autowired
	private IAdminProduitsMetier metier;

	@RequestMapping(value = "/index")
	public String index(Model model, @ModelAttribute("produit") Produits produit) {
		model.addAttribute("produits", metier.listproduits());
		model.addAttribute("categories", metier.listCategories());
		return "produits";
	}

	@RequestMapping(value = "/saveProd")
	public String saveProd(@Valid @ModelAttribute("produit") Produits produit,
			BindingResult bind, MultipartFile file, Model model)
			throws IOException {
		if (bind.hasErrors()) {
			model.addAttribute("produits", metier.listproduits());
			model.addAttribute("categories", metier.listCategories());
			return "produits";
		}

		if (!file.isEmpty()) {
			String path = System.getProperty("java.io.tmpdir");
			produit.setPhoto(file.getOriginalFilename());
			Long idProd = metier.ajouterProduit(produit, produit.getCategories().getIdCategorie());
			file.transferTo(new File(path + "/" + "PROD_" + idProd+"_"+file.getOriginalFilename()));
		}else{
			metier.ajouterProduit(produit, produit.getCategories().getIdCategorie());
		}
		model.addAttribute("produit", new Produits());
		model.addAttribute("produits", metier.listproduits());
		model.addAttribute("categories", metier.listCategories());
		return "produits";

	}
	@RequestMapping(value = "photoProd", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoProd(Long idP) throws IOException {
        Produits produit=metier.getProduit(idP);
        File file=new File(System.getProperty("java.io.tmpdir")+ "/PROD_" + idP+"_"+produit.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(file));

	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("produit",new Produits());
		mv.addObject("exception", ex.getMessage());
		mv.addObject("produits", metier.listproduits());
		mv.addObject("categories", metier.listCategories());
		mv.setViewName("produits");
		return mv;
	}

}

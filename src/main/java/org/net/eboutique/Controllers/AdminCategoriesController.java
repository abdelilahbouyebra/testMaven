package org.net.eboutique.Controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.net.eboutique.Metiers.IAdminCategoriesMetier;
import org.net.eboutique.entities.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/AdminCat")
public class AdminCategoriesController implements HandlerExceptionResolver {

	private IAdminCategoriesMetier metier;

	@Autowired
	public void setMetier(IAdminCategoriesMetier metier) {
		this.metier = metier;
	}

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("categorie", new Categories());
		model.addAttribute("categories", metier.listCategories());
		return "categories";
	}

	@RequestMapping(value = "/saveCat", method = RequestMethod.POST)
	public String saveCat(@Valid @ModelAttribute("categorie") Categories categorie,BindingResult bindingResult, MultipartFile file, Model model)
			throws Exception {

		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", metier.listCategories());
			return "categories";
		}
		if (!file.isEmpty()) {
			BufferedImage bi = ImageIO.read(file.getInputStream());
			categorie.setPhoto(file.getBytes());
			categorie.setNomPhoto(file.getOriginalFilename());
		}
		if (categorie.getIdCategorie() != null) {
			if (file.isEmpty()) {
				Categories cat = metier.getCategorie(categorie.getIdCategorie());
				categorie.setNomPhoto(cat.getNomPhoto());
				categorie.setPhoto(cat.getPhoto());
			}
			metier.modifierCategorie(categorie);
		} else {

			metier.ajouterCategorie(categorie);
			model.addAttribute("categorie", new Categories());
		}

		model.addAttribute("categories", metier.listCategories());
		return "categories";
	}

	@RequestMapping(value = "photoCat", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCat(Long idCat) throws IOException {

		Categories c = metier.getCategorie(idCat);
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));

	}

	@RequestMapping(value = "/suppCat")
	public String suppCat(Long idCat, Model model,@ModelAttribute("categorie") Categories categorie) {
		metier.supprimerCategrorie(idCat);
		model.addAttribute("categories", metier.listCategories());
		return "categories";
	}

	@RequestMapping(value = "/editeCat")
	public String editeCat(Long idCat, Model model,@ModelAttribute("categorie") Categories categorie) {
		Categories cat = metier.getCategorie(idCat);
		model.addAttribute("categories", metier.listCategories());
		model.addAttribute("categorie", cat);
		return "categories";
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("categorie",new Categories());
		mv.addObject("exception", ex.getMessage());
		mv.addObject("categories", metier.listCategories());
		mv.setViewName("categories");
		return mv;
	}
}

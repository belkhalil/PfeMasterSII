package com.empsi.controllers.rest.classes;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.classes.AnneeScolaire;
import com.empsi.services.classes.IAnneeScolaireMetier;

@RestController
@RequestMapping("/classes")
public class AnneeScolaireRestController {

	@Autowired
	private IAnneeScolaireMetier anneeScolaireService;
	
	@RequestMapping(value = "annees", method = RequestMethod.GET)
	public  List<AnneeScolaire> getClasses( HttpSession session){
		
				List<AnneeScolaire> annees = anneeScolaireService.getAll();
				if (!annees.isEmpty()) {
					return annees;
				}
				return null;		
	}
	@RequestMapping(value = "getAnnee/{id}", method = RequestMethod.GET)
	public AnneeScolaire getAnnee(@PathVariable Long id , HttpSession session){
		AnneeScolaire annee = anneeScolaireService.get(id);		
		return annee;	
			
	}
	
	
}

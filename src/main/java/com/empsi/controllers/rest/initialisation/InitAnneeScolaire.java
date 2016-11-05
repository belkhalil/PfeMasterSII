package com.empsi.controllers.rest.initialisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.classes.AnneeScolaire;
import com.empsi.entities.rights.Group;
import com.empsi.services.classes.IAnneeScolaireMetier;

//http://localhost:8080/init_annee_scolaire/init
@RestController
@RequestMapping("/init_annee_scolaire")
public class InitAnneeScolaire {
	
	@Autowired
	private IAnneeScolaireMetier anneeScolaireService ;
	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public ResponseEntity<String> init(){
		
		AnneeScolaire anneeScolaire =new AnneeScolaire();
		anneeScolaire.setAnneeDebut("2012");
		anneeScolaire.setAnneeFin("2013");
		anneeScolaireService.save(anneeScolaire);
		
		AnneeScolaire anneeScolaire2 =new AnneeScolaire();
		anneeScolaire2.setAnneeDebut("2013");
		anneeScolaire2.setAnneeFin("2014");
		anneeScolaireService.save(anneeScolaire2);
		
		AnneeScolaire anneeScolaire3 =new AnneeScolaire();
		anneeScolaire3.setAnneeDebut("2014");
		anneeScolaire3.setAnneeFin("2015");
		anneeScolaireService.save(anneeScolaire3);
		
		AnneeScolaire anneeScolaire4 =new AnneeScolaire();
		anneeScolaire4.setAnneeDebut("2015");
		anneeScolaire4.setAnneeFin("2016");
		anneeScolaireService.save(anneeScolaire4);
		
		AnneeScolaire anneeScolaire5 =new AnneeScolaire();
		anneeScolaire5.setAnneeDebut("2016");
		anneeScolaire5.setAnneeFin("2017");
		anneeScolaireService.save(anneeScolaire5);
		 
		return new ResponseEntity<String>("init Annee Scolaire ok",HttpStatus.OK);
	}
	
}

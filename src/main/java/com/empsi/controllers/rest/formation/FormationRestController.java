package com.empsi.controllers.rest.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.formation.Formation;
import com.empsi.managers.formation.IFormationMetier;

@RestController
public class FormationRestController {

	@Autowired
	private IFormationMetier formRepos;
	
	@RequestMapping(value = "/getOneFormation/{id}", method = RequestMethod.GET)
	public Formation getForm(@PathVariable("id") Long id) {
		if (formRepos.get(id) == null)
			return null;
		else
			return formRepos.get(id);
	}
	
	@RequestMapping(value = "/loadForm/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Formation> loadForm( @PathVariable Long id){
		Formation f = null;
		try{	
		System.out.println("IdForm=>"+ formRepos.get(id).getIdFormation());
		f = formRepos.get(id);
			return  new ResponseEntity<Formation>(f , HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Formation>( HttpStatus.CONFLICT);
		}	
	}
}

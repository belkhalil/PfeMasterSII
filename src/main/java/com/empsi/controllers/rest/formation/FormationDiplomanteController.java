package com.empsi.controllers.rest.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.empsi.entities.formation.FormationDiplomante;
import com.empsi.managers.formation.FormationDiplomanteImpl;

@RestController
@RequestMapping("/formation")
public class FormationDiplomanteController  {
   @Autowired
	FormationDiplomanteImpl formationDiplomanteImpl;
   
   @RequestMapping(value = "/saveformationD", method = RequestMethod.POST)
	public ResponseEntity<FormationDiplomante> addformation(@RequestBody FormationDiplomante f) {
		formationDiplomanteImpl.save(f);
		return new ResponseEntity<FormationDiplomante>(f,HttpStatus.CREATED);
	}
 
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getOneFormationD/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FormationDiplomante> getFormation(@PathVariable("id") Long id) {
		FormationDiplomante f =formationDiplomanteImpl.get(id);
		if (f== null)
		{
			return new ResponseEntity<FormationDiplomante>(HttpStatus.NOT_FOUND);
		}	
		return new ResponseEntity<FormationDiplomante>(f, HttpStatus.OK);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/formationsD", method = RequestMethod.GET)
	public ResponseEntity<List<FormationDiplomante>> getAllformations() {
		List<FormationDiplomante> formationDiplomantes =formationDiplomanteImpl.getAll();
		if(formationDiplomantes.isEmpty())
		{
			return new ResponseEntity<List<FormationDiplomante>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FormationDiplomante>>(formationDiplomantes, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteformationD/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<FormationDiplomante> deleteFormation(@PathVariable("id") Long id) {
		FormationDiplomante f=formationDiplomanteImpl.get(id);
		if(f==null)
		{
			return new ResponseEntity<FormationDiplomante>(HttpStatus.NOT_FOUND);
		}
		formationDiplomanteImpl.delete(id);
		return new ResponseEntity<FormationDiplomante>(HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @param e
	 * @return
	 */
	@RequestMapping(value = "/updateFormationD/{id}", method = RequestMethod.PUT)
	public ResponseEntity<FormationDiplomante> updateFormation(@PathVariable("id") Long id, @RequestBody FormationDiplomante e) {
		formationDiplomanteImpl.update(e);
		return new ResponseEntity<FormationDiplomante>(HttpStatus.OK);
	}

	/**
	 * 
	 * @param idT
	 * @param idF
	 * @return
	 */
	@RequestMapping(value="/addTypeToFormation/" ,method = RequestMethod.POST)
	public ResponseEntity<FormationDiplomante> addTypeToFormation(@RequestParam(value="idt") Long idT ,@RequestParam(value="idf") Long idF)
	{
		 formationDiplomanteImpl.addTypeToFormation(idT, idF);
		return new ResponseEntity<FormationDiplomante>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateTypeOfFormation/" ,method = RequestMethod.POST)
	public ResponseEntity<FormationDiplomante> updateTypeOfFormation(@RequestParam(value="idoldt") Long idoldT,@RequestParam(value="idnewt") Long idnewT ,@RequestParam(value="idf") Long idF)
	{
		 formationDiplomanteImpl.updateTypeOfFormation(idoldT, idnewT, idF);
		return new ResponseEntity<FormationDiplomante>(HttpStatus.OK);
	}
	
	
	
}

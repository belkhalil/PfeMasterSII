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
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.formation.Formation;
import com.empsi.entities.formation.TypeFormaton;
import com.empsi.managers.formation.TypeFormationMetierImpl;

@RestController
@RequestMapping("/formation")
public class TypeFormationController {
	@Autowired
	TypeFormationMetierImpl typeFormationMetierImpl;



	@RequestMapping(value = "/savetypeFormation", method = RequestMethod.POST)
	public ResponseEntity<TypeFormaton> addtypeformation(@RequestBody TypeFormaton t) {
		typeFormationMetierImpl.save(t);
		return new ResponseEntity<TypeFormaton>(t, HttpStatus.CREATED);

	}

	/**
	 * 
	 * @param id
	 * @return
	 */

	@RequestMapping(value = "/getOneTypeFormation/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TypeFormaton> getTypeformation(@PathVariable("id") Long id) {
		TypeFormaton t = typeFormationMetierImpl.get(id);
		if (t == null) {
			return new ResponseEntity<TypeFormaton>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TypeFormaton>(t, HttpStatus.OK);

	}

	/**
	 * 
	 * @return
	 */

	@RequestMapping(value = "/typeFormations", method = RequestMethod.GET)
	public ResponseEntity<List<TypeFormaton>> getAlltypesF() {
		List<TypeFormaton> typeFormatons = typeFormationMetierImpl.getAll();
		if (typeFormatons.isEmpty()) {
			return new ResponseEntity<List<TypeFormaton>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TypeFormaton>>(typeFormatons, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */

	

	@RequestMapping(value="/formationsByType/{id}",method = RequestMethod.GET)
	public List<Formation> getFormations(@PathVariable("id") Long id)
	{	
		TypeFormaton type = typeFormationMetierImpl.get(id);
		List<Formation> lists = type.getFormations();
		return lists;
		
	}
	@RequestMapping(value = "/deleteTypeFormation/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TypeFormaton> deletetypeF(@PathVariable("id") Long id) {
		TypeFormaton t = typeFormationMetierImpl.get(id);
		if (t == null) {
			return new ResponseEntity<TypeFormaton>(HttpStatus.NOT_FOUND);
		}
		typeFormationMetierImpl.delete(id);
		return new ResponseEntity<TypeFormaton>(HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @param n
	 * @return
	 */
	@RequestMapping(value = "/updateTypeFormation/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TypeFormaton> updatetypeFormation(@PathVariable("id") Long id, @RequestBody TypeFormaton t) {
		typeFormationMetierImpl.update(t);
		return new ResponseEntity<TypeFormaton>(HttpStatus.OK);

	}
}

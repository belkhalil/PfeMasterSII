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

import com.empsi.entities.formation.FormationContinu;
import com.empsi.managers.formation.FormationContinueMetierImpl;

@RestController
@RequestMapping("/formation")
public class FormationContinueController {

	@Autowired
	private FormationContinueMetierImpl formationContinueMetierImpl;

	@RequestMapping(value = "/saveformation", method = RequestMethod.POST)
	public ResponseEntity<FormationContinu> addformation(@RequestBody FormationContinu f) {
		formationContinueMetierImpl.save(f);
		return new ResponseEntity<FormationContinu>(f, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getOneFormation/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FormationContinu> getFormation(@PathVariable("id") Long id) {
		FormationContinu f = formationContinueMetierImpl.get(id);
		if (f == null) {
			return new ResponseEntity<FormationContinu>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FormationContinu>(f, HttpStatus.OK);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/formations", method = RequestMethod.GET)
	public ResponseEntity<List<FormationContinu>> getAllformations() {
		List<FormationContinu> formationContinus = formationContinueMetierImpl.getAll();
		if (formationContinus.isEmpty()) {
			return new ResponseEntity<List<FormationContinu>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FormationContinu>>(formationContinus, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteformation/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<FormationContinu> deleteFormation(@PathVariable("id") Long id) {
		FormationContinu f = formationContinueMetierImpl.get(id);
		if (f == null) {
			return new ResponseEntity<FormationContinu>(HttpStatus.NOT_FOUND);
		}
		formationContinueMetierImpl.delete(id);
		return new ResponseEntity<FormationContinu>(HttpStatus.NOT_FOUND);
	}

	/**
	 * 
	 * @param id
	 * @param e
	 * @return
	 */
	@RequestMapping(value = "/updateFormation/{id}", method = RequestMethod.PUT)
	public ResponseEntity<FormationContinu> updateFormation(@PathVariable("id") Long id,
			@RequestBody FormationContinu e) {
		formationContinueMetierImpl.update(e);
		return new ResponseEntity<FormationContinu>(HttpStatus.OK);
	}

}

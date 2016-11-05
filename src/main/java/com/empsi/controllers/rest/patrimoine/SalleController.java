package com.empsi.controllers.rest.patrimoine;

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


import com.empsi.entities.patrimoine.Salle;
import com.empsi.managers.patrimoine.SalleMetierImpl;

@RestController
@RequestMapping("/patrimoine")
public class SalleController {

	@Autowired
	SalleMetierImpl salleMetierImpl;

	
	/**
	 * 
	 * @param s
	 * @return
	 */
	@RequestMapping(value = "/saveSalle", method = RequestMethod.POST)
	public ResponseEntity<Salle> addSalle(@RequestBody Salle s) {
		salleMetierImpl.save(s);
		return new ResponseEntity<Salle>(s, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getOneSalle/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Salle> getSalle(@PathVariable("id") Long id) {
		Salle salle = salleMetierImpl.get(id);
		if (salle == null) {
			return new ResponseEntity<Salle>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Salle>(salle, HttpStatus.OK);

	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/salles", method = RequestMethod.GET)
	public ResponseEntity<List<Salle>> getAllSalles() {
		List<Salle> salles = salleMetierImpl.getAll();
		if (salles.isEmpty()) {
			return new ResponseEntity<List<Salle>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Salle>>(salles, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteSalle/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Salle> deleteSalle(@PathVariable("id") Long id) {
		Salle salle = salleMetierImpl.get(id);
		if (salle == null) {
			return new ResponseEntity<Salle>(HttpStatus.NOT_FOUND);
		}
		salleMetierImpl.delete(id);
		return new ResponseEntity<Salle>(HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @param n
	 * @return
	 */
	@RequestMapping(value = "/updateSalle/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Salle> updateSalle(@PathVariable("id") Long id, @RequestBody Salle m) {
		salleMetierImpl.Update(m);
		return new ResponseEntity<Salle>(HttpStatus.OK);
	}
	
}

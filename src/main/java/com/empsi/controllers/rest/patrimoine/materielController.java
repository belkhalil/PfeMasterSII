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

import com.empsi.entities.patrimoine.Materiel;
import com.empsi.managers.patrimoine.MaterielMetierImpl;

@RestController
@RequestMapping("/patrimoine")
public class materielController {

	@Autowired
	MaterielMetierImpl materielMetierImpl;

	/**
	 * 
	 * @param s
	 * @return
	 */
	@RequestMapping(value = "/saveMateriel", method = RequestMethod.POST)
	public ResponseEntity<Materiel> addMateriel(@RequestBody Materiel m) {
		materielMetierImpl.save(m);
		return new ResponseEntity<Materiel>(m, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getOneMateriel/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Materiel> getMateriel(@PathVariable("id") Long id) {
		Materiel materiel = materielMetierImpl.get(id);
		if (materiel == null) {
			return new ResponseEntity<Materiel>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Materiel>(materiel, HttpStatus.OK);

	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/materiels", method = RequestMethod.GET)
	public ResponseEntity<List<Materiel>> getAllMateriels() {
		List<Materiel> materiels = materielMetierImpl.getAll();
		if (materiels.isEmpty()) {
			return new ResponseEntity<List<Materiel>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Materiel>>(materiels, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteMateriel/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Materiel> deleteMateriel(@PathVariable("id") Long id) {
		Materiel materiel = materielMetierImpl.get(id);
		if (materiel == null) {
			return new ResponseEntity<Materiel>(HttpStatus.NOT_FOUND);
		}
		materielMetierImpl.delete(id);
		return new ResponseEntity<Materiel>(HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @param n
	 * @return
	 */
	@RequestMapping(value = "/updateMateriel/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Materiel> updateMateriel(@PathVariable("id") Long id, @RequestBody Materiel m) {
		materielMetierImpl.Update(m);
		return new ResponseEntity<Materiel>(HttpStatus.OK);
	}

}

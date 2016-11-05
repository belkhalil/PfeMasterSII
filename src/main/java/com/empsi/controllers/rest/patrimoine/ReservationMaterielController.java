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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.patrimoine.ReservationMateriel;

import com.empsi.managers.patrimoine.ReservationMaterielMetierImpl;
import com.empsi.managers.patrimoine.ReservationSalleMetierImpl;

@RestController
@RequestMapping("/ReservationMateriel")
public class ReservationMaterielController {

	@Autowired
	ReservationMaterielMetierImpl reservationMaterielMetierImpl;

	/**
	 * 
	 * @param s
	 * @return
	 */
	@RequestMapping(value = "/saveReservationMateriel", method = RequestMethod.POST)
	public ResponseEntity<ReservationMateriel> addReservationMateriel(
			@RequestBody ReservationMateriel reservationMateriel) {

		reservationMaterielMetierImpl.save(reservationMateriel);
		return new ResponseEntity<ReservationMateriel>(reservationMateriel, HttpStatus.CREATED);
	}

	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getOneReservationMateriel/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReservationMateriel> getReservationMateriel(@PathVariable("id") Long id) {
		ReservationMateriel reservationMateriel = reservationMaterielMetierImpl.get(id);
		if (reservationMateriel == null) {
			return new ResponseEntity<ReservationMateriel>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ReservationMateriel>(reservationMateriel, HttpStatus.OK);
	}
	
	

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/reservationMateriels", method = RequestMethod.GET)
	public ResponseEntity<List<ReservationMateriel>> getAllReservationMateriels() {
		List<ReservationMateriel> reservationMateriels = reservationMaterielMetierImpl.getAll();
		if (reservationMateriels.isEmpty()) {
			return new ResponseEntity<List<ReservationMateriel>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ReservationMateriel>>(reservationMateriels, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteReservationMateriel/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ReservationMateriel> deleteReservationMateriel(@PathVariable("id") Long id) {
		ReservationMateriel reservationMateriel = reservationMaterielMetierImpl.get(id);
		if (reservationMateriel == null) {
			return new ResponseEntity<ReservationMateriel>(HttpStatus.NOT_FOUND);
		}
		reservationMaterielMetierImpl.delete(id);
		return new ResponseEntity<ReservationMateriel>(HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @param reservationMateriel
	 * @return
	 */
	@RequestMapping(value = "/updateReservationMateriel/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ReservationMateriel> updateReservationMateriel(@PathVariable("id") Long id,
			@RequestBody ReservationMateriel reservationMateriel) {
		reservationMaterielMetierImpl.Update(reservationMateriel);
		return new ResponseEntity<ReservationMateriel>(HttpStatus.OK);
	}

	/**
	 * 
	 * @param idM
	 * @param idR
	 * @return
	 */
	@RequestMapping(value = "/addMaterielToReservation", method = RequestMethod.POST)
	public ResponseEntity<ReservationMateriel> addFormationToNiveau(@RequestParam(value = "idm") Long idM,
			@RequestParam(value = "idr") Long idR) {
		reservationMaterielMetierImpl.addMaterielToReservation(idM, idR);
		return new ResponseEntity<ReservationMateriel>(HttpStatus.OK);

	}

	
	@RequestMapping(value = "/addUserToReservation", method = RequestMethod.POST)
	public ResponseEntity<ReservationMateriel> addUserToReservation(@RequestParam(value = "idu") Long idU,
			@RequestParam(value = "idr") Long idR) {
		reservationMaterielMetierImpl.addUserToReservation(idU, idR);
		return new ResponseEntity<ReservationMateriel>(HttpStatus.OK);

	}
	 

}

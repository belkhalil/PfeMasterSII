package com.empsi.controllers.rest.inscription;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.rights.User;
import com.empsi.entities.users.Etudiant;
import com.empsi.managers.rights.GroupManager;
import com.empsi.services.formation.IEtudiantMetier;

@RestController
public class GestionInscriptionRest {

	@Autowired
	private IEtudiantMetier etudiantMetier;

	@Autowired
	private GroupManager groupService;

	@RequestMapping(value = "etudiants", method = RequestMethod.GET)
	public List<Etudiant> listerEtudiant(HttpSession session) {
		List<Etudiant> etudiants = null;
		try {
			etudiants = etudiantMetier.getAll();
		} catch (Exception e) {
			return null;
		}
		return etudiants;
	}

	@RequestMapping(value = "supprimerCompte/{id}", method = RequestMethod.GET)
	public ResponseEntity<Void> suppression(@PathVariable Long id, HttpSession session) {

		try {
			if ((etudiantMetier.delete(id))) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else
				return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

	@RequestMapping(value = "validerCompte/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> valider(@PathVariable Long id, HttpSession session) {
		try {

			Etudiant etudiant = etudiantMetier.get(id);
			etudiant.setEtatCompte(true);
			etudiantMetier.Update(etudiant);
			groupService.addUserToEtudiant(etudiant.getId());
			return new ResponseEntity<User>(etudiant, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}

	}

	@RequestMapping(value = "rejeterCompte/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> desactiver(@PathVariable Long id, HttpSession session) {
		try {
			Etudiant etudiant = etudiantMetier.get(id);
			etudiant.setEtatCompte(false);
			etudiantMetier.Update(etudiant);
			return new ResponseEntity<User>(etudiant, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}

	}

}

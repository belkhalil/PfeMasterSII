package com.empsi.managers.patrimoine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.formation.EtudiantRepository;
import com.empsi.dao.patrimoine.MaterielRepository;
import com.empsi.dao.patrimoine.ReservationMaterielRepository;
import com.empsi.entities.patrimoine.Materiel;
import com.empsi.entities.patrimoine.ReservationMateriel;
import com.empsi.entities.patrimoine.ReservationSalle;
import com.empsi.entities.users.Etudiant;
import com.empsi.services.patrimoine.IReservationMaterielMetier;

@Service
public class ReservationMaterielMetierImpl implements IReservationMaterielMetier {

	@Autowired
	ReservationMaterielRepository reservationMaterielRepository;
	@Autowired
	MaterielRepository materielRepository;
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Override
	public ReservationMateriel save(ReservationMateriel reservationMateriel) {
		reservationMaterielRepository.save(reservationMateriel);
		return reservationMateriel;
	}

	@Override
	public ReservationMateriel get(Long id) {
		ReservationMateriel reservationMateriel= reservationMaterielRepository.findOne(id);
		return reservationMateriel;  
	}

	@Override
	public ReservationMateriel Update(ReservationMateriel reservationMateriel) {
	    reservationMaterielRepository.saveAndFlush(reservationMateriel);
		return reservationMateriel;
	}

	@Override
	public List<ReservationMateriel> getAll() {
		List<ReservationMateriel> reservationMateriels =reservationMaterielRepository.findAll();
		return reservationMateriels;
	}

	@Override
	public Boolean delete(Long id) {
		reservationMaterielRepository.delete(id);
		return true;
	}

	@Override
	public Boolean addMaterielToReservation(Long idMateriel, Long idReservation) {
		ReservationMateriel reservationMateriel=reservationMaterielRepository.findOne(idReservation);
		Materiel materiel= materielRepository.findOne(idMateriel);
		reservationMateriel.setMateriel(materiel);
		
		reservationMaterielRepository.saveAndFlush(reservationMateriel);
		materielRepository.saveAndFlush(materiel);
		return true;
	}

	@Override
	public Boolean addUserToReservation(Long idUser, Long idReservation) {
		Etudiant etudiant = etudiantRepository.findOne(idUser);
		ReservationMateriel reservationMateriel = reservationMaterielRepository.findOne(idReservation);
		
		reservationMateriel.setUtilisateur(etudiant);
		reservationMaterielRepository.saveAndFlush(reservationMateriel);
		etudiantRepository.saveAndFlush(etudiant);
		return true;
	}

}

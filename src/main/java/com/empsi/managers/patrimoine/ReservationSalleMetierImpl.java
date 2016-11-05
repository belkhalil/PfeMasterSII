package com.empsi.managers.patrimoine;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.empsi.dao.formation.EtudiantRepository;
import com.empsi.dao.patrimoine.ReservationSalleRepository;
import com.empsi.dao.patrimoine.SalleRepository;
import com.empsi.entities.patrimoine.ReservationSalle;
import com.empsi.entities.patrimoine.Salle;
import com.empsi.entities.users.Etudiant;
import com.empsi.services.patrimoine.IReservationSalleMetier;

@Service
public class ReservationSalleMetierImpl implements IReservationSalleMetier {

	@Autowired
	ReservationSalleRepository reservationSalleRepository;
	
	@Autowired
	SalleRepository salleRepository;
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Override
	public ReservationSalle save(ReservationSalle reservationSalle) {
		reservationSalleRepository.save(reservationSalle);
		return reservationSalle;
	}

	@Override
	public ReservationSalle get(Long id) {
		ReservationSalle reservationSalle = reservationSalleRepository.findOne(id);
		return reservationSalle;
	}

	@Override
	public ReservationSalle Update(ReservationSalle reservationSalle) {
		
		reservationSalleRepository.saveAndFlush(reservationSalle);
		return reservationSalle;
	}

	@Override
	public List<ReservationSalle> getAll() {
		List<ReservationSalle> reservationSalles = reservationSalleRepository.findAll();
		return reservationSalles;
	}
	
	
	@Override
	public Boolean delete(Long id) {
		reservationSalleRepository.delete(id);
		return true;
	}

	@Override
	public Boolean addSalleToReservation(Long idSalle, Long idReservation) {
        
	Salle s= salleRepository.getOne(idSalle);
	ReservationSalle reservation = reservationSalleRepository.getOne(idReservation);
	reservation.setSalle(s);
	s.setEtatSalle(false);
	s.setLabelEtat("en attente");
	reservationSalleRepository.saveAndFlush(reservation);
	salleRepository.saveAndFlush(s);
		return null;
	}

	@Override
	public Boolean addUserToReservation(Long idUser, Long idReservation) {
		Etudiant etudiant = etudiantRepository.findOne(idUser);
		ReservationSalle reservationSalle = reservationSalleRepository.findOne(idReservation);
		
		reservationSalle.setUtilisateur(etudiant);
		reservationSalleRepository.saveAndFlush(reservationSalle);
		etudiantRepository.saveAndFlush(etudiant);
		return true;
	}
	
	

}

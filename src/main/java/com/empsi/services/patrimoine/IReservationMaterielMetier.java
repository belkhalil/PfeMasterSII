package com.empsi.services.patrimoine;

import java.util.List;

import com.empsi.entities.patrimoine.ReservationMateriel;



public interface IReservationMaterielMetier{
	public ReservationMateriel save(ReservationMateriel reservationMateriel);
	public ReservationMateriel get(Long id);
	public ReservationMateriel Update(ReservationMateriel reservationMateriel );
	public List<ReservationMateriel> getAll();
	public Boolean delete(Long id);
	public Boolean addMaterielToReservation(Long idMateriel, Long idReservation);
	public Boolean addUserToReservation(Long idUser, Long idReservation);
}

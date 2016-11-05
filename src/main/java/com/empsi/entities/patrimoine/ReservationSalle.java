package com.empsi.entities.patrimoine;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.empsi.entities.patrimoine.Salle;
import com.empsi.entities.rights.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class ReservationSalle implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idResSalle;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "YYYY-MMM-dd")
	private Date dateRes;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "YYYY-MMM-dd")
	private Date debutRes;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "YYYY-MMM-dd")
	private Date finRes;
	
	private String heureDebut;
		
	private String heureFin;
	
	private  String DescReservation;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "idUtilisateur")
	private User utilisateur;
	
	
	@ManyToOne(fetch= FetchType.EAGER, cascade= CascadeType.REFRESH)
    @JoinColumn(name = "idSalle")
	private Salle salle;
	
	private String decision;
	public ReservationSalle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReservationSalle(Date dateRes, Date debutRes, Date finRes, String heureDebut, String heureFin,
			String descReservation, String decision) {
		super();
		this.dateRes = dateRes;
		this.debutRes = debutRes;
		this.finRes = finRes;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		DescReservation = descReservation;
		this.decision = decision;
	}
	public Long getIdResSalle() {
		return idResSalle;
	}
	public void setIdResSalle(Long idResSalle) {
		this.idResSalle = idResSalle;
	}
	public Date getDateRes() {
		return dateRes;
	}
	public void setDateRes(Date dateRes) {
		this.dateRes = dateRes;
	}
	public Date getDebutRes() {
		return debutRes;
	}
	public void setDebutRes(Date debutRes) {
		this.debutRes = debutRes;
	}
	public Date getFinRes() {
		return finRes;
	}
	public void setFinRes(Date finRes) {
		this.finRes = finRes;
	}
	public String getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}
	public String getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}
	public String getDescReservation() {
		return DescReservation;
	}
	public void setDescReservation(String descReservation) {
		DescReservation = descReservation;
	}
	public User getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	
	
}

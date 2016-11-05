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

import com.empsi.entities.patrimoine.Materiel;
import com.empsi.entities.rights.User;

@Entity
public class ReservationMateriel implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idResMateriel;
	
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
	
	private  String descReservation;
	@ManyToOne
    @JoinColumn(name = "idUtilisateur")
	private User utilisateur;
	
	@ManyToOne(fetch= FetchType.EAGER, cascade= CascadeType.REFRESH)
    @JoinColumn(name = "idMateriel")
	private Materiel materiel;
	
	private String decision;
	public ReservationMateriel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReservationMateriel(Date dateRes, Date debutRes, Date finRes, String heureDebut, String heureFin,
			String descReservation, String decision) {
		super();
		this.dateRes = dateRes;
		this.debutRes = debutRes;
		this.finRes = finRes;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.descReservation = descReservation;
		this.decision = decision;
	}
	public Long getIdResMateriel() {
		return idResMateriel;
	}
	public void setIdResMateriel(Long idResMateriel) {
		this.idResMateriel = idResMateriel;
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
		return descReservation;
	}
	public void setDescReservation(String descReservation) {
		this.descReservation = descReservation;
	}
	public User getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Materiel getMateriel() {
		return materiel;
	}
	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	
	
}

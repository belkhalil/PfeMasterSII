package com.empsi.entities.all;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.empsi.entities.formation.Enseignant;

@Entity
public class AbsenceEns  implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_absenceEns")
	private Long idAbsenceEns;
	
	private Date dateDebut;
	private Date dateFin;
	private int nbrJour;
	private Date heureDebut;
	private Date heureFin;
	private Date jourAbsence;
	private String description;
	@ManyToOne
    @JoinColumn(name = "idUtilisateur")
	private Enseignant enseignant;
	
	//Getters and Setters
	public Long getIdAbsenceEns() {
		return idAbsenceEns;
	}
	public void setIdAbsenceEns(Long idAbsenceEns) {
		this.idAbsenceEns = idAbsenceEns;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public int getNbrJour() {
		return nbrJour;
	}
	public void setNbrJour(int nbrJour) {
		this.nbrJour = nbrJour;
	}
	public Date getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}
	public Date getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}
	public Date getJourAbsence() {
		return jourAbsence;
	}
	public void setJourAbsence(Date jourAbsence) {
		this.jourAbsence = jourAbsence;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public AbsenceEns() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AbsenceEns(Date dateDebut, Date dateFin, int nbrJour, Date heureDebut, Date heureFin, Date jourAbsence,
			String description) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbrJour = nbrJour;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.jourAbsence = jourAbsence;
		this.description = description;
	}
	
	
}

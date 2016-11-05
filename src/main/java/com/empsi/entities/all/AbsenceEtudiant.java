package com.empsi.entities.all;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.empsi.entities.formation.Seance;
import com.empsi.entities.users.Etudiant;

@Entity
public class AbsenceEtudiant implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAbsence;
	private Date dateAbsence;
	private String commentaire;
	private boolean justification = false;
	
	@ManyToOne
    @JoinColumn(name = "idEtudiant")
	private Etudiant etudiant;
	@ManyToOne
    @JoinColumn(name = "idSeance")
	private Seance seance;
	public Long getIdAbsence() {
		return idAbsence;
	}
	public void setIdAbsence(Long idAbsence) {
		this.idAbsence = idAbsence;
	}
	public Date getDateAbsence() {
		return dateAbsence;
	}
	public void setDateAbsence(Date dateAbsence) {
		this.dateAbsence = dateAbsence;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public boolean isJustification() {
		return justification;
	}
	public void setJustification(boolean justification) {
		this.justification = justification;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Seance getSeance() {
		return seance;
	}
	public void setSeance(Seance seance) {
		this.seance = seance;
	}
	public AbsenceEtudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AbsenceEtudiant(Date dateAbsence, String commentaire, boolean justification) {
		super();
		this.dateAbsence = dateAbsence;
		this.commentaire = commentaire;
		this.justification = justification;
	}
	
	
}

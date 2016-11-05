package com.empsi.entities.formation;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.empsi.entities.patrimoine.Salle;
import com.empsi.entities.formation.Matiere;

@Entity
public class Seance implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSeance;
	private String Sommaire;
	private String Objet;
	private String descSeance;
	private Boolean presenceEns;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat (pattern="YYYY-MMM-dd")
	private Date dateSeance;
	
	private String heureDebut;
	private String heureFin;
	
	
	@ManyToOne
	@JoinColumn(name="idMatiere")
	private Matiere matiere;
	
	
	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Date getDateSeance() {
		return dateSeance;
	}

	public void setDateSeance(Date dateSeance) {
		this.dateSeance = dateSeance;
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

	@ManyToOne
	@JoinColumn(name="idSalle")
	private Salle salle;

	public Seance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seance(String sommaire, String objet, String descSeance, Boolean presenceEns) {
		super();
		Sommaire = sommaire;
		Objet = objet;
		this.descSeance = descSeance;
		this.presenceEns = presenceEns;
	}

	public Long getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(Long idSeance) {
		this.idSeance = idSeance;
	}

	public String getSommaire() {
		return Sommaire;
	}

	public void setSommaire(String sommaire) {
		Sommaire = sommaire;
	}

	public String getObjet() {
		return Objet;
	}

	public void setObjet(String objet) {
		Objet = objet;
	}

	public String getDescSeance() {
		return descSeance;
	}

	public void setDescSeance(String descSeance) {
		this.descSeance = descSeance;
	}

	public Boolean getPresenceEns() {
		return presenceEns;
	}

	public void setPresenceEns(Boolean presenceEns) {
		this.presenceEns = presenceEns;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	
	
}

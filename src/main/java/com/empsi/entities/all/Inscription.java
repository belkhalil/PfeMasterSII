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

import com.empsi.entities.formation.Formation;
import com.empsi.entities.users.Etudiant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Inscription implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idInscription")
	private Long idInsc;
	private String numeroInsc;
	private Date dateInsc;
	
	private String serieBac;
	private String anneeBac;
	private String dernierDiplome;
	private String anneeDiplome;
	private String lienDiplome;
	private String extension;
	private String lienCv;
	private String diponibilitè;  //jour ou soir ou le weekend
	@ManyToOne
    @JoinColumn(name = "idUtilisateur")
	private Etudiant etudiant;
	@ManyToOne
    @JoinColumn(name = "idFormatio")
	private Formation formation;
	public Long getIdInsc() {
		return idInsc;
	}
	public void setIdInsc(Long idInsc) {
		this.idInsc = idInsc;
	}
	public String getNumeroInsc() {
		return numeroInsc;
	}
	public void setNumeroInsc(String numeroInsc) {
		this.numeroInsc = numeroInsc;
	}
	public Date getDateInsc() {
		return dateInsc;
	}
	public void setDateInsc(Date dateInsc) {
		this.dateInsc = dateInsc;
	}
	public String getDiponibilitè() {
		return diponibilitè;
	}
	public void setDiponibilitè(String diponibilitè) {
		this.diponibilitè = diponibilitè;
	}
	
	public Etudiant getEtudiant() {
		return etudiant;
	}
	
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
	public Formation  getFormation() {
		return formation;
	}
	
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inscription(String numeroInsc, Date dateInsc, String diponibilitè) {
		super();
		this.numeroInsc = numeroInsc;
		this.dateInsc = dateInsc;
		this.diponibilitè = diponibilitè;
	}
	public String getSerieBac() {
		return serieBac;
	}
	public void setSerieBac(String serieBac) {
		this.serieBac = serieBac;
	}
	public String getAnneeBac() {
		return anneeBac;
	}
	public void setAnneeBac(String anneeBac) {
		this.anneeBac = anneeBac;
	}
	public String getDernierDiplome() {
		return dernierDiplome;
	}
	public void setDernierDiplome(String dernierDiplome) {
		this.dernierDiplome = dernierDiplome;
	}
	public String getAnneeDiplome() {
		return anneeDiplome;
	}
	public void setAnneeDiplome(String anneeDiplome) {
		this.anneeDiplome = anneeDiplome;
	}
	public String getLienDiplome() {
		return lienDiplome;
	}
	public void setLienDiplome(String lienDiplome) {
		this.lienDiplome = lienDiplome;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getLienCv() {
		return lienCv;
	}
	public void setLienCv(String lienCv) {
		this.lienCv = lienCv;
	}
	
	
}

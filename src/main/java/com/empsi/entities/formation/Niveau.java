package com.empsi.entities.formation;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Niveau implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNiveau;
	// bac+1,bac+2...
	private String nomNiveau;
	// deug,licence,master
	private String labelNiveau;
	private double prix;

	// @OneToMany(targetEntity=Semestre.class)
	// private List<Semestre> semestres;

	// @ManyToMany()
	// @JoinTable(name = "Niveau_formation", joinColumns = {
	// @JoinColumn(name = "idNiveau", updatable = false) }, inverseJoinColumns =
	// {
	// @JoinColumn(name = "idFormation", updatable = false) })

	// @ManyToMany(targetEntity=Formation.class)
	// private List<Formation> formations;

	// @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @JoinTable(name = "niveau_semestres", joinColumns = {
	// @JoinColumn(name = "idNiveau", nullable = false, updatable = false) },
	// inverseJoinColumns = { @JoinColumn(name = "idSemestre",
	// nullable = false, updatable = false) })
	// private List<Semestre> semestres;

	@JsonIgnore
	@OneToMany()
	private List<Semestre> semestres;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "formation_Niveau", joinColumns = {
			@JoinColumn(name = "idNiveau", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "idFormation", nullable = false, updatable = false) })
	private List<Formation> formations;

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public Niveau() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Niveau(String nomNiveau) {
		super();
		this.nomNiveau = nomNiveau;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public List<Semestre> getSemestres() {
		return semestres;
	}

	public void setSemestres(List<Semestre> semestres) {
		this.semestres = semestres;
	}

	public Long getIdNiveau() {
		return idNiveau;
	}

	public void setIdNiveau(Long idNiveau) {
		this.idNiveau = idNiveau;
	}

	public String getNomNiveau() {
		return nomNiveau;
	}

	public void setNomNiveau(String nomNiveau) {
		this.nomNiveau = nomNiveau;
	}

	public String getLabelNiveau() {
		return labelNiveau;
	}

	public void setLabelNiveau(String labelNiveau) {
		this.labelNiveau = labelNiveau;
	}

}

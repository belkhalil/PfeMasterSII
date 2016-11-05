package com.empsi.entities.formation;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Module implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idModule")
	private Long idModule;
	private String nomModule;
	private String descModule;
//	@Transient
//	private Map<String, String> links = new HashMap<>();
//	
//	
//
//	public Map<String, String> getLinks() {
//		return links;
//	}
//
//	public void setLinks(Map<String, String> links) {
//		this.links = links;
//	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "formation_module", joinColumns = { 
			@JoinColumn(name = "idModule", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "idFormation", 
					nullable = false, updatable = false) })
	private List<Formation> formations;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "Module_Semestre", joinColumns = { 
			@JoinColumn(name = "idModule", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "idSemestre", 
					nullable = false, updatable = false) })
	private List<Semestre> Semestres;
	
	@JsonIgnore
	@OneToMany
	private List<Matiere> matieres;
	
//	@JsonIgnore
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//	@JoinTable(name = "Module_matieres", joinColumns = { 
//			@JoinColumn(name = "idModule", nullable = false, updatable = false) }, 
//			inverseJoinColumns = { @JoinColumn(name = "idMatiere", 
//					nullable = false, updatable = false) })
//	private List<Matiere> matieres;
	
	
	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	public List<Semestre> getSemestres() {
		return Semestres;
	}

	public void setSemestres(List<Semestre> semestres) {
		Semestres = semestres;
	}

	public Long getIdModule() {
		return idModule;
	}

	public void setIdModule(Long idModule) {
		this.idModule = idModule;
	}

	public String getNomModule() {
		return nomModule;
	}

	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}

	public String getDescModule() {
		return descModule;
	}

	public void setDescModule(String descModule) {
		this.descModule = descModule;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public Module() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Module(String nomModule, String descModule) {
		super();
		this.nomModule = nomModule;
		this.descModule = descModule;

	}
}

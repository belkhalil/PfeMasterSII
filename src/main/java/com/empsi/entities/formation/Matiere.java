package com.empsi.entities.formation;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.empsi.entities.formation.Seance;
import com.empsi.entities.formation.Enseignant;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Matiere implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idMatiere")
	private Long idMatiere;
	private String nomMatiere;
	private String description;
	
    
	@ManyToOne
	@JoinColumn(name="idModule")
	private Module module;
	
   public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
@ManyToMany
   private List<Module> modules;
   
	public List<Module> getModules() {
	return modules;
}
public void setModules(List<Module> modules) {
	this.modules = modules;
}

    @JsonIgnore
    @OneToMany(mappedBy="matiere")
    private List<Seance> seances;

    
	@ManyToOne
	@JoinColumn(name="idEnseignant")
	private Enseignant enseignant;

    
	public List<Seance> getSeances() {
		return seances;
	}
	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}
	public Long getIdMatiere() {
		return idMatiere;
	}
	public void setIdMatiere(Long idMatiere) {
		this.idMatiere = idMatiere;
	}
	public String getNomMatiere() {
		return nomMatiere;
	}
	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
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
	public Matiere(String nomMatiere, String description) {
		super();
		this.nomMatiere = nomMatiere;
		this.description = description;
	}
	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

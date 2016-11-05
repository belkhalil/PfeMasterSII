package com.empsi.entities.classes;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AnneeScolaire implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAnne;
	private String anneeDebut;
	private String anneeFin;
	private String DescAnne;
	
	@OneToMany(mappedBy = "anneScolaire")
    private List<Classe> classe ;

	public AnneeScolaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnneeScolaire(String anneeDebut, String anneeFin, String descAnne) {
		super();
		this.anneeDebut = anneeDebut;
		this.anneeFin = anneeFin;
		DescAnne = descAnne;
	}

	public Long getIdAnne() {
		return idAnne;
	}

	public void setIdAnne(Long idAnne) {
		this.idAnne = idAnne;
	}

	public String getAnneeDebut() {
		return anneeDebut;
	}

	public void setAnneeDebut(String anneeDebut) {
		this.anneeDebut = anneeDebut;
	}

	public String getAnneeFin() {
		return anneeFin;
	}

	public void setAnneeFin(String anneeFin) {
		this.anneeFin = anneeFin;
	}

	public String getDescAnne() {
		return DescAnne;
	}

	public void setDescAnne(String descAnne) {
		DescAnne = descAnne;
	}
	@JsonIgnore
	public List<Classe> getClasse() {
		return classe;
	}
	@JsonSetter
	public void setClasse(List<Classe> classe) {
		this.classe = classe;
	}
	
	
}

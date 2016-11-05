package com.empsi.entities.formation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.empsi.entities.formation.Matiere;
import com.empsi.entities.rights.User;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public abstract class Enseignant extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nbrHeureSemaine;
	
	@JsonIgnore
	@OneToMany(mappedBy = "enseignant")
    private List<Matiere> matieres;

	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getNbrHeureSemaine() {
		return nbrHeureSemaine;
	}

	public void setNbrHeureSemaine(int nbrHeureSemaine) {
		this.nbrHeureSemaine = nbrHeureSemaine;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}
}

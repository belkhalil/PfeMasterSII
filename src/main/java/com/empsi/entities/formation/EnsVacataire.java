package com.empsi.entities.formation;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class EnsVacataire extends Enseignant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double salaireHeure;
	public EnsVacataire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public double getSalaireHeure() {
		return salaireHeure;
	}
	public void setSalaireHeure(double salaireHeure) {
		this.salaireHeure = salaireHeure;
	}
	
	
	
}

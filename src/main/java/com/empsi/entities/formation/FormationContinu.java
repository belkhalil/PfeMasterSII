package com.empsi.entities.formation;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class FormationContinu extends Formation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long dure;

	public FormationContinu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormationContinu(String nomFormation, String descFormation, Date dateDebut, Date dateFin, double prix) {
		super(nomFormation, descFormation, dateDebut, dateFin, prix);
		// TODO Auto-generated constructor stub
	}

	public FormationContinu(String nomFormation, String descFormation, Date dateDebut, Date dateFin, double prix,
			Long dure) {
		super(nomFormation, descFormation, dateDebut, dateFin, prix);
		this.dure = dure;
	}

	public Long getDure() {
		return dure;
	}

	public void setDure(Long dure) {
		this.dure = dure;
	}
	
	
}

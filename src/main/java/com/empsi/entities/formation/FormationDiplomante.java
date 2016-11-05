package com.empsi.entities.formation;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class FormationDiplomante extends Formation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FormationDiplomante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormationDiplomante(String nomFormation, String descFormation, Date dateDebut, Date dateFin, double prix) {
		super(nomFormation, descFormation, dateDebut, dateFin, prix);
		// TODO Auto-generated constructor stub
	}

}

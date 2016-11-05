package com.empsi.entities.patrimoine;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.empsi.entities.formation.Seance;

@Entity
public class Salle implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSalle;
	private int numSalle;
	private String typeSalle;
	private Boolean etatSalle;
	private String descSalle;
	private String labelEtat;
	
	@OneToMany(mappedBy = "salle")
    private List<Seance> seances;

	public Salle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Salle(int numSalle, String typeSalle, Boolean etatSalle, String descSalle) {
		super();
		this.numSalle = numSalle;
		this.typeSalle = typeSalle;
		this.etatSalle = etatSalle;
		this.descSalle = descSalle;
	}

	public Long getIdSalle() {
		return idSalle;
	}

	public String getLabelEtat() {
		return labelEtat;
	}

	public void setLabelEtat(String labelEtat) {
		this.labelEtat = labelEtat;
	}

	public void setIdSalle(Long idSalle) {
		this.idSalle = idSalle;
	}

	public int getNumSalle() {
		return numSalle;
	}

	public void setNumSalle(int numSalle) {
		this.numSalle = numSalle;
	}

	public String getTypeSalle() {
		return typeSalle;
	}

	public void setTypeSalle(String typeSalle) {
		this.typeSalle = typeSalle;
	}

	public Boolean getEtatSalle() {
		return etatSalle;
	}

	public void setEtatSalle(Boolean etatSalle) {
		this.etatSalle = etatSalle;
	}

	public String getDescSalle() {
		return descSalle;
	}

	public void setDescSalle(String descSalle) {
		this.descSalle = descSalle;
	}

	public List<Seance> getSeances() {
		return seances;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}
	
	
}

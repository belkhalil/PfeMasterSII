package com.empsi.entities.all;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Evaluation implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEvaluation;
	private String objet;
	private String description;
	private Date dateEvaluation;
	public Long getIdEvaluation() {
		return idEvaluation;
	}
	public void setIdEvaluation(Long idEvaluation) {
		this.idEvaluation = idEvaluation;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateEvaluation() {
		return dateEvaluation;
	}
	public void setDateEvaluation(Date dateEvaluation) {
		this.dateEvaluation = dateEvaluation;
	}
	public Evaluation(String objet, String description, Date dateEvaluation) {
		super();
		this.objet = objet;
		this.description = description;
		this.dateEvaluation = dateEvaluation;
	}
	public Evaluation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

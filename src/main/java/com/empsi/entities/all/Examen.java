package com.empsi.entities.all;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
@Entity
public class Examen extends Devoir implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String sujet;
	private Date dateEvaluation;
	private String path;
	public Examen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Examen(Date dateDevoir, String description, String sujet, Date dateEvaluation, String path) {
		super(dateDevoir, description);
		this.sujet = sujet;
		this.dateEvaluation = dateEvaluation;
		this.path = path;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public Date getDateEvaluation() {
		return dateEvaluation;
	}
	public void setDateEvaluation(Date dateEvaluation) {
		this.dateEvaluation = dateEvaluation;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}

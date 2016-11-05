package com.empsi.entities.all;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.empsi.entities.formation.Module;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Devoir implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="idDevoir")
	private Long idDevoir;
	private Date dateDevoir;
	private String description;
	@ManyToOne
	@JoinColumn(name="idMatiere")
	private Module matiere;
	public Long getIdDevoir() {
		return idDevoir;
	}
	public void setIdDevoir(Long idDevoir) {
		this.idDevoir = idDevoir;
	}
	public Date getDateDevoir() {
		return dateDevoir;
	}
	public void setDateDevoir(Date dateDevoir) {
		this.dateDevoir = dateDevoir;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Module getMatiere() {
		return matiere;
	}
	public void setMatiere(Module matiere) {
		this.matiere = matiere;
	}
	public Devoir(Date dateDevoir, String description) {
		super();
		this.dateDevoir = dateDevoir;
		this.description = description;
	}
	public Devoir() {
		super();
		// TODO Auto-generated constructor stub
	}

}

package com.empsi.entities.formation;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class TypeFormaton implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTypeFormation;

	private String LabelTypeFormation;
	/*
	@ManyToOne
    @JoinColumn(name = "idFormation")
	private Formation formation;*/
	
	@ManyToMany(mappedBy = "typeFormations")
	private List<Formation> formations;

	public TypeFormaton() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeFormaton(Long idTypeFormation, String labelTypeFormation) {
		super();
		this.idTypeFormation = idTypeFormation;
		LabelTypeFormation = labelTypeFormation;
	}

	public Long getIdTypeFormation() {
		return idTypeFormation;
	}

	public void setIdTypeFormation(Long idTypeFormation) {
		this.idTypeFormation = idTypeFormation;
	}

	public String getLabelTypeFormation() {
		return LabelTypeFormation;
	}

	public void setLabelTypeFormation(String labelTypeFormation) {
		LabelTypeFormation = labelTypeFormation;
	}

	@JsonIgnore	
	public List<Formation> getFormations() {
		return formations;
	}
	@JsonSetter
	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
	

}

package com.empsi.entities.users;

import java.io.Serializable;

import javax.persistence.Entity;

import com.empsi.entities.rights.User;
@Entity
public class Parent extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int nbrEnfants;
	private String nomCompletMere;
	private String nomCompletPere;
	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNbrEnfants() {
		return nbrEnfants;
	}
	public void setNbrEnfants(int nbrEnfants) {
		this.nbrEnfants = nbrEnfants;
	}
	public String getNomCompletMere() {
		return nomCompletMere;
	}
	public void setNomCompletMere(String nomCompletMere) {
		this.nomCompletMere = nomCompletMere;
	}
	public String getNomCompletPere() {
		return nomCompletPere;
	}
	public void setNomCompletPere(String nomCompletPere) {
		this.nomCompletPere = nomCompletPere;
	}
	
	
	
	
}

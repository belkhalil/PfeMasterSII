package com.empsi.entities.all;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.empsi.entities.rights.User;
@Entity
public class Historique implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idHistorique;
	private Date dateAction;
	// ABDELJABBAR 
	private User utilisateur;
	//methode executé 
    private String methode;
	public Long getIdHistorique() {
		return idHistorique;
	}
	public void setIdHistorique(Long idHistorique) {
		this.idHistorique = idHistorique;
	}
	public Date getDateAction() {
		return dateAction;
	}
	public void setDateAction(Date dateAction) {
		this.dateAction = dateAction;
	}
	public User getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}
	public String getMethode() {
		return methode;
	}
	public void setMethode(String methode) {
		this.methode = methode;
	}
	public Historique() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Historique(Date dateAction, String methode) {
		super();
		this.dateAction = dateAction;
		this.methode = methode;
	}
    
    
}

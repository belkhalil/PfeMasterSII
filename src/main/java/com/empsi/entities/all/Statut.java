package com.empsi.entities.all;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.empsi.entities.rights.User;

@Entity
public class Statut implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idStatut")
	private Long idStatut;
	private String contenu;
	private String type;
	
	@ManyToOne
    @JoinColumn(name = "idUtilisateur")
	private User utilisateur;

	public Statut(String contenu, String type) {
		super();
		this.contenu = contenu;
		this.type = type;
	}

	public Statut() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdStatut() {
		return idStatut;
	}

	public void setIdStatut(Long idStatut) {
		this.idStatut = idStatut;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
}

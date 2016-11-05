package com.empsi.entities.users;

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
public class Diplome implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idDiplome")
	private Long idDiplome;
	private String titre;
	private String etablissement;
	private Boolean anneeObtention;
	private String description;
	private String mention;
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private User utilisateur;
	public Long getIdDiplome() {
		return idDiplome;
	}
	public void setIdDiplome(Long idDiplome) {
		this.idDiplome = idDiplome;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
	public Boolean getAnneeObtention() {
		return anneeObtention;
	}
	public void setAnneeObtention(Boolean anneeObtention) {
		this.anneeObtention = anneeObtention;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMention() {
		return mention;
	}
	public void setMention(String mention) {
		this.mention = mention;
	}
	public User getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Diplome() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Diplome(String titre, String etablissement, Boolean anneeObtention, String description, String mention) {
		super();
		this.titre = titre;
		this.etablissement = etablissement;
		this.anneeObtention = anneeObtention;
		this.description = description;
		this.mention = mention;
	}
	
	
}

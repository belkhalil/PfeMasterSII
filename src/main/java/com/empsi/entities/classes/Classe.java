package com.empsi.entities.classes;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.empsi.entities.users.Etudiant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Access(AccessType.FIELD)
public class Classe implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idClasse")
	private Long idClasse;
	private String nomClasse;
	private String descClasse;
	private int nbrEtudiant;
	
	@ManyToOne
    @JoinColumn(name = "idAnnee")
	private AnneeScolaire anneScolaire;
	
	@OneToMany(mappedBy = "classe")
	  private List<Etudiant> etudiants;
	
	@OneToMany(mappedBy = "classe")
	  private List<Fichier> fichiers;

	 @OneToMany(mappedBy = "classe" , cascade = CascadeType.REMOVE)
	 private List<MessageClasse> messages;
	 
	 @JsonIgnore
	public List<MessageClasse> getMessages() {
		return messages;
	}
	 @JsonSetter
	public void setMessages(List<MessageClasse> messages) {
		this.messages = messages;
	}

	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classe(String nomClasse, int nbrEtudiant , String descClasse) {
		super();
		this.nomClasse = nomClasse;
		this.nbrEtudiant = nbrEtudiant;
		this.descClasse = descClasse;
	}

	public Long getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(Long idClasse) {
		this.idClasse = idClasse;
	}

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	public int getNbrEtudiant() {
		return nbrEtudiant;
	}

	public void setNbrEtudiant(int nbrEtudiant) {
		this.nbrEtudiant = nbrEtudiant;
	}
	@JsonIgnore
	public AnneeScolaire getAnneScolaire() {
		return anneScolaire;
	}
	@JsonSetter
	public void setAnneScolaire(AnneeScolaire anneScolaire) {
		this.anneScolaire = anneScolaire;
	}

	public String getDescClasse() {
		return descClasse;
	}

	public void setDescClasse(String descClasse) {
		this.descClasse = descClasse;
	}
	@JsonIgnore
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	@JsonSetter
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	@JsonIgnore
	public List<Fichier> getFichiers() {
		return fichiers;
	}
	@JsonSetter
	public void setFichiers(List<Fichier> fichiers) {
		this.fichiers = fichiers;
	}
	
}

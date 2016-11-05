package com.empsi.entities.classes;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.empsi.entities.rights.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Fichier implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFichier;
	private String lienFichier;
	private String extension;
	private String nomFichier;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	 @DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date datePartage;
	@ManyToOne
	@JoinColumn(name="id_enseignant")
	private User enseignant;
	
	/*@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "fichier_classe", joinColumns = { 
			@JoinColumn(name = "idFichier", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "idClasse", 
					nullable = false, updatable = false) })
	private List<Classe> classes;*/
	
	@ManyToOne
	@JoinColumn(name="id_classe")
	private Classe classe;
	
	public User getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(User enseignant) {
		this.enseignant = enseignant;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Fichier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fichier(String lienFichier, String extension) {
		super();
		this.lienFichier = lienFichier;
		this.extension = extension;
	}
	public Long getIdFichier() {
		return idFichier;
	}
	public void setIdFichier(Long idFichier) {
		this.idFichier = idFichier;
	}
	public String getLienFichier() {
		return lienFichier;
	}
	public void setLienFichier(String lienFichier) {
		this.lienFichier = lienFichier;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	@Column(name="enseignant")
	public User getUser() {
		return enseignant;
	}
	public void setUser(User enseignant) {
		this.enseignant = enseignant;
	}
	public String getNomFichier() {
		return nomFichier;
	}
	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDatePartage() {
		return datePartage;
	}
	public void setDatePartage(Date datePartage) {
		this.datePartage = datePartage;
	}
	
}

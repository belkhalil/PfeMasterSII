package com.empsi.entities.rights;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.empsi.entities.all.Document;
import com.empsi.entities.patrimoine.ReservationMateriel;
import com.empsi.entities.all.Statut;
import com.empsi.entities.classes.Fichier;
import com.empsi.entities.messages.Notification;
import com.empsi.entities.users.Diplome;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@XmlRootElement
@Table(name = "users")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "ID")
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private String telephone;

	private String sexe;
	

	private Boolean deletable;
	
	@JsonFormat(shape=Shape.STRING, pattern="yyyy-MM-dd")	
	private Date dateNaissance;
	private String villeNaissance;
	private String paysNaissance;
	private String adresseUtilisateur;
	private String telUtilisateur;
	private String telFixUtilisateur;
	private String professionUtilisateur;
	private String cin ;

	private Date dateInscription;
	private Boolean etatCompte ;
	
	

	@JsonIgnore
	@OneToMany(mappedBy="utilisateur")
	private List<Diplome> diplomes;
	
	@JsonIgnore
	@OneToMany(mappedBy="utilisateur")
	private List<Statut> statuts;
	
	@JsonIgnore
	@OneToMany(mappedBy="utilisateur")
	private List<Document> documents;
	
//compte
//	@JsonIgnore
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "idCompte", referencedColumnName= "idCompte")
//	private Compte compte;
	
	/*@ManyToMany(fetch = FetchType.LAZY, mappedBy = "membres")
	private List<Club> clubs;*/

	@JsonIgnore
	@OneToMany(mappedBy="utilisateur")
	private List<ReservationMateriel> resMateriels;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "notifUser", joinColumns = { 
			@JoinColumn(name = "idUtilisateur", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "idNotification", 
					nullable = false, updatable = false) })
	private List<Notification> notifications;
	
	
	@OneToMany(mappedBy = "enseignant")
    private List<Fichier> fichiers;
	
	
	@JsonIgnore
	public List<Fichier> getFichiers() {
		return fichiers;
	}
	@JsonSetter
	public void setFichiers(List<Fichier> fichiers) {
		this.fichiers = fichiers;
	}
	
	public User() {

	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	

	

	public Boolean getDeletable() {
		return deletable;
	}

	public void setDeletable(Boolean deletable) {
		this.deletable = deletable;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getVilleNaissance() {
		return villeNaissance;
	}

	public void setVilleNaissance(String villeNaissance) {
		this.villeNaissance = villeNaissance;
	}

	public String getPaysNaissance() {
		return paysNaissance;
	}

	public void setPaysNaissance(String paysNaissance) {
		this.paysNaissance = paysNaissance;
	}

	public String getAdresseUtilisateur() {
		return adresseUtilisateur;
	}

	public void setAdresseUtilisateur(String adresseUtilisateur) {
		this.adresseUtilisateur = adresseUtilisateur;
	}

	public String getTelUtilisateur() {
		return telUtilisateur;
	}

	public void setTelUtilisateur(String telUtilisateur) {
		this.telUtilisateur = telUtilisateur;
	}

	public String getTelFixUtilisateur() {
		return telFixUtilisateur;
	}

	public void setTelFixUtilisateur(String telFixUtilisateur) {
		this.telFixUtilisateur = telFixUtilisateur;
	}

	public String getProfessionUtilisateur() {
		return professionUtilisateur;
	}

	public void setProfessionUtilisateur(String professionUtilisateur) {
		this.professionUtilisateur = professionUtilisateur;
	}

	

	public List<Diplome> getDiplomes() {
		return diplomes;
	}

	public void setDiplomes(List<Diplome> diplomes) {
		this.diplomes = diplomes;
	}

	public List<Statut> getStatuts() {
		return statuts;
	}

	public void setStatuts(List<Statut> statuts) {
		this.statuts = statuts;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

//	public Compte getCompte() {
//		return compte;
//	}
//
//	public void setCompte(Compte compte) {
//		this.compte = compte;
//	}

	public List<ReservationMateriel> getResMateriels() {
		return resMateriels;
	}

	public void setResMateriels(List<ReservationMateriel> resMateriels) {
		this.resMateriels = resMateriels;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", password=" + password
				+ ", telephone=" + telephone + ", deletable=" + deletable + "]";
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	public Boolean getEtatCompte() {
		return etatCompte;
	}

	public void setEtatCompte(Boolean etatCompte) {
		this.etatCompte = etatCompte;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
}

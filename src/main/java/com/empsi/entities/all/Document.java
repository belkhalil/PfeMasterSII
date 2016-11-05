package com.empsi.entities.all;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.empsi.entities.rights.User;

@Entity
public class Document implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDocument;
	private String nomDocument;
	private String path;
	//table type document
	private String commentaire;
	private Date datePub;
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private User utilisateur;
	
	@ManyToOne
	@JoinColumn(name="idType")
	private TypeDocument type;

	public Long getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}

	public String getNomDocument() {
		return nomDocument;
	}

	public void setNomDocument(String nomDocument) {
		this.nomDocument = nomDocument;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Date getDatePub() {
		return datePub;
	}

	public void setDatePub(Date datePub) {
		this.datePub = datePub;
	}

	public User getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}

	public TypeDocument getType() {
		return type;
	}

	public void setType(TypeDocument type) {
		this.type = type;
	}

	public Document(String nomDocument, String path, String commentaire, Date datePub) {
		super();
		this.nomDocument = nomDocument;
		this.path = path;
		this.commentaire = commentaire;
		this.datePub = datePub;
	}

	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//enumeratio
	
	
	
}

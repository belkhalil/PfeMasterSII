package com.empsi.entities.messages;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.empsi.entities.rights.User;
@Entity
@XmlRootElement
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Declaration implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idDeclaration")
	private Long idDeclaration;
	private String objet;
	private String contenu;
	private String typeDeclaration;
	private Date datedeclaration;
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	
	
	public Long getIdDeclaration() {
		return idDeclaration;
	}
	public void setIdDeclaration(Long idDeclaration) {
		this.idDeclaration = idDeclaration;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public String getTypeDeclaration() {
		return typeDeclaration;
	}
	public void setTypeDeclaration(String typeDeclaration) {
		this.typeDeclaration = typeDeclaration;
	}
	public Date getDatedeclaration() {
		return datedeclaration;
	}
	public void setDatedeclaration(Date datedeclaration) {
		this.datedeclaration = datedeclaration;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Declaration() {
		super();
		
	}
	public Declaration(String objet, String contenu, String typeDeclaration, Date datedeclaration) {
		super();
		this.objet = objet;
		this.contenu = contenu;
		this.typeDeclaration = typeDeclaration;
		this.datedeclaration = datedeclaration;
	}
	
}

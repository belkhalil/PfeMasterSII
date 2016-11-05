package com.empsi.entities.messages;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.empsi.entities.rights.User;

@Entity
public class Notification implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idNotif;
	private String contenu;
	private String objet;
	private boolean vue;
	private User user;
	
	public Notification() {
		super();
	}
	public Notification(String contenu, String objet, boolean vue) {
		super();
		this.contenu = contenu;
		this.objet = objet;
		this.vue = vue;
	}
	public Long getIdNotif() {
		return idNotif;
	}
	public void setIdNotif(Long idNotif) {
		this.idNotif = idNotif;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public boolean isVue() {
		return vue;
	}
	public void setVue(boolean vue) {
		this.vue = vue;
	}
	
	
}	
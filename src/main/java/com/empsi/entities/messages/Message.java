package com.empsi.entities.messages;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

import com.empsi.entities.rights.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@XmlRootElement
@Table(name = "messages")
public class Message implements Serializable{

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String objet;
	private String email;
	private String message;
	private String email_sender;
	@Temporal(TemporalType.TIMESTAMP)
	 @DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dateEnvoi;
	private Date dateReception;
	
	@ManyToOne()
    @JoinColumn(name = "id_sender")
	
	private User user;
	
	@ManyToOne()
    @JoinColumn(name = "id_recepteur")
	
	private User user2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser2() {
		return user2;
	}
	
	public void setUser2(User user2) {
		this.user2 = user2;
	}
	

	public Date getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public Date getDateReception() {
		return dateReception;
	}

	public void setDateReception(Date dateReception) {
		this.dateReception = dateReception;
	}


	public Message() {
		super();
		
	}

	public Message(String objet, String message , Date dateEnvoi , String email) {
		super();
		this.objet = objet;
		this.message = message;
		this.dateEnvoi = dateEnvoi;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail_sender() {
		return email_sender;
	}

	public void setEmail_sender(String email_sender) {
		this.email_sender = email_sender;
	}
	
	
}

package com.empsi.entities.classes;

import java.io.Serializable;
import java.util.Date;

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
public class MessageClasse implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		private String objet;
		private String email;
		private String message;

		@Temporal(TemporalType.TIMESTAMP)
		 @DateTimeFormat(pattern = "dd-MM-yyyy")
		private Date dateEnvoi;
		private Date dateReception;
		
		@ManyToOne
	    @JoinColumn(name = "idClasse")
		private  Classe classe;
		@ManyToOne
	    @JoinColumn(name = "idUser")
		private User user;
		
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public MessageClasse() {
			super();
			// TODO Auto-generated constructor stub
		}

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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
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
		
		public Classe getClasse() {
			return classe;
		}

		public void setClasse(Classe classe) {
			this.classe = classe;
		}
	
}

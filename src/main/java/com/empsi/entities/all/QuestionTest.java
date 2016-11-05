package com.empsi.entities.all;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class QuestionTest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  idQestion;
	private String Qestion;
	private String bonneReponse;
	private String Reponse1;
	private String Reponse2;
	@ManyToOne
	@JoinColumn(name="idTest")
	private TestEnLigne test;
	public QuestionTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionTest(String qestion, String bonneReponse, String reponse1, String reponse2) {
		super();
		Qestion = qestion;
		this.bonneReponse = bonneReponse;
		Reponse1 = reponse1;
		Reponse2 = reponse2;
	}
	public Long getIdQestion() {
		return idQestion;
	}
	public void setIdQestion(Long idQestion) {
		this.idQestion = idQestion;
	}
	public String getQestion() {
		return Qestion;
	}
	public void setQestion(String qestion) {
		Qestion = qestion;
	}
	public String getBonneReponse() {
		return bonneReponse;
	}
	public void setBonneReponse(String bonneReponse) {
		this.bonneReponse = bonneReponse;
	}
	public String getReponse1() {
		return Reponse1;
	}
	public void setReponse1(String reponse1) {
		Reponse1 = reponse1;
	}
	public String getReponse2() {
		return Reponse2;
	}
	public void setReponse2(String reponse2) {
		Reponse2 = reponse2;
	}
	
	
}

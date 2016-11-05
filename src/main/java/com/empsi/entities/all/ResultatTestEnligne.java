package com.empsi.entities.all;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.empsi.entities.users.Etudiant;
@Entity
public class ResultatTestEnligne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idReponseEtud;
	private double note;
	
	@ManyToOne
    @JoinColumn(name = "idEtudiant")
	private Etudiant etudiant;
	@ManyToOne
    @JoinColumn(name = "idTest")
	private TestEnLigne test;
	public ResultatTestEnligne() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultatTestEnligne(double note) {
		super();
		this.note = note;
	}
	public Long getIdReponseEtud() {
		return idReponseEtud;
	}
	public void setIdReponseEtud(Long idReponseEtud) {
		this.idReponseEtud = idReponseEtud;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public TestEnLigne getTest() {
		return test;
	}
	public void setTest(TestEnLigne test) {
		this.test = test;
	}
	
	
}

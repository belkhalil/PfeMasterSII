package com.empsi.entities.all;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class TestEnLigne extends Devoir implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date dateTest;
	private String sujet;
	
	@OneToMany(mappedBy="test")
	private List<QuestionTest> questions;

	public Date getDateTest() {
		return dateTest;
	}

	public void setDateTest(Date dateTest) {
		this.dateTest = dateTest;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public List<QuestionTest> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionTest> questions) {
		this.questions = questions;
	}

	public TestEnLigne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestEnLigne(Date dateDevoir, String description, Date dateTest, String sujet) {
		super(dateDevoir, description);
		this.dateTest = dateTest;
		this.sujet = sujet;
	}
	
	
}

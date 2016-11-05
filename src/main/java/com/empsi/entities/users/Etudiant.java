package com.empsi.entities.users;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.empsi.entities.all.AbsenceEtudiant;
import com.empsi.entities.classes.Classe;
import com.empsi.entities.rights.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Etudiant extends User implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cne;
	private String anneeObtentionBac;
	
	
//	@ManyToOne
//	@JoinColumn(name="idParent")
//	private Parent parent;
	@OneToMany(mappedBy = "etudiant")
    private List<AbsenceEtudiant> absences;
	
	@ManyToOne
	@JoinColumn(name="id_classe")
	private Classe classe;
	
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	public String getAnneeObtentionBac() {
		return anneeObtentionBac;
	}
	public void setAnneeObtentionBac(String anneeObtentionBac) {
		this.anneeObtentionBac = anneeObtentionBac;
	}
	
//	public Parent getParent() {
//		return parent;
//	}
//	public void setParent(Parent parent) {
//		this.parent = parent;
//	}
	public List<AbsenceEtudiant> getAbsences() {
		return absences;
	}
	public void setAbsences(List<AbsenceEtudiant> absences) {
		this.absences = absences;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	
	
	
	

}

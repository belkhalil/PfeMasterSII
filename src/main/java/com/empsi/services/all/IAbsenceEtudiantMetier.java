package com.empsi.services.all;

import java.util.List;

import com.empsi.entities.all.AbsenceEtudiant;

public interface IAbsenceEtudiantMetier {

	public AbsenceEtudiant get(Long id);
	public List<AbsenceEtudiant> getAll();
	public AbsenceEtudiant save(AbsenceEtudiant abs);
	public AbsenceEtudiant update(AbsenceEtudiant abs);
	public boolean delete(Long id);
	
}

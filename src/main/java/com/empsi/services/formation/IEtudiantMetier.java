package com.empsi.services.formation;

import java.util.List;

import com.empsi.entities.users.Etudiant;



public interface IEtudiantMetier {

	
	public Etudiant save(Etudiant e);
	public Etudiant get(Long id);
	public Etudiant Update(Etudiant Student );
	public List<Etudiant> getAll();
	public Boolean delete(Long id);
}

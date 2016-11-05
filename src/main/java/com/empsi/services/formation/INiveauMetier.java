package com.empsi.services.formation;

import java.util.List;


import com.empsi.entities.formation.Niveau;

public interface INiveauMetier {

	public Niveau get(Long id);
	public List<Niveau> getAll();
	public Niveau save(Niveau niveau);
	public Niveau update(Niveau niveau);
	public boolean delete(Long id);
	public boolean addFormationToNiveau(Long idFormation,Long idNiveau);
	
	public boolean removeFormationFromNiveau(Long idFormation,Long idNiveau);
	
}

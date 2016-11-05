package com.empsi.services.formation;

import java.util.List;

import com.empsi.entities.formation.FormationDiplomante;

public interface IFormationDiplomanteMetier {
	public FormationDiplomante get(Long id);
	public List<FormationDiplomante> getAll();
	public FormationDiplomante save(FormationDiplomante formation);
	public FormationDiplomante update(FormationDiplomante formation);
	public boolean delete(Long id);
	public boolean addTypeToFormation(Long idT,Long idF);
	public boolean updateTypeOfFormation(Long idoldT,Long idnewT,Long idF);
}

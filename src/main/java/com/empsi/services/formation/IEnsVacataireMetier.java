package com.empsi.services.formation;

import java.util.List;

import com.empsi.entities.formation.EnsVacataire;

public interface IEnsVacataireMetier  {
	
	public EnsVacataire get(Long id);
	public List<EnsVacataire> getAll();
	public EnsVacataire save(EnsVacataire ens);
	public EnsVacataire update(EnsVacataire ens);
	public boolean delete(Long id);

}

package com.empsi.services.formation;

import java.util.List;

import com.empsi.entities.formation.EnsPermanent;

public interface IEnsPernamentMetier {
	
	public EnsPermanent get(Long id);
	public List<EnsPermanent> getAll();
	public EnsPermanent save(EnsPermanent ens);
	public EnsPermanent update(EnsPermanent ens);
	public boolean delete(Long id);
	public boolean affecterMatiereToEnsP(Long idMatiere, Long idEns);
}

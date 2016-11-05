package com.empsi.services.patrimoine;

import java.util.List;


import com.empsi.entities.patrimoine.Salle;

public interface ISalleMetier {

	public Salle save(Salle m);
	public Salle get(Long id);
	public Salle Update(Salle salle );
	public List<Salle> getAll();
	public Boolean delete(Long id);
	
}

package com.empsi.services.patrimoine;

import java.util.List;


import com.empsi.entities.patrimoine.Materiel;

public interface IMaterielMetier {

	public Materiel save(Materiel m);
	public Materiel get(Long id);
	public Materiel Update(Materiel materiel );
	public List<Materiel> getAll();
	public Boolean delete(Long id);
	
}

package com.empsi.services.classes;

import java.util.List;

import com.empsi.entities.classes.AnneeScolaire;

public interface IAnneeScolaireMetier {

	public AnneeScolaire get(Long id);
	public List<AnneeScolaire> getAll();
	public AnneeScolaire save(AnneeScolaire ans);
	public AnneeScolaire update(AnneeScolaire ans);
	public boolean delete(Long id);
}

package com.empsi.services.formation;

import java.util.List;


import com.empsi.entities.formation.Seance;

public interface ISeanceMetier {
	public Seance get(Long id);
	public List<Seance> getAll();
	public Seance save(Seance seance);
	public Seance update(Seance seance);
	public boolean delete(Long id);
	public boolean addSeanceToMatiere(Long idSeance, Long idMatiere);
}

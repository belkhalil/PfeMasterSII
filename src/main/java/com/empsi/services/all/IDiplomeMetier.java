package com.empsi.services.all;

import java.util.List;

import com.empsi.entities.users.Diplome;

public interface IDiplomeMetier {
	public Diplome get(Long id);
	public List<Diplome> getAll();
	public Diplome save(Diplome d);
	public Diplome update(Diplome d);
	public boolean delete(Long id);
}

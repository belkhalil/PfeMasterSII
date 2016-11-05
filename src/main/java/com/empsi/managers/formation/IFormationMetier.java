package com.empsi.managers.formation;

import java.util.List;

import com.empsi.entities.formation.Formation;

public interface IFormationMetier {

	public Formation get(Long id);
	public List<Formation> getAll();
	public Formation save(Formation dec);
	public Formation update(Formation dec);
	public Formation delete(Long id);
	
}

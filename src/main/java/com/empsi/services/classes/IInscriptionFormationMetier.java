package com.empsi.services.classes;

import java.util.List;

import com.empsi.entities.all.Inscription;

public interface IInscriptionFormationMetier {

	public Inscription save(Inscription insc);
	public List<Inscription> getAll();
	public Inscription getOne(Long id);
	
}

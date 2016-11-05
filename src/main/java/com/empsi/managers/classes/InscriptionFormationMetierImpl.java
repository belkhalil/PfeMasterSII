package com.empsi.managers.classes;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.classes.InscriptionRepository;
import com.empsi.entities.all.Inscription;
import com.empsi.services.classes.IInscriptionFormationMetier;
@Service
public class InscriptionFormationMetierImpl implements IInscriptionFormationMetier{

	@Autowired
	private InscriptionRepository inscriptionRepos;

	@Override
	public Inscription save(Inscription insc) {
		
		return inscriptionRepos.save(insc);
	}
	@Override
	public List<Inscription> getAll() {
		System.out.println("metier INSCRIPTION");
		return inscriptionRepos.findAll();
	}
	@Override
	public Inscription getOne(Long id) {
		// TODO Auto-generated method stub
		return inscriptionRepos.getOne(id);
	}
	
	
}

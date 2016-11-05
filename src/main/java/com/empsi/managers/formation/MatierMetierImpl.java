package com.empsi.managers.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.formation.MatiereRepository;
import com.empsi.dao.formation.ModuleRepository;
import com.empsi.entities.formation.Matiere;
import com.empsi.entities.formation.Module;
import com.empsi.services.formation.IMatierMetier;

@Service
public class MatierMetierImpl implements IMatierMetier {
  @Autowired
  MatiereRepository matiereRepository;
  
  @Autowired 
  ModuleRepository moduleRepository;
  
	@Override
	public Matiere save(Matiere m) {
		matiereRepository.save(m);
		return m;
	}

	@Override
	public Matiere get(Long id) {

          return matiereRepository.findOne(id);
	}

	@Override
	public Matiere Update(Matiere m) {
		return matiereRepository.saveAndFlush(m);
	}

	@Override
	public List<Matiere> getAll() {
		List< Matiere> matieres = matiereRepository.findAll();
		return matieres;
	}
    
	@Override
	public Boolean delete(Long id) {
		matiereRepository.delete(id);
		return true;
	}
	
	public List<Matiere> matiereByModule(Long id)
	{
		
//		System.out.println("l'id de module est ::::::::::"+id);
		List<Matiere> matieres = matiereRepository.matiereByModule(id);
		return matieres;
		
	}

	

}

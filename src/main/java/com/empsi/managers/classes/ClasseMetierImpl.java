package com.empsi.managers.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.classes.ClasseRepository;
import com.empsi.entities.classes.Classe;
import com.empsi.services.classes.IClasseMetier;
@Service
public class ClasseMetierImpl implements IClasseMetier{
	
	@Autowired
	private ClasseRepository classeRepository;
	@Override
	public Classe getClasse(Long id) {
		
		return classeRepository.findOne(id);
	}

	@Override
	public List<Classe> getAll() {
		
		return classeRepository.findAll();
	}

	@Override
	public Classe saveClasse(Classe cl) {
		// TODO Auto-generated method stub
		return classeRepository.save(cl);
	}

	@Override
	public Classe updateClasse(Classe cl) {
		// TODO Auto-generated method stub
		return classeRepository.saveAndFlush(cl);
	}

	@Override
	public boolean deleteClasse(Long id) {
		
		if(classeRepository.getOne(id) != null)
			classeRepository.delete(id);
		else
			return false;
		return true;
	}


}

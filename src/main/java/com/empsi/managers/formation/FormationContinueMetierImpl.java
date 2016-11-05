package com.empsi.managers.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.formation.FormationContinueRepository;
import com.empsi.entities.formation.Formation;
import com.empsi.entities.formation.FormationContinu;
import com.empsi.services.formation.IFormationContinueMetier;
@Service
public class FormationContinueMetierImpl implements IFormationContinueMetier{

	@Autowired
	private  FormationContinueRepository formationContinueRepository;
	
	@Override
	public FormationContinu get(Long id) {
		return formationContinueRepository.findOne(id); 
	}

	@Override
	public List<FormationContinu> getAll() {
		List<FormationContinu> formations = formationContinueRepository.findAll();
		return formations;
	}

	@Override
	public FormationContinu save(FormationContinu formation) {
		formationContinueRepository.save(formation);
		return formation;
	}

	@Override
	public FormationContinu update(FormationContinu formation) {
		formationContinueRepository.saveAndFlush(formation);
		return formation;
	}

	@Override
	public boolean delete(Long id) {
		formationContinueRepository.delete(id);
		return true;
	}

	
	
	

}

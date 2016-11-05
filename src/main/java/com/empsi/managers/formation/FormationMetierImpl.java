package com.empsi.managers.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.formation.FormationRepository;
import com.empsi.entities.formation.Formation;
@Service
public class FormationMetierImpl implements IFormationMetier{
	@Autowired
	private FormationRepository formRepos;
	@Override
	public Formation get(Long id) {
		// TODO Auto-generated method stub
		return formRepos.getOne(id);
	}

	@Override
	public List<Formation> getAll() {
		// TODO Auto-generated method stub
		return formRepos.findAll();
	}

	@Override
	public Formation save(Formation dec) {
		// TODO Auto-generated method stub
		return formRepos.save(dec);
	}

	@Override
	public Formation update(Formation dec) {
		// TODO Auto-generated method stub
		return formRepos.saveAndFlush(dec);
	}

	@Override
	public Formation delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

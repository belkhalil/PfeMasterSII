package com.empsi.managers.all;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.empsi.dao.all.DiplomeRepository;
import com.empsi.entities.users.Diplome;
import com.empsi.services.all.IDiplomeMetier;

public class DiplomeMetierImpl implements IDiplomeMetier {

	@Autowired
	private DiplomeRepository diplomeRepository;
	@Override
	public Diplome get(Long id) {
		
		return diplomeRepository.findOne(id);
	}

	@Override
	public List<Diplome> getAll() {
		
		return diplomeRepository.findAll();
	}

	@Override
	public Diplome save(Diplome d) {
		// TODO Auto-generated method stub
		return diplomeRepository.save(d);
	}

	@Override
	public Diplome update(Diplome d) {
		// TODO Auto-generated method stub
		return diplomeRepository.saveAndFlush(d);
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		if( diplomeRepository.getOne(id) != null)
			diplomeRepository.delete(id);
		else
			return false;
		return true;
	}

}

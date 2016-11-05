package com.empsi.managers.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.classes.AnneeScolaireRepository;
import com.empsi.entities.classes.AnneeScolaire;
import com.empsi.services.classes.IAnneeScolaireMetier;
@Service
public class AnneeScolaireMetierImpl implements IAnneeScolaireMetier {

	@Autowired
	private AnneeScolaireRepository annees;
	
	@Override
	public AnneeScolaire get(Long id) {
		// TODO Auto-generated method stub
		return annees.getOne(id);
	}

	@Override
	public List<AnneeScolaire> getAll() {
		// TODO Auto-generated method stub
		return annees.findAll();
	}

	@Override
	public AnneeScolaire save(AnneeScolaire ans) {
		// TODO Auto-generated method stub
		return annees.save(ans);
	}

	@Override
	public AnneeScolaire update(AnneeScolaire ans) {
		// TODO Auto-generated method stub
		return annees.saveAndFlush(ans);
	}

	@Override
	public boolean delete(Long id) {
		if(annees.getOne(id) != null)
			annees.delete(id);
		else
			return false;
		return true;
	}

}

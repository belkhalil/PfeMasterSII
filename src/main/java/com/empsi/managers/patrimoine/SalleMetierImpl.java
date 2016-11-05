package com.empsi.managers.patrimoine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.patrimoine.SalleRepository;
import com.empsi.entities.patrimoine.Salle;
import com.empsi.services.patrimoine.ISalleMetier;

@Service
public class SalleMetierImpl implements ISalleMetier {

	@Autowired
	SalleRepository salleRepository;
	
	@Override
	public Salle save(Salle m) {
		m.setEtatSalle(false);
		m.setLabelEtat("libre");
		salleRepository.save(m);
		return m;
	}

	@Override
	public Salle get(Long id) {
		Salle s = salleRepository.findOne(id);
		return s;
	}

	@Override
	public Salle Update(Salle salle) {
		salleRepository.saveAndFlush(salle);
		return salle;
	}

	@Override
	public List<Salle> getAll() {
		List<Salle> salles = salleRepository.findAll();
		return salles;
	}

	@Override
	public Boolean delete(Long id) {
		salleRepository.delete(id);
		return true;
	}

}

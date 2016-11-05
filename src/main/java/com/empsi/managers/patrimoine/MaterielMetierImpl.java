package com.empsi.managers.patrimoine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.patrimoine.MaterielRepository;
import com.empsi.entities.patrimoine.Materiel;
import com.empsi.services.patrimoine.IMaterielMetier;

@Service
public class MaterielMetierImpl implements IMaterielMetier {

	@Autowired
	MaterielRepository materielRepository;

	@Override
	public Materiel save(Materiel m) {
		
		m.setEtat(false);
		m.setLabelEtat("disponible");
		materielRepository.save(m);
		return m;
	}

	@Override
	public Materiel get(Long id) {
		Materiel materiel = materielRepository.findOne(id);
		return materiel;
	}

	@Override
	public Materiel Update(Materiel materiel) {
		materielRepository.saveAndFlush(materiel);
		return materiel;
	}

	@Override
	public List<Materiel> getAll() {
		List<Materiel> materiels = materielRepository.findAll();
		return materiels;
	}

	@Override
	public Boolean delete(Long id) {
		materielRepository.delete(id);
		return true;
	}

}

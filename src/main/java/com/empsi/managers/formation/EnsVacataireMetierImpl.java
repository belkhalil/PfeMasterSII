package com.empsi.managers.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.formation.EnsVacataireRepository;
import com.empsi.entities.formation.EnsVacataire;
import com.empsi.services.formation.IEnsVacataireMetier;

@Service
public class EnsVacataireMetierImpl  implements IEnsVacataireMetier{

	@Autowired
	private EnsVacataireRepository ensVacataireRepository;

	@Override
	public EnsVacataire get(Long id) {
		return ensVacataireRepository.findOne(id);
	}

	@Override
	public List<EnsVacataire> getAll() {
		List<EnsVacataire> ensVacataires=ensVacataireRepository.findAll();
		return ensVacataires;
	}

	@Override
	public EnsVacataire save(EnsVacataire ens) {
		ensVacataireRepository.save(ens);
		return ens;
	}

	@Override
	public EnsVacataire update(EnsVacataire ens) {
		ensVacataireRepository.saveAndFlush(ens);
		return ens;
	}

	@Override
	public boolean delete(Long id) {
		ensVacataireRepository.delete(id);
		return true;
	}
	
	
}

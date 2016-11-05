package com.empsi.managers.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.formation.EnsPermanentRepository;
import com.empsi.dao.formation.MatiereRepository;
import com.empsi.entities.formation.EnsPermanent;
import com.empsi.entities.formation.Matiere;
import com.empsi.services.formation.IEnsPernamentMetier;

@Service
public class EnsPermanentMetierImpl implements IEnsPernamentMetier {
	
	@Autowired
	private EnsPermanentRepository ensPermanentRepository;
	
	@Autowired 
	MatiereRepository matiereRepository;

	@Override
	public EnsPermanent get(Long id) {
		return ensPermanentRepository.findOne(id);
	}

	@Override
	public List<EnsPermanent> getAll() {
		List<EnsPermanent> ensPermanents =ensPermanentRepository.findAll();
		return ensPermanents;
	}

	@Override
	public EnsPermanent save(EnsPermanent ens) {
		ensPermanentRepository.save(ens);
		return ens;
	}

	@Override
	public EnsPermanent update(EnsPermanent ens) {
		ensPermanentRepository.saveAndFlush(ens);
		return ens;
	}

	@Override
	public boolean delete(Long id) {
		ensPermanentRepository.delete(id);
		return true;
	}

	@Override
	public boolean affecterMatiereToEnsP(Long idMatiere, Long idEns) {
		Matiere matiere= matiereRepository.findOne(idMatiere);
		EnsPermanent ensp= ensPermanentRepository.findOne(idEns);
		
		//ensp.getMatieres().add(matiere);
		matiere.setEnseignant(ensp);
		
		ensPermanentRepository.saveAndFlush(ensp);
		matiereRepository.saveAndFlush(matiere);
		return true;
	}
}

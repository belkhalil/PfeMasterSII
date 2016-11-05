package com.empsi.managers.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.formation.NiveauRepository;
import com.empsi.dao.formation.SemestreRepository;
import com.empsi.entities.formation.Niveau;
import com.empsi.entities.formation.Semestre;
import com.empsi.services.formation.ISemestreMetier;

@Service
public class SemestreMetierImpl implements ISemestreMetier {

	@Autowired
	SemestreRepository semestreRepository;
	
	@Autowired
	NiveauRepository niveauRepository;

	@Override
	public Semestre getSemestre(Long id) {
		return semestreRepository.findOne(id);
	}

	@Override
	public List<Semestre> getAll() {
		List<Semestre> semestres = semestreRepository.findAll();
		return semestres;
	}

	@Override
	public Semestre saveSemestre(Semestre Se) {
		semestreRepository.save(Se);
		return Se;
	}

	@Override
	public Semestre updateSemestre(Semestre Se) {
		semestreRepository.saveAndFlush(Se);
		return Se;
	}

	@Override
	public boolean deleteSemestre(Long id) {
		semestreRepository.delete(id);
		return true;
	}

	@Override
	public Boolean addSemestreToNiveau(Long idSemestre, Long idNiveau) {
	
		Semestre s = semestreRepository.findOne(idSemestre);
		Niveau n = niveauRepository.findOne(idNiveau);
		
		s.setNiveau(n);
		
		niveauRepository.saveAndFlush(n);
		semestreRepository.saveAndFlush(s);
		return true;
	}

	@Override
	public Boolean removeSemestreFromNiveau(Long idSemestre, Long idNiveau) {
		Semestre s = semestreRepository.findOne(idSemestre);
		Niveau n = niveauRepository.findOne(idNiveau);
		
		n.getSemestres().remove(s);
		
		niveauRepository.saveAndFlush(n);
		semestreRepository.saveAndFlush(s);
		return true;
	}
	
	public List<Semestre> semestreByNiveau(Long id)
	{
		List<Semestre> semestre= semestreRepository.semestresByNiveau(id);
		return semestre;
	} 

}

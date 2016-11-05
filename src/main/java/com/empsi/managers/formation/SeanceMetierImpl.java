package com.empsi.managers.formation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.formation.MatiereRepository;
import com.empsi.dao.formation.SeanceRepository;
import com.empsi.entities.formation.Matiere;
import com.empsi.entities.formation.Seance;
import com.empsi.services.formation.ISeanceMetier;

@Service
public class SeanceMetierImpl implements ISeanceMetier{

	@Autowired
	SeanceRepository seanceRepository;
	
	@Autowired
	MatiereRepository matiereRepository;
	
	@Override
	public Seance get(Long id) {
		return seanceRepository.findOne(id);
	}

	@Override
	public List<Seance> getAll() {
		List<Seance> seances = seanceRepository.findAll();
		return seances;
	}

	@Override
	public Seance save(Seance seance) {
		seanceRepository.save(seance);
		return seance;
	}

	@Override
	public Seance update(Seance seance) {
		seanceRepository.saveAndFlush(seance);
		return seance;
	}

	@Override
	public boolean delete(Long id) {
		seanceRepository.delete(id);
		return true;
	}

	@Override
	public boolean addSeanceToMatiere(Long idSeance, Long idMatiere) {
		Seance seance = seanceRepository.findOne(idSeance);
		Matiere matiere = matiereRepository.findOne(idMatiere);
		
		seance.setMatiere(matiere);
		
		seanceRepository.saveAndFlush(seance);
		matiereRepository.saveAndFlush(matiere);
		
		return true;
	}
	
	public List<Seance>  seanceByMatiere(Long id)
	{
		System.out.println("l'id de matiere est ::::::::::"+id);
		List<Seance> seances = seanceRepository.seanceByMatiere(id);
		return seances;
	}

}

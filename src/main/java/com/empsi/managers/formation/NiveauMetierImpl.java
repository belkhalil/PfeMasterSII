package com.empsi.managers.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.formation.FormatinDiplomanteRepository;
import com.empsi.dao.formation.NiveauRepository;
import com.empsi.dao.formation.SemestreRepository;
import com.empsi.entities.formation.FormationDiplomante;
import com.empsi.entities.formation.Niveau;
import com.empsi.entities.formation.Semestre;
import com.empsi.services.formation.INiveauMetier;

@Service
public class NiveauMetierImpl implements INiveauMetier {

	@Autowired
	NiveauRepository niveauRepository;

	@Autowired
	SemestreRepository semestreRepository;

	@Autowired
	FormatinDiplomanteRepository formatinDiplomanteRepository;

	@Override
	public Niveau get(Long id) {
		return niveauRepository.findOne(id);
	}

	@Override
	public List<Niveau> getAll() {
		List<Niveau> niveaus = niveauRepository.findAll();
		return niveaus;
	}
   
	@Override
	public Niveau save(Niveau niveau) {
		niveauRepository.save(niveau);
		return niveau;
	}

	@Override
	public Niveau update(Niveau niveau) {
		niveauRepository.saveAndFlush(niveau);
		return niveau;
	}

	@Override
	public boolean delete(Long id) {
		
		niveauRepository.delete(id);
		
		return true;
	}

	@Override
	public boolean addFormationToNiveau(Long idFormation, Long idNiveau) {
		FormationDiplomante formation = formatinDiplomanteRepository.findOne(idFormation);
		Niveau niveau = niveauRepository.findOne(idNiveau);
		niveau.getFormations().add(formation);
		//formation.getNiveaux().add(niveau);
		
		niveauRepository.saveAndFlush(niveau);
		formatinDiplomanteRepository.saveAndFlush(formation);
		return true;
	}

	

	@Override
	public boolean removeFormationFromNiveau(Long idFormation, Long idNiveau) {
		FormationDiplomante formation = formatinDiplomanteRepository.findOne(idFormation);
		Niveau niveau = niveauRepository.findOne(idNiveau);
		niveau.getFormations().remove(formation);
		//formation.setNiveau(niveau);
		
		niveauRepository.saveAndFlush(niveau);
		formatinDiplomanteRepository.saveAndFlush(formation);
		return true;
	}

	

}

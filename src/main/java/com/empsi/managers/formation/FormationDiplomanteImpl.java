package com.empsi.managers.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.formation.FormatinDiplomanteRepository;
import com.empsi.dao.formation.TypeFormationRepository;
import com.empsi.entities.formation.Formation;
import com.empsi.entities.formation.FormationDiplomante;
import com.empsi.entities.formation.TypeFormaton;
import com.empsi.services.formation.IFormationDiplomanteMetier;

@Service
public class FormationDiplomanteImpl implements IFormationDiplomanteMetier {

	@Autowired
	FormatinDiplomanteRepository formatinDiplomanteRepository;
	@Autowired
	TypeFormationRepository typeFormationRepository;
	
	@Override
	public FormationDiplomante get(Long id) {
	return	formatinDiplomanteRepository.findOne(id);
	}

	@Override
	public List<FormationDiplomante> getAll() {
		List<FormationDiplomante> formationDiplomantes=formatinDiplomanteRepository.findAll();
		return formationDiplomantes;
	}

	@Override
	public FormationDiplomante save(FormationDiplomante formation) {
		return formatinDiplomanteRepository.save(formation);
	}

	@Override
	public FormationDiplomante update(FormationDiplomante formation) {
		return formatinDiplomanteRepository.saveAndFlush(formation);
	}

	@Override
	public boolean delete(Long id) {
		formatinDiplomanteRepository.delete(id);
		return true;
	}

	@Override
	public boolean addTypeToFormation(Long idT, Long idF) {
		TypeFormaton typef= typeFormationRepository.findOne(idT);
		FormationDiplomante formation = formatinDiplomanteRepository.findOne(idF);
        
		
		formation.getTypeFormations().add(typef);
		//typef.setFormation(formation);
		
		formatinDiplomanteRepository.saveAndFlush(formation);
		typeFormationRepository.saveAndFlush(typef);
		return true;
	}

	@Override
	public boolean updateTypeOfFormation(Long idoldT,Long idnewT, Long idF) {
		TypeFormaton typef= typeFormationRepository.findOne(idnewT);
		FormationDiplomante formation = formatinDiplomanteRepository.findOne(idF);
        
		
		for (int i=0; i< formation.getTypeFormations().size(); i++)
		{
			List<TypeFormaton> typs = formation.getTypeFormations();
			
			if(typs.get(i).getIdTypeFormation() == idoldT)
			{
				typs.set(i, typef);
			}
			typs.add(typef);
		
		}
		
		return true;
	}

}

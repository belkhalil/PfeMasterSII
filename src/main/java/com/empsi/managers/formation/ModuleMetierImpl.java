package com.empsi.managers.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.formation.MatiereRepository;
import com.empsi.dao.formation.ModuleRepository;
import com.empsi.dao.formation.SemestreRepository;
import com.empsi.entities.formation.Matiere;
import com.empsi.entities.formation.Module;
import com.empsi.entities.formation.Seance;
import com.empsi.entities.formation.Semestre;
import com.empsi.services.formation.IModuleMetier;

@Service
public class ModuleMetierImpl implements IModuleMetier {

	@Autowired
	ModuleRepository moduleRepository;

	@Autowired
	SemestreRepository semestreRepository;
	
	@Autowired
	MatiereRepository matiereRepository;

	@Override
	public Module save(Module m) {
			moduleRepository.save(m);
			return m;
	}

	@Override
	public Module get(Long id) {
		Module module = moduleRepository.findOne(id);
		if (module == null) {
			return null;
		} else {
			return module;
		}

	}

	@Override
	public Module Update(Module module) {
		Module m = moduleRepository.findOne(module.getIdModule());
		if (m == null) {
			return null;
		} else {
			moduleRepository.saveAndFlush(module);
			return module;
		}
	}

	@Override
	public List<Module> getAll() {
		List<Module> modules = moduleRepository.findAll();
		return modules;
	}

	@Override
	public Boolean delete(Long id) {
		moduleRepository.delete(id);
		return true;
	}

	@Override
	public boolean addModuleToSemestre(Long idModule, Long idSemestre) {
		Module m = moduleRepository.findOne(idModule);
		Semestre s = semestreRepository.findOne(idSemestre);
        
	    s.getModules().add(m);
		m.getSemestres().add(s);
		moduleRepository.saveAndFlush(m);
		semestreRepository.saveAndFlush(s);
		return true;
	}

	@Override
	public boolean removeModuleFromSemestre(Long idModule, Long idSemestre) {
		Module m = moduleRepository.findOne(idModule);
		Semestre s = semestreRepository.findOne(idSemestre);
		
		m.getSemestres().remove(s);
		
		moduleRepository.saveAndFlush(m);
		
		semestreRepository.saveAndFlush(s);
		return true;
	}

	@Override
	public boolean addMatierToModule(Long idMatiere, Long idModule) {
		Module module = moduleRepository.findOne(idModule);
		Matiere matiere = matiereRepository.findOne(idMatiere);
		
		matiere.setModule(module);
		
		
		moduleRepository.saveAndFlush(module);
		matiereRepository.saveAndFlush(matiere);
		return true;
	}

	@Override
	public boolean removeMatierFromModule(Long idMatiere, Long idModule) {
		Module module = moduleRepository.findOne(idModule);
		Matiere matiere = matiereRepository.findOne(idMatiere);
		
		moduleRepository.saveAndFlush(module);
		matiereRepository.saveAndFlush(matiere);
		return true;
	}
	
//	public List<Module> moduleBySemestre(Long id)
//	{
//	List<Module> modules =  moduleRepository.moduleBySemestre(id);
//	return modules;
//	}

}

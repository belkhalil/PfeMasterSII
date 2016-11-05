package com.empsi.services.formation;

import java.util.List;

import com.empsi.entities.formation.Module;

public interface IModuleMetier {

	public Module save(Module m);
	public Module get(Long id);
	public Module Update(Module module );
	public List<Module> getAll();
	public Boolean delete(Long id);
	public boolean addModuleToSemestre(Long idModule,Long idSemestre);
	public boolean removeModuleFromSemestre(Long idModule, Long idSemestre);
	public boolean addMatierToModule(Long idMatiere, Long idModule);
	public boolean removeMatierFromModule(Long idMatiere, Long idModule);
}

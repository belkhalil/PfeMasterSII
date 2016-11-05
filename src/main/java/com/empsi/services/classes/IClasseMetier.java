package com.empsi.services.classes;

import java.util.List;

import com.empsi.entities.classes.Classe;

public interface IClasseMetier {
	public Classe getClasse(Long id);
	public List<Classe> getAll();
	public Classe saveClasse(Classe cl);
	public Classe updateClasse(Classe cl);
	public boolean deleteClasse(Long id);
	//public boolean deleteMessages(Long id);
	
}

package com.empsi.services.formation;

import java.util.List;


import com.empsi.entities.formation.Semestre;

public interface ISemestreMetier {
	public Semestre getSemestre(Long id);
	public List<Semestre> getAll();
	public Semestre saveSemestre(Semestre Se);
	public Semestre updateSemestre(Semestre Se);
	public boolean deleteSemestre(Long id);
	public Boolean addSemestreToNiveau(Long idSemestre,Long idNiveau) ;
	public Boolean removeSemestreFromNiveau(Long idSemestre,Long idNiveau) ;
	

}

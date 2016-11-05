package com.empsi.dao.formation;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.empsi.entities.formation.Module;

public interface ModuleRepository extends JpaRepository<Module, Long>{

	

//	@Query("select m from Module m where m.Semestres.idSemestre = :id ")
//	public List<Module> moduleBySemestre(@Param("id") Long id);
	 
	
	
}

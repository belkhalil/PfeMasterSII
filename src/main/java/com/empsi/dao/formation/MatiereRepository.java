package com.empsi.dao.formation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.empsi.entities.formation.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere, Long>{
	
	
	@Query("select m from Matiere m where m.module.idModule = :id ")
	public List<Matiere> matiereByModule(@Param("id") Long id);
}

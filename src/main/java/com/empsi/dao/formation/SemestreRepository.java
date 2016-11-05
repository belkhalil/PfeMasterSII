package com.empsi.dao.formation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empsi.entities.formation.Semestre;

public interface SemestreRepository extends JpaRepository<Semestre, Long>{	
	

	@Query("select s from Semestre s where s.niveau.idNiveau = :id ")
	public List<Semestre> semestresByNiveau(@Param("id") Long id);
	 
	
}

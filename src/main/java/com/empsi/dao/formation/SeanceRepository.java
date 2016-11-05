package com.empsi.dao.formation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.empsi.entities.formation.Seance;

public interface SeanceRepository extends JpaRepository<Seance, Long>{

	
	@Query("select s from Seance s where s.matiere.idMatiere = :id ")
	public List<Seance> seanceByMatiere(@Param("id") Long id);
}

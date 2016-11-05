package com.empsi.dao.formation;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empsi.entities.formation.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long>{

}

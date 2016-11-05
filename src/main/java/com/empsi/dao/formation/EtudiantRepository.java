package com.empsi.dao.formation;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empsi.entities.users.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{

}

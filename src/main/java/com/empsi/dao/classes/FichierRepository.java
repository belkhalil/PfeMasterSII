package com.empsi.dao.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empsi.entities.classes.Fichier;

public interface FichierRepository extends JpaRepository<Fichier, Long> {
	
	@Query("select f from Fichier f where f.enseignant.firstName=:x")
	public Fichier findFichierbyUser(@Param("x") String nom);

	/*@Query("select f from Fichier f where f.classe=:x")
	public Fichier findFichierByClasse(@Param("x") Long id);*/
	

}


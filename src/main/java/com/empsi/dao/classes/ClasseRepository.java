package com.empsi.dao.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import com.empsi.entities.classes.Classe;
public interface ClasseRepository extends JpaRepository<Classe, Long>{
	/*@Transactional	
	 @Query("SELECT c FROM Classe c LEFT JOIN classe_etudiant AS cle ON cle.idClasse = c.idClasse WHERE cl.idEtudiant = :id ")
	List<Classe> findById(@Param("id") Long id);*/

}

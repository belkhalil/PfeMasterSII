package com.empsi.dao.classes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.empsi.entities.classes.MessageClasse;

public interface MessageClasseRepository extends JpaRepository<MessageClasse, Long>{
	@Transactional	
	 @Query("SELECT m FROM MessageClasse m WHERE m.classe.idClasse = :id ")
	List<MessageClasse> findByClasse(@Param("id") Long id);
}

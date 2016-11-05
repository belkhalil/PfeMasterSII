package com.empsi.dao.messages;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.empsi.entities.messages.Declaration;

public interface DeclarationRepository extends JpaRepository<Declaration, Long>{

	@Transactional	
    @Query("SELECT d FROM Declaration d WHERE d.user.id= :id ")
	List<Declaration> findByUserId(@Param("id") Long id);
	
}

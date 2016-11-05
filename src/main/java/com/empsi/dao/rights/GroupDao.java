package com.empsi.dao.rights;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empsi.entities.rights.Group;


@Repository
public interface GroupDao extends JpaRepository<Group, Long> {

//	 @Transactional	
//	 @Query("SELECT g FROM Group g WHERE (:user) IN g.users ")
//	 List<Group> findUserGroups(@Param("user") User user );
	 //@Query("SELECT g FROM Group g WHERE exists (SELECT u FROM User u WHERE (u.id = :idUser AND u in g.users))")
//	 exists
}
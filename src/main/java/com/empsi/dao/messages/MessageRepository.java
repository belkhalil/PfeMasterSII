package com.empsi.dao.messages;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.empsi.entities.messages.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

     @Transactional	
	 @Query("SELECT m FROM Message m WHERE m.user2.id = :id ")
	 List<Message> ReceivedMessage(@Param("id") Long id );
   	
   	@Transactional	
	 @Query("SELECT m FROM Message m WHERE m.user.id = :id ")
	List<Message> sendedMessage(@Param("id") Long id);
}

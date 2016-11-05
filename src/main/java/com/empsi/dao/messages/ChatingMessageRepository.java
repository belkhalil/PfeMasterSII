package com.empsi.dao.messages;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.empsi.entities.messages.ChatingMessage;

public interface ChatingMessageRepository extends JpaRepository<ChatingMessage, Long> {

	@Transactional	
    @Query("SELECT c FROM ChatingMessage c WHERE (c.idSender=:idSender and c.idReceiver= :idReceiver) or (c.idSender=:idReceiver and c.idReceiver= :idSender)")
	public List<ChatingMessage> findChatingMessageByIdSenderIdReceiverr(@Param("idSender") Long idSender,@Param("idReceiver") Long idReceiver);
	
	
}

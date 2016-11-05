package com.empsi.services.messages;

import java.util.List;

import com.empsi.entities.messages.ChatingMessage;

public interface ChatingMessageService {

	public Boolean addMessage(ChatingMessage message);
	public Boolean deleteMessage(Long id);
	public List<ChatingMessage> findChatingMessageByIdSenderIdReceiverr(Long idSender,Long idReceiver);
	
}

package com.empsi.managers.messages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.messages.ChatingMessageRepository;
import com.empsi.entities.messages.ChatingMessage;
import com.empsi.services.messages.ChatingMessageService;

@Service
public class ChatingMessageManager implements ChatingMessageService{

	@Autowired
	private ChatingMessageRepository chatingMessageRepository ;
	
	@Override
	public Boolean addMessage(ChatingMessage message) {
		
		chatingMessageRepository.saveAndFlush(message);
		return true;
	}

	@Override
	public Boolean deleteMessage(Long id) {
		chatingMessageRepository.delete(id);
		return true;
	}

	@Override
	public List<ChatingMessage> findChatingMessageByIdSenderIdReceiverr(Long idSender, Long idReceiver) {
		return chatingMessageRepository.findChatingMessageByIdSenderIdReceiverr(idSender, idReceiver);
	}

	

	
	
	
	
}

package com.empsi.managers.messages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.messages.MessageRepository;
import com.empsi.entities.messages.Message;
import com.empsi.services.messages.IMessageMetier;


@Service
public class MessageMetierImpl implements IMessageMetier{

	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	public Message get(Long id) {
		// TODO Auto-generated method stub
		return messageRepository.findOne(id);
	}

	@Override
	public List<Message> getAll() {
		// TODO Auto-generated method stub
		return messageRepository.findAll();
	}

	@Override
	public Message save(Message msg) {
		// TODO Auto-generated method stub
		return messageRepository.save(msg);
	}

	@Override
	public Message update(Message msg) {
		// TODO Auto-generated method stub
		return messageRepository.saveAndFlush(msg);
	}

	@Override
	public boolean delete(Long id) {
		if(messageRepository.getOne(id) != null)
			messageRepository.delete(id);
		else
			return false;
		return true;
	}

	@Override
	public List<Message> receivedMessage(Long id) {
		// TODO Auto-generated method stub
		return messageRepository.ReceivedMessage(id);
	}

	@Override
	public List<Message> sendedMessage(Long id) {
		// TODO Auto-generated method stub
		return messageRepository.sendedMessage(id);
	}

}

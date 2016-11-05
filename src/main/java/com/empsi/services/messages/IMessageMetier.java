package com.empsi.services.messages;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empsi.entities.messages.Message;

@Service
public interface IMessageMetier {

	public Message get(Long id);
	public List<Message> getAll();
	public Message save(Message msg);
	public Message update(Message msg);
	public boolean delete(Long id);
	public List<Message> receivedMessage(Long id);
	public List<Message> sendedMessage(Long id);
	
}

package com.empsi.managers.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.classes.MessageClasseRepository;
import com.empsi.entities.classes.MessageClasse;
import com.empsi.services.classes.IMessageClasseMetier;
@Service
public class MessageClasseMetierImpl implements IMessageClasseMetier{

	@Autowired
	private MessageClasseRepository messageClasse;
	
	@Override
	public MessageClasse save(MessageClasse c) {
		// TODO Auto-generated method stub
		return messageClasse.save(c);
	}

	@Override
	public MessageClasse get(Long id) {
		// TODO Auto-generated method stub
		return messageClasse.getOne(id);
	}

	@Override
	public MessageClasse Update(MessageClasse c) {
		// TODO Auto-generated method stub
		return messageClasse.saveAndFlush(c);
	}

	@Override
	public List<MessageClasse> getAll() {
		// TODO Auto-generated method stub
		return messageClasse.findAll();
	}

	@Override
	public Boolean delete(Long id) {
		if(messageClasse.getOne(id) != null)
			messageClasse.delete(id);
		else
			return false;
		return true;
	}

	@Override
	public List<MessageClasse> findByClasse(Long idClasse) {
		// TODO Auto-generated method stub
		return messageClasse.findByClasse(idClasse);
	}

	
}

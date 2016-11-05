package com.empsi.services.classes;

import java.util.List;

import com.empsi.entities.classes.MessageClasse;

public interface IMessageClasseMetier {

	public MessageClasse save(MessageClasse c);
	public MessageClasse get(Long id);
	public MessageClasse Update(MessageClasse c );
	public List<MessageClasse> getAll();
	public Boolean delete(Long id);
	public List<MessageClasse> findByClasse(Long idClasse);
}

package com.empsi.managers.messages;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.messages.DeclarationRepository;
import com.empsi.entities.messages.Declaration;
import com.empsi.services.messages.IDeclarationMetier;
@Service
public class DeclarationMetierImpl implements IDeclarationMetier {
	
	@Autowired
	private DeclarationRepository declarationRepos;
	
	@Override
	public Declaration get(Long id) {
		return declarationRepos.findOne(id);
	}

	@Override
	public List<Declaration> getAll() {
		return declarationRepos.findAll();
	}

	@Override
	public Declaration save(Declaration dec) {
		return declarationRepos.save(dec);
	}

	@Override
	public Declaration update(Declaration dec) {
		return declarationRepos.saveAndFlush(dec);
	}

	@Override
	public boolean delete(Long id) {
		if(declarationRepos.getOne(id) != null)
			declarationRepos.delete(id);
		else
			return false;
		return true;
	}
	@Override
	public List<Declaration> declarations(Long id) {
		return declarationRepos.findByUserId(id);
	}
}

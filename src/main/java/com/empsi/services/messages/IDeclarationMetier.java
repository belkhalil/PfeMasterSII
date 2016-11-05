package com.empsi.services.messages;

import java.util.List;

import com.empsi.entities.messages.Declaration;

public interface IDeclarationMetier {
	public Declaration get(Long id);
	public List<Declaration> getAll();
	public Declaration save(Declaration dec);
	public Declaration update(Declaration dec);
	public boolean delete(Long id);
	List<Declaration> declarations(Long id);
	
}

package com.empsi.services.all;

import java.util.List;

import com.empsi.entities.all.Document;

public interface IDocumentMetier {

	public Document get(Long id);
	public List<Document> getAll();
	public Document save(Document d);
	public Document update(Document d);
	public Document delete(Long id);
}

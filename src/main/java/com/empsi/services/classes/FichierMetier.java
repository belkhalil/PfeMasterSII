package com.empsi.services.classes;

import java.util.List;

import com.empsi.entities.classes.Fichier;

public interface FichierMetier {

	public Fichier save(Fichier c);
	public Fichier update(Fichier c);
	public Fichier getOne(Long idFichier);
	public List<Fichier> consulterFichier();
	public Fichier getFichierUser(String username);

}

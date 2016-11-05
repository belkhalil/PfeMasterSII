package com.empsi.managers.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.classes.FichierRepository;
import com.empsi.entities.classes.Fichier;
import com.empsi.services.classes.FichierMetier;

@Service
public class FichierMetierImpl implements FichierMetier {
	
	@Autowired
	private FichierRepository fichierRepository;
	
	@Override
	public Fichier save(Fichier f) {
		// TODO Auto-generated method stub
		return fichierRepository.save(f);
	}

	@Override
	public Fichier getOne(Long idFichier) {
		// TODO Auto-generated method stub
		return fichierRepository.findOne(idFichier);
	}

	@Override
	public List<Fichier> consulterFichier() {
		// TODO Auto-generated method stub
		return fichierRepository.findAll();
	}

	@Override
	public Fichier update(Fichier f) {
		// TODO Auto-generated method stub
		return fichierRepository.saveAndFlush(f);
	}

	@Override
	public Fichier getFichierUser(String username) {
		// TODO Auto-generated method stub
		return fichierRepository.findFichierbyUser(username);
	}

}

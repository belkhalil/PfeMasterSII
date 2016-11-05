package com.empsi.managers.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.empsi.dao.formation.EtudiantRepository;
import com.empsi.entities.users.Etudiant;
import com.empsi.services.formation.IEtudiantMetier;

@Service
public class EtudiantMetierImpl implements IEtudiantMetier {

	@Autowired
	private EtudiantRepository etudiantRepository;
	
	/**
	 * add student 
	 * @param e
	 * @return
	 */
	public Etudiant save(Etudiant e){
		etudiantRepository.saveAndFlush(e);
		return e;
	}
	
	/**
	 * get student by id
	 * @param id
	 * @return
	 */
	public Etudiant get(Long id)
	{
		return etudiantRepository.findOne(id);
	}
	
	/**
	 * update student'data 
	 * @param Student
	 * @return
	 */
	public Etudiant Update(Etudiant Student )
	{
		etudiantRepository.saveAndFlush(Student);
		return Student;
		
	}
	
	/**
	 * get all student 
	 */
	public List<Etudiant> getAll()
	{
		List<Etudiant> etudiants=etudiantRepository.findAll();
		return etudiants;
	}
	
	/**
	 * delete Student
	 * @param id
	 * @return
	 */
	public Boolean delete(Long id)
	{
		
		etudiantRepository.delete(id);
		return true;
				
	}
}

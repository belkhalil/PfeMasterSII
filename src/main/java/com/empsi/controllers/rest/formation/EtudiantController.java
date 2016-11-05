package com.empsi.controllers.rest.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.users.Etudiant;
import com.empsi.managers.formation.EtudiantMetierImpl;
import com.empsi.managers.rights.GroupManager;
import com.empsi.services.rights.GroupService;




@RestController
@RequestMapping("/formation")
public class EtudiantController {
	
@Autowired
 private EtudiantMetierImpl etudiantMetierImpl;

@Autowired
private GroupManager groupService;


@RequestMapping(value="/save", method = RequestMethod.POST)
public Etudiant addStudent(@RequestBody Etudiant e)
{
	etudiantMetierImpl.save(e);
	System.out.println("etudiant id : "+e.getId());
	groupService.addUserToEtudiant(e.getId());
	return e; 
	
	}
/**
 * 
 * @param id
 * @return
 */
@RequestMapping(value ="/getOneStudent/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public Etudiant getEtudiant(@PathVariable("id") Long id)
{
	if(etudiantMetierImpl.get(id)!= null)
	return etudiantMetierImpl.get(id);
	else return null;
	}

/**
 * 
 * @return
 */
@RequestMapping(value="/students",method = RequestMethod.GET)
public List<Etudiant> getAllstudent()
{
	
	return etudiantMetierImpl.getAll();
	}
/**
 * 
 * @param id
 * @return
 */
@RequestMapping(value="/deleteStudent/{id}",method = RequestMethod.DELETE)
public boolean deleteEtudiant(@PathVariable("id") Long id)
{ 
     etudiantMetierImpl.delete(id);
     return true;
}

@RequestMapping(value="/updateStudent/{id}" ,method = RequestMethod.PUT)
public Etudiant updateStudent(@PathVariable("id") Long id,@RequestBody Etudiant e)
{
	etudiantMetierImpl.Update(e);
	return e;
	}
 
}

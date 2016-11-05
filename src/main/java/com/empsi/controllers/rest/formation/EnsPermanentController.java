package com.empsi.controllers.rest.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.formation.EnsPermanent;
import com.empsi.managers.formation.EnsPermanentMetierImpl;
import com.empsi.managers.rights.GroupManager;

@RestController
@RequestMapping("/formation")
public class EnsPermanentController {

	@Autowired
	private EnsPermanentMetierImpl ensPermanentMetierImpl;
	
	@Autowired
	private GroupManager groupService;
	
   /**
    * 
    * @return
    */
	@RequestMapping(value = "/ensPermanents", method = RequestMethod.GET)
	public List<EnsPermanent> list() {
		return ensPermanentMetierImpl.getAll();
		}
	
		
   /**
    * 
    * @param e
    * @return
    */
	@RequestMapping(value="/saveEnsp", method = RequestMethod.POST)
	public EnsPermanent addensP(@RequestBody EnsPermanent e)
	{
		ensPermanentMetierImpl.save(e);
		System.out.println("Enseignant permanant  id : "+e.getId());
        groupService.addUserToEnseignantPermanent(e.getId());
		return e; 
	
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value ="/getOneEnsp/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public EnsPermanent getEnsP(@PathVariable("id") Long id)
	{
		if(ensPermanentMetierImpl.get(id)!= null)
		return ensPermanentMetierImpl.get(id);
		else 
			return null;
		}

	
	/**
	 * 
	 * @param id
	 * @return
	 */
	
	@RequestMapping(value="/deleteEnsP/{id}",method = RequestMethod.DELETE)
	public boolean deleteEnsP(@PathVariable("id") Long id)
	{ 
	     ensPermanentMetierImpl.delete(id);
	     return true;
	}
    
	/**
	 * 
	 * @param id
	 * @param ens
	 * @return
	 */
	@RequestMapping(value="/updateEnsP/{id}" ,method = RequestMethod.PUT)
	public EnsPermanent updateEnsP(@PathVariable("id") Long id,@RequestBody EnsPermanent ens)
	{
		ensPermanentMetierImpl.update(ens);
		return ens;
		}
	 
	/**
	 * 
	 * @param idM
	 * @param idE
	 * @return
	 */
	@RequestMapping(value="/affecterMatiereToEnsP/" ,method = RequestMethod.POST)
	public ResponseEntity<EnsPermanent> addTypeToFormation(@RequestParam(value="idm") Long idM ,@RequestParam(value="ide") Long idE)
	{
		ensPermanentMetierImpl.affecterMatiereToEnsP(idM, idE);
		return new ResponseEntity<EnsPermanent>(HttpStatus.OK);
	}
}

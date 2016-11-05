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

import com.empsi.entities.formation.Matiere;
import com.empsi.entities.formation.Seance;
import com.empsi.managers.formation.SeanceMetierImpl;

@RestController
@RequestMapping("/formation")
public class SeanceController {

	@Autowired
	private SeanceMetierImpl seanceMetierImpl;
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	@RequestMapping(value="/saveSeance", method = RequestMethod.POST)
	public ResponseEntity<Seance> addSeance(@RequestBody Seance s)
	{
		seanceMetierImpl.save(s);
		return new ResponseEntity<Seance>(s,HttpStatus.CREATED);
		
		}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value ="/getOneSeance/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Seance> getSeance(@PathVariable("id") Long id)
	{ 
		Seance seance = seanceMetierImpl.get(id);
		if(seance == null)
		{
			return new ResponseEntity<Seance>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Seance>(seance, HttpStatus.OK);
		}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/Seances",method = RequestMethod.GET)
	public ResponseEntity<List<Seance>>  getAllSeances()
	{
		List<Seance> seances= seanceMetierImpl.getAll();
		if(seances.isEmpty())
		{
			return new ResponseEntity<List<Seance>>(HttpStatus.NO_CONTENT);	
		}
		return new ResponseEntity<List<Seance>>(seances, HttpStatus.OK);		}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/deleteSeance/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Seance> deleteSeance(@PathVariable("id") Long id)
	{ 
		Seance seance =seanceMetierImpl.get(id);
		if(seance==null)
		{
			return new ResponseEntity<Seance>(HttpStatus.NOT_FOUND);	
		}
	     seanceMetierImpl.delete(id);
	     return new ResponseEntity<Seance>(HttpStatus.OK);
	}
/**
 * 
 * @param id
 * @param n
 * @return
 */
	@RequestMapping(value="/updateSeance/{id}" ,method = RequestMethod.PUT)
	public ResponseEntity<Seance> updateSeance(@PathVariable("id") Long id,@RequestBody Seance s)
	{
		seanceMetierImpl.update(s);
		return new ResponseEntity<Seance>(HttpStatus.OK);
		}
		/**
		 * 
		 * @param idN
		 * @param idF
		 * @return
		 */
	@RequestMapping(value="/addSeanceToMatiere" ,method = RequestMethod.POST)
	public ResponseEntity<Seance> addSeanceToMatiere(@RequestParam(value="ids") Long idS ,@RequestParam(value="idm") Long idM)
	{
		seanceMetierImpl.addSeanceToMatiere(idS, idM);
		return new ResponseEntity<Seance>(HttpStatus.OK);
		
	}
	/**
	 * 
	 * @param idN
	 * @param idF
	 * @return
	 */
	@RequestMapping(value="/removeSeanceFromMatiere" ,method = RequestMethod.DELETE)
	public ResponseEntity<Seance> removeSeanceFromMatiere(@RequestParam(value="ids") Long idN ,@RequestParam(value="idm") Long idM)
	{
		
		return new ResponseEntity<Seance>(HttpStatus.OK);
	}
	 /**
	  * 
	  * @param id
	  * @return
	  */
	@RequestMapping(value = "/seancesByMatiere/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Seance>>  seanceByMatiere(@PathVariable("id") Long id) {
		List<Seance> seances = seanceMetierImpl.seanceByMatiere(id);
		if(seances.isEmpty())
		{
			return new ResponseEntity<List<Seance>>(HttpStatus.NO_CONTENT);
			//return null;
		}
		return new ResponseEntity<List<Seance>>(seances, HttpStatus.OK);
		//System.out.println(matieres.size());
		//return matieres;
	}
	
	
	 
	
}

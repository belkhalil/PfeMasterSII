package com.empsi.controllers.rest.initialisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.services.rights.GroupService;

//http://localhost:8080/init_group_right/init
@RestController
@RequestMapping("/init_group_right")
public class InitRelationGroupRight {

	
	@Autowired
	private GroupService  groupService;
	
	
	//admin
	@RequestMapping(value = "/init1", method = RequestMethod.GET)
	public ResponseEntity<String> initAdminFunction(){
		
		//gestion des droits d'accès
		groupService.addRightToGroup(1L, 1L);
		groupService.addRightToGroup(2L, 1L);
		groupService.addRightToGroup(3L, 1L);
		
		/** gestion des inscription*/
		groupService.addRightToGroup(4L, 1L);
		
		//messages 5 >> 7
		//Nouveau message
		groupService.addRightToGroup(5L, 1L);
		
		//Messages envoyees
		groupService.addRightToGroup(6L, 1L);
		
		//Messages Recus
		groupService.addRightToGroup(7L, 1L);
		
		/** Declaration */
		//gestion declaration
		groupService.addRightToGroup(32L, 1L);
		
		/** discussion */
		//discussion instantanée
		
		groupService.addRightToGroup(28L, 1L);
		
		/** formation*/
		groupService.addRightToGroup(16L, 1L);
		groupService.addRightToGroup(17L, 1L);
		groupService.addRightToGroup(18L, 1L);
		groupService.addRightToGroup(19L, 1L);
		groupService.addRightToGroup(20L, 1L);
		groupService.addRightToGroup(21L, 1L);
		groupService.addRightToGroup(22L, 1L);
		groupService.addRightToGroup(23L, 1L);
		groupService.addRightToGroup(24L, 1L);
		groupService.addRightToGroup(25L, 1L);
		groupService.addRightToGroup(26L, 1L);
		groupService.addRightToGroup(27L, 1L);
		
		/**  Gestion de patrimoine  */
		groupService.addRightToGroup(29L, 1L);
		groupService.addRightToGroup(30L, 1L);
		
		/** classe */
		//ajouter classe
		groupService.addRightToGroup(9L, 1L);
		
		//gestion etudiants/classes
		groupService.addRightToGroup(11L, 1L);
		
		//contacter classe
		groupService.addRightToGroup(12L, 1L);
		
		//publier Document
		groupService.addRightToGroup(14L, 1L);
		
		//les documents partages
		//groupService.addRightToGroup(15L, 1L);
		
		return new ResponseEntity<String>("init  ok",HttpStatus.OK);
	}
		//Etudiant
	@RequestMapping(value = "/init2", method = RequestMethod.GET)
	public ResponseEntity<String> initEtudiantFunction(){
		        //messages 5 >> 7
				//Nouveau message
				groupService.addRightToGroup(5L, 2L);
				
				//Messages envoyees
				groupService.addRightToGroup(6L, 2L);
				
				//Messages Recus
				groupService.addRightToGroup(7L, 2L);
				
				/** Declaration */
				//Declaration
				groupService.addRightToGroup(8L, 2L);
				
				/** discussion */
				//discussion instantanée
				groupService.addRightToGroup(28L, 2L);
				
				/** classe */
				// les documents partages
				groupService.addRightToGroup(15L, 2L);
				
				// message recus de ma classe 13
				groupService.addRightToGroup(13L, 2L);
				
				// ma classe
				groupService.addRightToGroup(10L, 2L);
				
				/** Declaration */
				//Declaration
				groupService.addRightToGroup(8L, 2L);
				
		return new ResponseEntity<String>("init  ok",HttpStatus.OK);
	}
	//Parent
	@RequestMapping(value = "/init3", method = RequestMethod.GET)
	public ResponseEntity<String> initParentFunction(){
		
		//messages 5 >> 7
		//Nouveau message
		groupService.addRightToGroup(5L, 6L);
		
		//Messages envoyees
		groupService.addRightToGroup(6L, 6L);
		
		//Messages Recus
		groupService.addRightToGroup(7L, 6L);
		
		/** Declaration */
		//Declaration
		groupService.addRightToGroup(8L, 6L);
		
		/** discussion */
		//discussion instantanée
		groupService.addRightToGroup(28L, 6L);
		
		/** classe */
		// les documents partages
		groupService.addRightToGroup(15L, 6L);
		
		// message recus de ma classe 13
		groupService.addRightToGroup(13L, 6L);
		
		// ma classe
		groupService.addRightToGroup(10L, 6L);
		
		/** Declaration */
		//Declaration
		groupService.addRightToGroup(8L, 6L);
		
		return new ResponseEntity<String>("init  ok",HttpStatus.OK);
	}
	
	//Enseignant Permanent
	@RequestMapping(value = "/init4", method = RequestMethod.GET)
	public ResponseEntity<String> initEnseignantPermanentFunction(){
		
		//messages 5 >> 7
		//Nouveau message
		groupService.addRightToGroup(5L, 3L);
		
		//Messages envoyees
		groupService.addRightToGroup(6L, 3L);
		
		//Messages Recus
		groupService.addRightToGroup(7L, 3L);
		
		/** Declaration */
		//Declaration
		groupService.addRightToGroup(8L, 3L);
		
		/** discussion */
		//discussion instantanée
		groupService.addRightToGroup(28L, 3L);
		
		/** classe */
		// les documents partages
		groupService.addRightToGroup(15L, 3L);
		
		// message recus de ma classe 13
		groupService.addRightToGroup(13L, 3L);
		
		// ma classe
		groupService.addRightToGroup(10L, 3L);
		
		//contacter classe
		groupService.addRightToGroup(12L, 3L);
		
		//publier Document
		groupService.addRightToGroup(14L, 3L);
		
		//les documents partages
		groupService.addRightToGroup(15L, 3L);
		
		/** Declaration */
		//Declaration
		groupService.addRightToGroup(8L, 3L);
		
		return new ResponseEntity<String>("init  ok",HttpStatus.OK);
	}
	//Enseignant vacataire
	@RequestMapping(value = "/init5", method = RequestMethod.GET)
	public ResponseEntity<String> initEnseignantVacataireFunction(){
		
		//messages 5 >> 7
		//Nouveau message
		groupService.addRightToGroup(5L, 4L);
		
		//Messages envoyees
		groupService.addRightToGroup(6L,4L);
		
		//Messages Recus
		groupService.addRightToGroup(7L, 4L);
		
		/** Declaration */
		//Declaration
		groupService.addRightToGroup(8L, 4L);
		
		/** discussion */
		//discussion instantanée
		groupService.addRightToGroup(28L, 4L);
		
		/** classe */
		// les documents partages
		groupService.addRightToGroup(15L, 4L);
		
		// message recus de ma classe 13
		groupService.addRightToGroup(13L, 4L);
		
		// ma classe
		groupService.addRightToGroup(10L, 4L);
		
		//contacter classe
		groupService.addRightToGroup(12L, 4L);
		
		//publier Document
		groupService.addRightToGroup(14L, 4L);
		
		//les documents partages
		groupService.addRightToGroup(15L, 4L);
		
		return new ResponseEntity<String>("init  ok",HttpStatus.OK);
	}

	@RequestMapping(value = "/init6", method = RequestMethod.GET)
	public ResponseEntity<String> initTempGroupFunction(){
		
		//messages 5 >> 7
		//Nouveau message
		groupService.addRightToGroup(5L, 5L);
		
		//Messages envoyees
		groupService.addRightToGroup(6L,5L);
		
		//Messages Recus
		groupService.addRightToGroup(7L, 5L);
		
		/** discussion */
		//discussion instantanée
		groupService.addRightToGroup(28L, 5L);
		
		/** gestion des inscription*/
		// inscrire a une formation 
		groupService.addRightToGroup(31L, 5L);
		
		/** Declaration */
		//Declaration
		groupService.addRightToGroup(8L, 5L);
		
		return new ResponseEntity<String>("init  ok",HttpStatus.OK);
	}
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public ResponseEntity<String> init(){
		initAdminFunction();
		initEtudiantFunction();
		initParentFunction();
		initEnseignantPermanentFunction();
		initEnseignantVacataireFunction();
		initTempGroupFunction();
		return new ResponseEntity<String>("init Group Right  ok",HttpStatus.OK);
	}
}

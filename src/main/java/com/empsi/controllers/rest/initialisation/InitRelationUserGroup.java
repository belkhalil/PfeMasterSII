package com.empsi.controllers.rest.initialisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.services.rights.GroupService;

//http://localhost:8080/init_user_group/init
@RestController
@RequestMapping("/init_user_group")
public class InitRelationUserGroup {
	
	@Autowired
	private GroupService  groupService;
	
	@RequestMapping(value = "/init1", method = RequestMethod.GET)
	public ResponseEntity<String> init2DatabaseFunction(){
		
		//admin
		groupService.addUserToGroup(1L, 1L);
		//etudiant
		groupService.addUserToGroup(2L, 2L);
		
		//enseignant permanent 
		groupService.addUserToGroup(4L, 3L);
		
		//enseignant vacataire 
		groupService.addUserToGroup(5L,4L);
		
		//parent 
		groupService.addUserToGroup(3L, 6L);
		
		return new ResponseEntity<String>("init  ok",HttpStatus.OK);
	}
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public ResponseEntity<String> init(){
	
		init2DatabaseFunction();
		return new ResponseEntity<String>("init Relation User Group ok",HttpStatus.OK);
	}
}

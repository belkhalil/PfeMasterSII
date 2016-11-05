package com.empsi.controllers.rest.initialisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.rights.Group;
import com.empsi.services.rights.GroupService;

//http://localhost:8080/init_group/init
@RestController
@RequestMapping("/init_group")
public class InitGroup {
	
	@Autowired
	private GroupService  groupService;
	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public ResponseEntity<String> init(){
		
		// id=1
		Group group1 =new Group();
		group1.setGroupName("Admin");
		group1.setDeletable(false);
		groupService.create(group1);
		
		// id=2
		Group group2 =new Group();
		group2.setGroupName("etudiant");
		group2.setDeletable(false);
		groupService.create(group2);
		
		// id=3
		Group group3 =new Group();
		group3.setGroupName("enseignant permanent");
		group3.setDeletable(false);
		groupService.create(group3);
		
		// id=4
		Group group4 =new Group();
		group4.setGroupName("enseignant vacataire");
		group4.setDeletable(false);
		groupService.create(group4);
		
		// id=5
		Group group5 =new Group();
		group5.setGroupName("temporary group");
		group5.setDeletable(false);
		groupService.create(group5);
		
		// id=6
		Group group6 =new Group();
		group6.setGroupName("parent");
		group6.setDeletable(false);
		groupService.create(group6);
		 
		return new ResponseEntity<String>("init Group ok",HttpStatus.OK);
	}
	
}

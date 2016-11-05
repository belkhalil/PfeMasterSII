package com.empsi.controllers.rest.initialisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.rights.Group;
import com.empsi.entities.rights.Right;
import com.empsi.entities.rights.User;
import com.empsi.services.rights.GroupService;
import com.empsi.services.rights.RightService;
import com.empsi.services.rights.UserService;

@RestController
@RequestMapping("/initialisation")
public class Init {

	@Autowired
	private RightService rightService;

	@Autowired
	private UserService userService ;
	
	@Autowired
	private GroupService  groupService;
	
	 
	
	@RequestMapping(value = "/init2", method = RequestMethod.GET)
	public ResponseEntity<String> init2DatabaseFunction(){
	
		
		groupService.addRightToGroup(1L, 1L);
		groupService.addRightToGroup(2L, 1L);
		groupService.addRightToGroup(3L, 1L);
		groupService.addUserToGroup(1L, 1L);
		return new ResponseEntity<String>("init  ok",HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public ResponseEntity<String> initDatabaseFunction(){
		
		User user =new User();
		user.setFirstName("admin");
		user.setLastName("admin");
		user.setEmail("admin@email.com");
		user.setPassword("admin");
		userService.createUser(user);
		
		Right right1 =new Right();
		right1.setName(" les droirts ");
		right1.setCategory("gestion des droits d'accès");
		right1.setDeletable(false);
		right1.setDisc("one of the mean rights can't be deleted");
		rightService.createRight(right1);
		
		Right right2 =new Right();
		right2.setName(" les utilisateur ");
		right2.setCategory("gestion des droits d'accès");
		right2.setDeletable(false);
		right2.setDisc("one of the mean rights can't be deleted");
		rightService.createRight(right2);
		
		
		Right right3 =new Right();
		right3.setName(" les groupes ");
		right3.setCategory("gestion des droits d'accès");
		right3.setDeletable(false);
		right3.setDisc("one of the mean rights can't be deleted");
		rightService.createRight(right3);
		
		Group group1 =new Group();
		group1.setGroupName("Admin");
		group1.setDeletable(false);
		groupService.create(group1);
		
		Group group2 =new Group();
		group2.setGroupName("etudiant");
		group2.setDeletable(false);
		groupService.create(group2);
		
		Group group3 =new Group();
		group3.setGroupName("enseignant permanent");
		group3.setDeletable(false);
		groupService.create(group3);
		
		Group group4 =new Group();
		group4.setGroupName("enseignant vacataire");
		group4.setDeletable(false);
		groupService.create(group4);
		
		
		Group group5 =new Group();
		group5.setGroupName("temporary group");
		group5.setDeletable(false);
		groupService.create(group5);
		 
		return new ResponseEntity<String>("init  ok",HttpStatus.OK);
	}
	@RequestMapping(value = "/init3", method = RequestMethod.GET)
	public ResponseEntity<String> init3DatabaseFunction(){
		
		User user =new User();
		user.setFirstName("admin");
		user.setLastName("admin");
		user.setEmail("admin@email.com");
		user.setPassword("admin");
		userService.createUser(user);
		
		Right right1 =new Right();
		right1.setName(" les droirts ");
		right1.setCategory("gestion des droits d'accès");
		right1.setDeletable(false);
		right1.setDisc("one of the mean rights can't be deleted");
		rightService.createRight(right1);
		
		Right right2 =new Right();
		right2.setName(" les utilisateur ");
		right2.setCategory("gestion des droits d'accès");
		right2.setDeletable(false);
		right2.setDisc("one of the mean rights can't be deleted");
		rightService.createRight(right2);
		
		
		Right right3 =new Right();
		right3.setName(" les groupes ");
		right3.setCategory("gestion des droits d'accès");
		right3.setDeletable(false);
		right3.setDisc("one of the mean rights can't be deleted");
		rightService.createRight(right3);
		
		Group group1 =new Group();
		group1.setGroupName("Admin");
		group1.setDeletable(false);
		groupService.create(group1);
		
		Group group2 =new Group();
		group2.setGroupName("etudiant");
		group2.setDeletable(false);
		groupService.create(group2);
		
		Group group3 =new Group();
		group3.setGroupName("enseignant permanent");
		group3.setDeletable(false);
		groupService.create(group3);
		
		Group group4 =new Group();
		group4.setGroupName("enseignant vacataire");
		group4.setDeletable(false);
		groupService.create(group4);
		
		
		Group group5 =new Group();
		group5.setGroupName("temporary group");
		group5.setDeletable(false);
		groupService.create(group5);
		 
		return new ResponseEntity<String>("init  ok",HttpStatus.OK);
	}
	
}
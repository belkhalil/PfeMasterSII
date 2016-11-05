package com.empsi.controllers.rest.initialisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.rights.User;
import com.empsi.services.rights.UserService;

//http://localhost:8080/init_user/init

@RestController
@RequestMapping("/init_user")
public class InitUser {

	@Autowired
	private UserService userService ;
	 
	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public ResponseEntity<String> initUsersFunction(){
		
		//id=1
		User admin =new User();
		admin.setFirstName("admin");
		admin.setLastName("admin");
		admin.setEmail("admin@email.com");
		admin.setPassword("admin");
		userService.createUser(admin);
		
		//id=2
		User etudiant =new User();
		etudiant.setFirstName("etudiant");
		etudiant.setLastName("etudiant");
		etudiant.setEmail("etudiant@email.com");
		etudiant.setPassword("etudiant");
		userService.createUser(etudiant);
		
		//id=3
		User parent =new User();
		parent.setFirstName("parent");
		parent.setLastName("parent");
		parent.setEmail("parent@email.com");
		parent.setPassword("parent");
		userService.createUser(parent);
		
		//id=4
		User enseignantP =new User();
		enseignantP.setFirstName("enseignantP");
		enseignantP.setLastName("enseignantP");
		enseignantP.setEmail("enseignantP@email.com");
		enseignantP.setPassword("enseignantP");
		userService.createUser(enseignantP);
		
		//id=5
		User enseignantV =new User();
		enseignantV.setFirstName("enseignantV");
		enseignantV.setLastName("enseignantV");
		enseignantV.setEmail("enseignantV@email.com");
		enseignantV.setPassword("enseignantV");
		userService.createUser(enseignantV);
		
		 
		return new ResponseEntity<String>("init User ok",HttpStatus.OK);
	}
	
}

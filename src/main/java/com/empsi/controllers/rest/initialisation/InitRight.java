package com.empsi.controllers.rest.initialisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.rights.Group;
import com.empsi.entities.rights.Right;
import com.empsi.services.rights.RightService;

//http://localhost:8080/init_right/init
@RestController
@RequestMapping("/init_right")
public class InitRight {

	@Autowired
	private RightService rightService;

	
	@RequestMapping(value = "/init1", method = RequestMethod.GET)
	public ResponseEntity<String> initRightsModule1(){
		//gestion des droits d'accès
		// id=1
		Right right1 =new Right();
		right1.setName(" les droirts ");
		right1.setCategory("gestion des droits d'accès");
		right1.setDeletable(false);
		right1.setDisc("one of the mean rights can't be deleted");
		rightService.createRight(right1);
		
		//id=2
		Right right2 =new Right();
		right2.setName(" les utilisateur ");
		right2.setCategory("gestion des droits d'accès");
		right2.setDeletable(false);
		right2.setDisc("one of the mean rights can't be deleted");
		rightService.createRight(right2);
		
		//id=3
		Right right3 =new Right();
		right3.setName(" les groupes ");
		right3.setCategory("gestion des droits d'accès");
		right3.setDeletable(false);
		right3.setDisc("one of the mean rights can't be deleted");
		rightService.createRight(right3);
		 
		return new ResponseEntity<String>("init Right ok",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/init2", method = RequestMethod.GET)
	public ResponseEntity<String> initRightsModule2(){
		
		//gestion des inscription
		//id=4 
		Right right1 =new Right();
		right1.setName(" gestion comptes ");
		right1.setCategory("gestion des inscription");
		rightService.createRight(right1);
		
		//suite module 9 below 
		return new ResponseEntity<String>("init module 1 rights  ok",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/init3", method = RequestMethod.GET)
	public ResponseEntity<String> initRightsModule3(){
		
		//messages
		//id=5 
		Right right1 =new Right();
		right1.setName(" Nouveau message ");
		right1.setCategory("messages");
		rightService.createRight(right1);
		
		//id=6
		Right right2 =new Right();
		right2.setName(" Messages envoyees ");
		right2.setCategory("messages");
		rightService.createRight(right2);
		
		//id=7
		Right right3 =new Right();
		right3.setName(" Messages Recus ");
		right3.setCategory("messages");
		rightService.createRight(right3);
		 
		return new ResponseEntity<String>("init  ok",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/init4", method = RequestMethod.GET)
	public ResponseEntity<String> initRightsModule4(){
		
		//Declaration
		//id=8  
		Right right1 =new Right();
		right1.setName(" declaration ");
		right1.setCategory("Declaration");
		rightService.createRight(right1);
		
		//it's not complete 7dar 3winatak
		 
		return new ResponseEntity<String>("init  ok",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/init5", method = RequestMethod.GET)
	public ResponseEntity<String> initRightsModule5(){
		
		//classe
		//id=9
		Right right1 =new Right();
		right1.setName(" ajouter classe ");
		right1.setCategory("classe");
		rightService.createRight(right1);
		
		//id=10
		Right right2 =new Right();
		right2.setName(" ma classe ");
		right2.setCategory("classe");
		rightService.createRight(right2);
		
		//id=11
		Right right3 =new Right();
		right3.setName(" gestion etudiants/classes ");
		right3.setCategory("classe");
		rightService.createRight(right3);
		
		//id=12
		Right right4 =new Right();
		right4.setName(" contacter classe ");
		right4.setCategory("classe");
		rightService.createRight(right4);
		
		//id=13
		Right right5 =new Right();
		right5.setName(" message recus de ma classe ");
		right5.setCategory("classe");
		rightService.createRight(right5);
		
		//id=14
		Right right6 =new Right();
		right6.setName(" publier Document ");
		right6.setCategory("classe");
		rightService.createRight(right6);
		
		//id=15
		Right right7 =new Right();
		right7.setName(" les documents partages ");
		right7.setCategory("classe");
		rightService.createRight(right7);
		 
		return new ResponseEntity<String>("init  ok",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/init6", method = RequestMethod.GET)
	public ResponseEntity<String> initRightsModule6(){
		//formation
		//id=16
		Right right1 =new Right();
		right1.setName(" Enseignant Permanant ");
		right1.setCategory("formation");
		rightService.createRight(right1);
		//id=17
		Right right2 =new Right();
		right2.setName(" Enseingant Vacataire ");
		right2.setCategory("formation");
		rightService.createRight(right2);
		//id=18
		Right right3 =new Right();
		right3.setName(" Etudiant ");
		right3.setCategory("formation");
		rightService.createRight(right3);
	
		//id=19
		Right right4 =new Right();
		right4.setName(" Formtion Continue ");
		right4.setCategory("formation");
		rightService.createRight(right4);
	
		//id=20
		Right right5 =new Right();
		right5.setName(" Types de formation ");
		right5.setCategory("formation");
		rightService.createRight(right5);
		
		//id=21
		Right right6 =new Right();
		right6.setName(" Formtion Diplomante ");
		right6.setCategory("formation");
		rightService.createRight(right6);
		
		//id=22
		Right right7 =new Right();
		right7.setName(" Niveaux ");
		right7.setCategory("formation");
		rightService.createRight(right7);
		
		//id=23
		Right right8 =new Right();
		right8.setName(" Semestre ");
		right8.setCategory("formation");
		rightService.createRight(right8);
		
		//id=24
		Right right9 =new Right();
		right9.setName(" Module ");
		right9.setCategory("formation");
		rightService.createRight(right9);
		
		//id=25
		Right right10 =new Right();
		right10.setName(" Matieres ");
		right10.setCategory("formation");
		rightService.createRight(right10);
		
		//id=26
		Right right11 =new Right();
		right11.setName(" Seances ");
		right11.setCategory("formation");
		rightService.createRight(right11);
		
		//id=27
		Right right12 =new Right();
		right12.setName(" l'affectation des matieres aux enseignants ");
		right12.setCategory("formation");
		rightService.createRight(right12);
		
		return new ResponseEntity<String>("init  ok",HttpStatus.OK);
	}
	@RequestMapping(value = "/init7", method = RequestMethod.GET)
	public ResponseEntity<String> initRightsModule7(){
		
		//discussion
		//id=28
		Right right1 =new Right();
		right1.setName(" discussion instantanée ");
		right1.setCategory("discussion");
	    rightService.createRight(right1);
	    
		return new ResponseEntity<String>("init  ok",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/init8", method = RequestMethod.GET)
	public ResponseEntity<String> initRightsModule8(){
		//Gestion de patrimoine
		//id=29
		Right right1 =new Right();
		right1.setName(" Salles ");
		right1.setCategory("Gestion de patrimoine");
		rightService.createRight(right1);
		
		//id=30
		Right right2 =new Right();
		right2.setName(" Materiels ");
		right2.setCategory("Gestion de patrimoine");
		rightService.createRight(right2);
		 
		return new ResponseEntity<String>("init  ok",HttpStatus.OK);
	}
	@RequestMapping(value = "/init9", method = RequestMethod.GET)
	public ResponseEntity<String> initRightsModule9(){
		
		//id=31
		Right right1 =new Right();
		right1.setName(" inscrire a une formation ");
		right1.setCategory("gestion des inscription");
		rightService.createRight(right1);
		
		//id=32
		Right right2 =new Right();
		right2.setName(" gestion Declarations ");
		right2.setCategory("Declaration");
		rightService.createRight(right2);
		
		return new ResponseEntity<String>("init  ok",HttpStatus.OK);
	}
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public ResponseEntity<String> init(){
		
		initRightsModule1();
		initRightsModule2();
		initRightsModule3();
		initRightsModule4();
		initRightsModule5();
		initRightsModule6();
		initRightsModule7();
		initRightsModule8();
		initRightsModule9();
		
		return new ResponseEntity<String>("init Right ok",HttpStatus.OK);
	}
}

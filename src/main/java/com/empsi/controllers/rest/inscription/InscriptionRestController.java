package com.empsi.controllers.rest.inscription;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.rights.User;
import com.empsi.entities.users.Etudiant;
import com.empsi.managers.rights.GroupManager;
import com.empsi.services.formation.IEtudiantMetier;

@RestController
public class InscriptionRestController {

	@Autowired
	private IEtudiantMetier etudiantMetier;
	
	@Autowired
	private GroupManager groupService;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@RequestMapping(value = "etudiant", method = RequestMethod.POST)
	public ResponseEntity<User> SendMessageForm( @RequestBody Etudiant etudiant , BindingResult bindingResult, HttpSession session){
		
			//msg.setDateEnvoi(new Date());
			etudiant.setDateInscription(new Date());
			etudiant.setEtatCompte(false);
			try {
				
				etudiantMetier.save(etudiant);
				groupService.addUserToTempUser(etudiant.getId());
				SimpleMailMessage mailMessage = new SimpleMailMessage();
		        mailMessage.setTo("aitbelkhalil@gmail.com");
		        mailMessage.setReplyTo("aitbelkhalil@gmail.com");
		        mailMessage.setFrom("aitbelkhalil@gmail.com");
		        mailMessage.setSubject("Inscription");
		        mailMessage.setText("Merci pour votre confiance veuillez attendre l activation de votre compte");
		        javaMailSender.send(mailMessage);
				
				return new ResponseEntity<User>(etudiant , HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<User>(HttpStatus.CONFLICT);
			}
	}

}

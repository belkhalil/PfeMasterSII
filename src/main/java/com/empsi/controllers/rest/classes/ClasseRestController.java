
package com.empsi.controllers.rest.classes;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.classes.Classe;
import com.empsi.entities.classes.Fichier;
import com.empsi.entities.classes.MessageClasse;
import com.empsi.entities.rights.User;
import com.empsi.entities.users.Etudiant;
import com.empsi.services.classes.IClasseMetier;
import com.empsi.services.formation.IEtudiantMetier;
import com.empsi.services.rights.GroupService;
import com.empsi.services.rights.UserService;
import com.empsi.temp.beans.UserBean;

@RestController	
@RequestMapping("/classes")
public class ClasseRestController {

	@Autowired
	private IEtudiantMetier etudiantMetier;
	@Autowired
	private IClasseMetier classeMetier;
	@Autowired
	private UserService userService ;
	
	@Autowired
	private GroupService groupService ;
	 
	@RequestMapping(value = "classes", method = RequestMethod.POST)
	public Classe createClasse( @RequestBody Classe cl , BindingResult bindingResult, HttpSession session){
		System.out.println("====> Classe Cretaed "+cl.getNomClasse());
			
			try {
				//cl.setAnneScolaire(annee);
				Classe classe = classeMetier.saveClasse(cl);
				System.out.println("Classe Cretaed "+classe.getIdClasse());
				return classe;		
			} catch (Exception e) {
				return null;
			}	
	}
	
	
	@RequestMapping(value = "classes", method = RequestMethod.GET)
	public List<Classe> getClasses( HttpSession session){
			System.out.println("*** getting Classes");

			try {
				List<Classe> classes = classeMetier.getAll();
				if(classes.size() == 0)
					return null;
				System.out.println("NBR Classes "+classes.size());
				return classes;		
			} catch (Exception e) {
				return null;
			}	
	}
	
	@RequestMapping(value = "/getClasse/{id}", method = RequestMethod.GET)
	public Classe getClasse( @PathVariable Long id , HttpSession session){
			System.out.println("*** getting Classe");

			System.out.println("IdClasse=>"+classeMetier.getClasse(id).getIdClasse());
			if(classeMetier.getClasse(id) == null)
				return null;
			else
				return classeMetier.getClasse(id);
	}
		
	@RequestMapping(value = "/deleteClasse/{id}" , method = RequestMethod.GET)
	public boolean deleteClass( @PathVariable Long id){
			boolean c =  classeMetier.deleteClasse(id);
			return c;
	}
	@RequestMapping(value = "addEtudiantToClass/{idEtudiant}/{idClass}" , method = RequestMethod.GET)
	public ResponseEntity<Void> addEtudiant( @PathVariable("idEtudiant") Long idEtudiant , @PathVariable("idClass") Long idClass  ){
			try {
				Classe cl = classeMetier.getClasse(idClass);
				Etudiant etud = etudiantMetier.get(idEtudiant);
				etud.setClasse(cl);
				
				etudiantMetier.Update(etud);
				groupService.addUserToEtudiant(etud.getId());
				groupService.removeUserFromGroup(etud.getId(),5L);
			} catch (Exception e) {
				return new ResponseEntity<Void>( HttpStatus.CONFLICT);
			}
			return new ResponseEntity<Void>( HttpStatus.OK);
	}	
	@RequestMapping(value = "maclasse", method = RequestMethod.GET)
	public Classe maClasse( HttpSession session){
			
		UserBean senderBean = (UserBean) session.getAttribute("userBean");
		User user =userService.findUserById(senderBean.getIdUser());
		
			try {
				Classe classe = etudiantMetier.get(user.getId()).getClasse();
				if(classe ==null)
					return null;
				//System.out.println("NBR Classes "+classes.size());
				return classe;		
			} catch (Exception e) {
				return null;
			}	
	}
	
	@RequestMapping(value = "getStudents/{id}", method = RequestMethod.GET)
	public  List<Etudiant> getStudents( @PathVariable Long id , HttpSession session){
			List<Etudiant> etudiants;
			try {
				Classe cl =classeMetier.getClasse(id);
				
				 etudiants = cl.getEtudiants();
				if(etudiants.size() == 0)
					return null;
				return etudiants;		
			} catch (Exception e) {
				return null;
			}	
	}
	
	@RequestMapping(value = "getMessagesClasse/{id}", method = RequestMethod.GET)
	public  List<MessageClasse> getMessagesClasse( @PathVariable Long id , HttpSession session){
			List<MessageClasse> messages;
			try {
				Classe cl =classeMetier.getClasse(id);
				
				 messages = cl.getMessages();
				if(messages.size() == 0)
					return null;
				return messages;		
			} catch (Exception e) {
				return null;
			}	
	}
	@RequestMapping(value = "getFichiers/{id}", method = RequestMethod.GET)
	public  List<Fichier> getFiles( @PathVariable Long id , HttpSession session){
			System.out.println("*** getting Files");
			List<Fichier> files;
			try {
				Classe cl =classeMetier.getClasse(id);
				files = cl.getFichiers();
				if(files.size() == 0)
					return null;
				System.out.println("NBR des Fichiers "+files.size());
				return files;		
			} catch (Exception e) {
				return null;
			}	
	}
	@RequestMapping(value = "mesFichiers/{id}", method = RequestMethod.GET)
	public List<Fichier> mesFichiers( @PathVariable("id") Long id , HttpSession session){
			System.out.println("*** getting Classe Files");
			try {
				Classe cl =classeMetier.getClasse(id);								
				List<Fichier> fichiers = cl.getFichiers();
				if(fichiers.size() == 0)
					return null;
				System.out.println("NBR Fichiers "+fichiers.size());
				return fichiers;		
			} catch (Exception e) {
				return null;
			}	
	}
}
/*@RequestMapping(value = "anneeToClass/{id}", method = RequestMethod.POST)
public Classe addClasse(@PathVariable Long id, BindingResult bindingResult, HttpSession session){
		System.out.println("*** Annee to Classe");
		//msg.setDateEnvoi(new Date());
		AnneeScolaire annee = anneeScolaire.get(id);
		
		System.out.println("***Recuperation => "+annee.getIdAnne());
		try {
			//cl.setAnneScolaire(annee);
			classeMetier.getClasse(id)
			System.out.println("Classe Cretaed "+cl.getIdClasse());
			return cl;		
		} catch (Exception e) {
			return null;
		}	
}	*/
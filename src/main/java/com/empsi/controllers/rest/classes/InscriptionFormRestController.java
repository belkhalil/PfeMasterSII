package com.empsi.controllers.rest.classes;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.empsi.entities.all.Inscription;
import com.empsi.entities.formation.Formation;
import com.empsi.entities.rights.User;
import com.empsi.entities.users.Etudiant;
import com.empsi.managers.formation.IFormationMetier;
import com.empsi.services.classes.IInscriptionFormationMetier;
import com.empsi.services.rights.UserService;
import com.empsi.temp.beans.UserBean;

@RestController	
@RequestMapping("/classes")
public class InscriptionFormRestController {

	@Autowired
	private IInscriptionFormationMetier inscriptionMetier;
	@Autowired
	private UserService userService ;
	@Autowired
	private IFormationMetier formationMetier;
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Transactional
	@RequestMapping(value = "inscription", method = RequestMethod.POST)
	public void SaveInsc( HttpServletRequest request, HttpServletResponse response, HttpSession session 
			,@RequestParam("idFormation") Long id) throws IOException{
		
			System.out.println("*** Inscription POST");
			
			//msg.setDateEnvoi(new Date());
			try {
				
				UserBean senderBean = (UserBean) session.getAttribute("userBean");
				User user =userService.findUserById(senderBean.getIdUser());
				
				Inscription inscription = new Inscription();
				
				String anneeBac = request.getParameter("anneeBac");
				String anneeDiplome = request.getParameter("anneeDiplome");
				String dernierDiplome = request.getParameter("dernierDiplome");
				String serieBac = request.getParameter("serieBac");
				Formation f = formationMetier.get(id);
				System.out.println("==>"+f.getIdFormation());
				inscription.setFormation(f);
				inscription.setDateInsc(new Date());
				inscription.setAnneeBac(anneeBac);
				inscription.setAnneeDiplome(anneeDiplome);
				inscription.setDernierDiplome(dernierDiplome);
				inscription.setSerieBac(serieBac);
				inscription.setEtudiant((Etudiant) user);
				System.out.println("*** Inscription de ==>"+inscription.getEtudiant().getFirstName());
				System.out.println("*** Inscription dans ==>"+inscription.getFormation().getNomFormation());
				//Uploading DIPLOME FILE
				
				/*for (MultipartFile file : diplome){
					
					 //on Prépare les flux
				    BufferedInputStream entree = null;
				    BufferedOutputStream sortie = null;
				    
					//On peut ensuite récupérer quelques informations (comme son type et sa taille) sur le fichier distant
			             String fileType = file.getContentType();
			            double fileLength = file.getSize();
			        
			      //extraire l'extension
			        String fichier =file.getOriginalFilename();//récupère le nom du fichier
			        String extension = fichier.substring(fichier.lastIndexOf(".")+1); //récupère l'extention 
			       
			        
			     //le lien de destination
			    	String lienFichier="src/main/resources/static/images/";
			    	
			    // on enregistre le fichier dans bdd	

			        inscription.setLienDiplome(lienFichier+fichier);
			        inscription.setExtension(extension);
			    	
			    	System.out.println("file=> "+fichier+" ext=> "+extension);
			    	
			            //Ouvre les flux. 
			            entree = new BufferedInputStream( file.getInputStream() );
			            sortie = new BufferedOutputStream( new FileOutputStream(lienFichier+fichier));
			     
			           
			            byte[] buffer = new byte[1024];
			            int read;	
			            while ((read = entree.read(buffer)) > 0)
			        		sortie.write(buffer, 0, read);
			       
			                  sortie.close();
			                
			                  entree.close();

				}
				
			     // CV 
				for (MultipartFile file : cv){
					
					 //on Prépare les flux
				    BufferedInputStream entree = null;
				    BufferedOutputStream sortie = null;
				    
					//On peut ensuite récupérer quelques informations (comme son type et sa taille) sur le fichier distant
			             String fileType = file.getContentType();
			            double fileLength = file.getSize();
			        
			      //extraire l'extension
			        String fichier =file.getOriginalFilename();//récupère le nom du fichier
			        String extension = fichier.substring(fichier.lastIndexOf(".")+1); //récupère l'extention 
			       
			        
			     //le lien de destination
			    	String lienFichier="src/main/resources/static/images/";
			    	
			    // on enregistre le fichier dans bdd	

			        inscription.setLienCv(lienFichier+fichier);
			    	
			    	System.out.println("file CV => "+fichier+" ext=> "+extension);
			    	
			            //Ouvre les flux. 
			            entree = new BufferedInputStream( file.getInputStream() );
			            sortie = new BufferedOutputStream( new FileOutputStream(lienFichier+fichier));
			     
			           
			            byte[] buffer = new byte[1024];
			            int read;	
			            while ((read = entree.read(buffer)) > 0)
			        		sortie.write(buffer, 0, read);
			       
			                  sortie.close();
			                
			                  entree.close();

				}*/
				
				//inscription = inscriptionMetier.save(inscription);
				inscriptionMetier.save(inscription);
				Long idI = inscription.getIdInsc();
				inscription.setNumeroInsc(idI+"/EMPSI/"+Calendar.getInstance().get(Calendar.YEAR));
				System.out.println("=>NUM => "+inscription.getNumeroInsc());
				System.out.println("Start sending mail");
				
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				String email = user.getEmail();
		        mailMessage.setTo("aitbelkhalil@gmail.com");
		        mailMessage.setReplyTo("aitbelkhalil@gmail.com");
		        mailMessage.setFrom("aitbelkhalil@gmail.com");
		        mailMessage.setSubject("Inscription a la formation");
		        mailMessage.setText("Inscrption effectuee a la formation => "+inscription.getFormation().getNomFormation());
		        javaMailSender.send(mailMessage);
				System.out.println("End sending mail");
				
		        response.sendRedirect("/resources/index.html");
			} catch (Exception e) {
		        System.out.println("==> ERREUR ");
		        response.sendRedirect("/resources/index.html");
			}
			
			//return etudiant;
	    //return "redirect:/product/" + product.getId();
	}
	
	@RequestMapping(value = "/getStudents/" , method = RequestMethod.GET)
	public ResponseEntity<List<Etudiant>> getStudents( ){
			List<Etudiant> list = new ArrayList<Etudiant>();

			try {
				List<Inscription> inscriptions = inscriptionMetier.getAll();
				for(int i=0;i<inscriptions.size();i++){
					Etudiant e = inscriptions.get(i).getEtudiant();
					list.add(e);
				}
				
			} catch (Exception e) {
				System.out.println("ERROR while getting INSCRIPTIONS");
				return new ResponseEntity<List<Etudiant>>( list, HttpStatus.CONFLICT);
			}
			return new ResponseEntity<List<Etudiant>>(list , HttpStatus.OK);
	}
	@RequestMapping(value = "/getInscriptions/" , method = RequestMethod.GET)
	public ResponseEntity<List<Inscription>> getInsc(){
			List<Inscription> inscriptions;
			try {
				inscriptions = inscriptionMetier.getAll();
				
			} catch (Exception e) {
				System.out.println("ERROR while getting INSCRIPTIONS");
				return new ResponseEntity<List<Inscription>>( HttpStatus.CONFLICT);
			}
			return new ResponseEntity<List<Inscription>>( inscriptions , HttpStatus.OK);
	}
	@RequestMapping(value = "/getInscription/" , method = RequestMethod.GET)
	public Inscription getInscrip(){
			
		Inscription insc = inscriptionMetier.getOne(1L);
			
				
			return insc;
	}	
	
	
}

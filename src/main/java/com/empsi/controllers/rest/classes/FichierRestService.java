package com.empsi.controllers.rest.classes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.empsi.dao.formation.EnseignantRepository;
import com.empsi.entities.classes.Classe;
import com.empsi.entities.classes.Fichier;
import com.empsi.entities.rights.User;
import com.empsi.services.classes.FichierMetier;
import com.empsi.services.classes.IClasseMetier;
import com.empsi.services.rights.UserService;
import com.empsi.temp.beans.UserBean;

@RestController
@RequestMapping("/classes")
public class FichierRestService {
	

	@Autowired
	private FichierMetier fichierMetier;
	@Autowired
	private UserService userService ;
	@Autowired
	private EnseignantRepository repos;
	@Autowired
	private IClasseMetier classeMetier;
	
	@Transactional
	@RequestMapping(value="/fichier" ,method=RequestMethod.POST)
	public void update( HttpServletRequest request,HttpServletResponse response, @RequestParam("nomFichier") String nomFichier,@RequestParam("idClasse") Long idClasse,
            @RequestParam("fileUpload") MultipartFile[] fileUpload) throws Exception {
		HttpSession session=request.getSession(true);
		//SecurityContext securityContext=(SecurityContext) session
		//		          .getAttribute("SPRING_SECURITY_CONTEXT");
		
        //Enseignant user= new Enseignant("kk", "kk", "kk", "kk@kk", new Date(), "kk", "kk", "kk", "kk", "kk", "kk", 20);
//		System.out.println("entrezzzzz");
//		Compte sender = (Compte) session.getAttribute("compte");
//		System.out.println("sender "+sender.getLogin()+" =>"+sender.getPassword());
//		sender = compteMetier.findByLogin(sender.getLogin(), sender.getPassword());
//		
//		Utilisateur user = (Enseignant) sender.getUtilisateur();
//		
        //repos.save(user);
        //if (fileUpload != null && fileUpload.length > 0) {
        
		//rahhal
		UserBean senderBean = (UserBean) session.getAttribute("userBean");
		User user =userService.findUserById(senderBean.getIdUser());
		
		//rahhal
		System.out.println("enseignant => "+user.getId());
		System.out.println("classe id => "+idClasse);

		for (MultipartFile file : fileUpload){
				
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
    	String lienFichier="src/main/resources/static/files/";
    	
    // on enregistre le fichier dans bdd*/	
    	Fichier f=new Fichier();   
        f.setLienFichier(lienFichier+fichier);
        f.setExtension(extension);
        // extraire l'Id du fichier enregistré*/
        Long nom=f.getIdFichier();
    	
    	//Ici, nous pourrions très bien utiliser directement les flux de type InputStream et FileOutputStream, 
    	// mais les objets BufferedInputStream et BufferedOutputStream permettent, 
    	// via l'utilisation d'une mémoire tampon, 
    	// une gestion plus souple de la mémoire disponible sur le serveur
    	
    	
    	System.out.println("file=> "+fichier+" ext=> "+extension);
    	
            //Ouvre les flux. 
            entree = new BufferedInputStream( file.getInputStream() );
            sortie = new BufferedOutputStream( new FileOutputStream(lienFichier+nomFichier+"."+extension));
     
           
            byte[] buffer = new byte[1024];
            int read;	
            while ((read = entree.read(buffer)) > 0)
        		sortie.write(buffer, 0, read);
       
                  sortie.close();
                
                  entree.close();
		Classe classe = classeMetier.getClasse(idClasse);
    	f.setClasse(classe);
        //modifier les données dans la bdd du fichier actuel
        f.setLienFichier("/images/"+nomFichier+"."+extension);
        f.setNomFichier(nomFichier);
        f.setExtension(extension);
        f.setUser(user);
        f.setDatePartage(new Date());
        fichierMetier.save(f);
        
        }
        response.sendRedirect("/resources/index.html");
     }
	
	
}


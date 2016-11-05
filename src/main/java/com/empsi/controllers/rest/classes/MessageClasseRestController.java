package com.empsi.controllers.rest.classes;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.classes.Classe;
import com.empsi.entities.classes.MessageClasse;
import com.empsi.entities.rights.User;
import com.empsi.services.classes.IMessageClasseMetier;
import com.empsi.services.formation.IEtudiantMetier;
import com.empsi.services.rights.UserService;
import com.empsi.temp.beans.UserBean;

@RestController
@RequestMapping("/classes")
public class MessageClasseRestController {

	@Autowired
	private IMessageClasseMetier messageClasseMetier;
	@Autowired
	private UserService userService ;	
	@Autowired
	private IEtudiantMetier etudiantMetier;
	
	@RequestMapping(value = "messagesClasse", method = RequestMethod.POST)
	public MessageClasse SendMessage( @RequestBody MessageClasse msg , BindingResult bindingResult, HttpSession session){
		UserBean senderBean = (UserBean) session.getAttribute("userBean");
		User user =userService.findUserById(senderBean.getIdUser());

				msg.setUser(user);

				msg.setDateEnvoi(new Date());
			    messageClasseMetier.save(msg);
				System.out.println("Message Cretaed "+msg.getId());
				return msg;
	}
	
	@RequestMapping(value = "/messageClasseRecus" , method = RequestMethod.GET)
	public List<MessageClasse> MessageReceived( Model model , HttpSession session ) {
		try{
			UserBean senderBean = (UserBean) session.getAttribute("userBean");
			User user =userService.findUserById(senderBean.getIdUser());

		//getting Classe	
		Classe classe = etudiantMetier.get(user.getId()).getClasse();
		
		List<MessageClasse> messages = messageClasseMetier.findByClasse(classe.getIdClasse());
		return messages;
		}catch (Exception e) {
			return null;
		}
	}
	
	
	@RequestMapping(value = "/loadMessageClasse/{id}" , method = RequestMethod.GET)
	public ResponseEntity<MessageClasse> loadMessage( @PathVariable Long id){
		MessageClasse cl = null;
		try{	
		System.out.println("IdClasse=>"+ messageClasseMetier.get(id).getId());
		cl = messageClasseMetier.get(id);
			return  new ResponseEntity<MessageClasse>(cl , HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<MessageClasse>( cl , HttpStatus.CONFLICT);
		}	
	}
	
	
}
// i got this from zakaria 
/*@RequestMapping(value = "/messageClasseRecus" , method = RequestMethod.GET)
public List<MessageClasse> MessageReceived( Model model , HttpSession session ) {
	Compte sender = (Compte) session.getAttribute("compte");
	sender = compteMetier.findByLogin(sender.getLogin(), sender.getPassword());
	List<MessageClasse> messages = messageClasseMetier.findByClasse();

	model.addAttribute("messages", messages);
	return messages;
}*/


/*@RequestMapping(value = "/deleteMessages/{id}" , method = RequestMethod.GET)
public boolean deleteClass( @PathVariable Long id){
		System.out.println("IdClasse=>"+classeMetier.getClasse(id).getIdClasse());
		boolean c =  classeMetier.deleteMessages(id);
		System.out.println("==> "+c);
		return c;
}*/
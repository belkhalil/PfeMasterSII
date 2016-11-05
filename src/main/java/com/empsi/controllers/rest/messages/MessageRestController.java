package com.empsi.controllers.rest.messages;
	
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.messages.Message;
import com.empsi.entities.rights.User;
import com.empsi.services.messages.IMessageMetier;
import com.empsi.services.rights.UserService;
import com.empsi.temp.beans.UserBean;

@RestController
@RequestMapping("/message/")
public class MessageRestController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private IMessageMetier messageMetier;
	
	@RequestMapping(value = "messages", method = RequestMethod.POST)
	public ResponseEntity<Message> SendMessageForm( @RequestBody Message msg , HttpSession httpSession){
			System.out.println("*** Sending Message");
			//msg.setDateEnvoi(new Date());
			System.out.println("*** "+msg.getObjet());
			System.out.println("*** "+msg.getMessage());
			System.out.println("*** "+msg.getEmail());
			System.out.println("*** "+msg.getDateEnvoi());
			msg.setDateEnvoi(new Date());
			
			if(userService.findByEmail(msg.getEmail()) !=null){
				
				User receiver = userService.findByEmail(msg.getEmail());
				System.out.println("recepteur => "+receiver.getId());
				UserBean senderBean = (UserBean) httpSession.getAttribute("userBean");
				System.out.println("senderBean => "+senderBean.getIdUser());
				User sender = userService.findUserById(senderBean.getIdUser());
				System.out.println("sender =>"+sender.getId());
				String email = sender.getEmail();
				msg.setEmail_sender(email);
				msg.setUser(sender);
				msg.setUser2(receiver);
				
				messageMetier.save(msg);

				return new ResponseEntity<>(msg,HttpStatus.OK);
			}
			else
				return new ResponseEntity<Message>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/messageRecus" , method = RequestMethod.GET)
	public ResponseEntity<List<Message>> MessageReceived( Model model , HttpSession httpSession) {
		UserBean userBean = (UserBean) httpSession.getAttribute("userBean");
		
		if (userBean==null) {
			return new ResponseEntity<List<Message>>(HttpStatus.UNAUTHORIZED);
		}
		
		System.out.println("mebe userBean is null "+ userBean.getIdUser());
		List<Message> messages = messageMetier.receivedMessage(userBean.getIdUser());
		if (messages.isEmpty()) {
			return new ResponseEntity<List<Message>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Message>>(messages,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/messageEnvoyes" , method = RequestMethod.GET)
	public ResponseEntity <List<Message>> MessageSent(HttpSession session ) {
		UserBean senderBean = (UserBean) session.getAttribute("userBean");
		List<Message> messages = messageMetier.sendedMessage(senderBean.getIdUser());
		if (messages.isEmpty()) {
			
			return new ResponseEntity<List<Message>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Message>>(messages,HttpStatus.OK);
	}	
	@RequestMapping(value = "/message/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Message> getMessage( @PathVariable Long id){
		return new ResponseEntity<Message>( messageMetier.get(id),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/messageDeleted/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Void> deleteMessage( @PathVariable Long id){
		
		boolean c =  messageMetier.delete(id);
		if (c) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}

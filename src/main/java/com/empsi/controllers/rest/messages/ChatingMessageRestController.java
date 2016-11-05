package com.empsi.controllers.rest.messages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.messages.ChatingMessage;
import com.empsi.services.messages.ChatingMessageService;

@RestController
@RequestMapping("/message/")
public class ChatingMessageRestController {

	@Autowired
	ChatingMessageService chatingMessageService ;
	
	@RequestMapping(value = "allmessagesfromto", method = RequestMethod.GET)
	public  ResponseEntity<List<ChatingMessage>> addRightToGroup(@RequestParam(value="idSender") Long idSender ,@RequestParam(value="idReceiver") Long idReceiver){
		List<ChatingMessage> messages =chatingMessageService.findChatingMessageByIdSenderIdReceiverr(idSender, idReceiver);
		if(messages==null){
			return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new  ResponseEntity<>(messages,HttpStatus.OK);
	}
	
	
}

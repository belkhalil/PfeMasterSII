package com.empsi.controllers.rest.sockets;

import java.util.Date;
import java.util.Hashtable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.stereotype.Controller;

import com.empsi.entities.messages.ChatingMessage;
import com.empsi.services.messages.ChatingMessageService;
import com.empsi.temp.beans.ConnectionModel;

@Controller
public class GreetingController{

	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	private TaskScheduler scheduler = new ConcurrentTaskScheduler();
	
	@Autowired
	private ConnectionModel connectionModel ;
	
	@Autowired
	private ChatingMessageService chatingMessageService ;
	
	public GreetingController() {
		
	}

	@MessageMapping("/chat")
	@SendTo("/topic/message")
	public ChatingMessage sendMessage(ChatingMessage message) {
		
//		UserBean userBean = (UserBean) httpSession.getAttribute("userBean");
//		if (userBean != null) {
//			System.out.println("message send from id "+ userBean.getIdUser());
//		}
//		else{
//			
//		}
		message.setTime(new Date());
		System.out.println("Receiver : "+message.getIdReceiver()+" Sender : "+message.getIdSender());
		chatingMessageService.addMessage(message);
		return message;
	}
	
	@MessageMapping("/send")
	public void send(ChatingMessage message){
		
		
	}
	public void sendConnectedUsers(Hashtable<Long, String> users) {
		
		messagingTemplate.convertAndSend("/topic/users/", users);
		
	}
	
	@PostConstruct
	  private void broadcastTimePeriodically() {
//	    scheduler.scheduleAtFixedRate(new Runnable() {
//	      @Override public void run() {
//	    	  sendConnectedUsers(connectionModel.getConnectedUsers());
//	      }
//	    }, 1000);
	  }
}

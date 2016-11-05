package com.empsi.temp.beans;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.empsi.controllers.rest.sockets.GreetingController;

@Component
@Scope("singleton")
public class ConnectionModel {

	
	private Hashtable<Long, String> connectedUsers ;
	@Autowired
	private GreetingController greetingController;
	
	public ConnectionModel() {
		setConnectedUsers(new Hashtable<Long, String>());
	}
	

	
	
	public Hashtable<Long, String> getConnectedUsers() {
		return connectedUsers;
	}
	public void setConnectedUsers(Hashtable<Long, String> connectedUsers) {
		this.connectedUsers = connectedUsers;
	}
	public void login(Long id,String name){
		connectedUsers.put(id, name);
		greetingController.sendConnectedUsers(connectedUsers);
	}
	public void logout(Long id){
		connectedUsers.remove(id);
		greetingController.sendConnectedUsers(connectedUsers);
	}
	
	
}

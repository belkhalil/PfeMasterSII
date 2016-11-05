package com.empsi.controllers.rest.sockets;

import java.util.Hashtable;

public interface GreetingInterface {

	void sendConnectedUsers(Hashtable<Long, String> users);

}
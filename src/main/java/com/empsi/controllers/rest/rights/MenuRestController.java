package com.empsi.controllers.rest.rights;

import java.util.Hashtable;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.empsi.temp.beans.ConnectionModel;
import com.empsi.temp.beans.UserBean;

@Controller
@RequestMapping(value="/menu")
public class MenuRestController {

	@Autowired
	ConnectionModel connectionModel ;
	public MenuRestController(){
		
	}
	@RequestMapping(value="/getMenu/" ,method=RequestMethod.GET)
	public ResponseEntity<Hashtable<String,Hashtable<String, String>>> getMenu(HttpSession httpSession){
		UserBean userBean = (UserBean) httpSession.getAttribute("userBean");
		if (userBean != null) {
			Hashtable<String,Hashtable<String, String>> menu= userBean.getMenu();
			return new ResponseEntity<Hashtable<String,Hashtable<String, String>>>(menu,HttpStatus.OK);
		}
		else{
			
			return new ResponseEntity<Hashtable<String,Hashtable<String,String>>>(HttpStatus.NO_CONTENT);
		}
		
	}
	@RequestMapping(value="/get/",method=RequestMethod.GET, produces = "application/json")
	public ResponseEntity<UserBean> getUserBean(HttpSession httpSession){
		UserBean userBean = (UserBean) httpSession.getAttribute("userBean");
		if (userBean != null) {
			
			return new ResponseEntity<UserBean>(userBean,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<UserBean>(HttpStatus.NO_CONTENT);
		}
	}
	@RequestMapping(value="/users/",method=RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Hashtable<Long, String>> getConnectedUsers(){
		Hashtable<Long, String> users= connectionModel.getConnectedUsers() ;
		return new ResponseEntity<Hashtable<Long,String>>(users,HttpStatus.OK);
	}
}

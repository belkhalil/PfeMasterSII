package com.empsi.controllers.rest.rights;

import java.util.Hashtable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.empsi.temp.beans.RightAndCagtegory;

@Controller
@RequestMapping(value="/dictionary")
public class DictionaryRestController {

	RightAndCagtegory rightAndCagtegory;
	
	public DictionaryRestController() {
		rightAndCagtegory =new RightAndCagtegory();
	}

	@RequestMapping(value="/get" ,method=RequestMethod.GET)
	public ResponseEntity<Hashtable<String,Hashtable<String, String>>> getDictionary(){
		
	 	return new ResponseEntity<Hashtable<String,Hashtable<String, String>>>(rightAndCagtegory.getCategories(),HttpStatus.OK);
	}
	
}

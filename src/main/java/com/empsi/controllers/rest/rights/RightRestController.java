package com.empsi.controllers.rest.rights;

import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.empsi.entities.rights.Right;
import com.empsi.services.rights.RightService;
import com.empsi.temp.beans.RightAndCagtegory;

@Controller
@RequestMapping(value="/right")
public class RightRestController {
	
	@Autowired
	private RightService rightService;
	
	public RightRestController() {
	
	}
	
	
	@RequestMapping(value="/categories",method=RequestMethod.GET )
	public ResponseEntity<Hashtable<String,Hashtable<String, String>>> getAllCategories(){
		
		RightAndCagtegory rightAndCagtegory =new RightAndCagtegory();
		Hashtable<String, Hashtable<String, String>> categories =rightAndCagtegory.getCategories();
		
		return new ResponseEntity<Hashtable<String,Hashtable<String,String>>>(categories,HttpStatus.OK);
	}
	
	@RequestMapping(value="/right" ,method=RequestMethod.GET)
	public ResponseEntity<List<Right>> getAllRights(){
	 List<Right> rights =rightService.findAllRights();
	 	if (rights.isEmpty()) {
			return new ResponseEntity<List<Right>>(HttpStatus.NO_CONTENT);
		}
	 	return new ResponseEntity<List<Right>>(rights,HttpStatus.OK);
	}
	@RequestMapping(value="/rightclassed" ,method=RequestMethod.GET)
	public ResponseEntity<Hashtable<String, Hashtable<String, String>>> getAllRightsEntrie(){
	 List<Right> rights =rightService.findAllRights();
	 	if (rights.isEmpty()) {
	 		System.out.println("ther is no rights in database");
			return new ResponseEntity<Hashtable<String, Hashtable<String, String>>>(HttpStatus.NO_CONTENT);
		}
	 	
	 	return new ResponseEntity<Hashtable<String, Hashtable<String, String>>>(loadMenus(rights),HttpStatus.OK);
	}
	@RequestMapping(value="/right/{id}" ,method=RequestMethod.DELETE)
	public ResponseEntity<Right> deleteRight(@PathVariable Long id){
		rightService.deletRight(id);
		return new ResponseEntity<Right>(HttpStatus.OK);
	}
	@RequestMapping(value="/right" ,method=RequestMethod.POST)
	public ResponseEntity<Right> activateRight(@RequestBody Right right){
		
		rightService.createRight(right);
		return new  ResponseEntity<Right>(HttpStatus.OK);
	}
	public Hashtable<String, Hashtable<String, String>> loadMenus(List<Right> rights) {
		// 3la assa bli les right rahom deja 7aido manhom les doublants
		//afficherAvantLoad(rights);
		Hashtable<String, Hashtable<String, String>> userMenu = new Hashtable<String, Hashtable<String,String>>() ;
		RightAndCagtegory rightAndCagtegory =new RightAndCagtegory();
		Hashtable<String, Hashtable<String, String>> categoriesDictionary = rightAndCagtegory.getCategories();
		for (String category : categoriesDictionary.keySet()) {
			Hashtable<String, String> dictionaryItems = categoriesDictionary.get(category);
			for (String itemeTitle : dictionaryItems.keySet()) {
				String url = dictionaryItems.get(itemeTitle);
				for (Right right : rights) {
					if (right.getCategory().equals(category)) {
						if (right.getName().contains(itemeTitle)) {
	
							Hashtable<String, String> userCategoryItemes = userMenu
									.get(category);
							if (userCategoryItemes==null) {
								
								userCategoryItemes = new Hashtable<String, String>();
								userCategoryItemes.put(itemeTitle, url);
								userMenu.put(category, userCategoryItemes);
								
								
							} else {
								userCategoryItemes.put(itemeTitle, url);
								
							}
						}
					}
				}
	
			}
		}
		return userMenu;
	}
}

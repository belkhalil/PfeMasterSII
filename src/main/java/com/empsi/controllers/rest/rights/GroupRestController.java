package com.empsi.controllers.rest.rights;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empsi.entities.rights.Group;
import com.empsi.entities.rights.Right;
import com.empsi.services.rights.GroupService;

@Controller
@RequestMapping(value = "/group")
public class GroupRestController {

	@Autowired
	GroupService groupService;

	public GroupRestController() {

	}
	
	@RequestMapping(value = "groups", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<Group> getGroups() {
		return groupService.findAllGroups();
	}

	// -------------------Retrieve All Groups--------------------------------------------------------

	@RequestMapping(value = "/group/", method = RequestMethod.GET)
	public ResponseEntity<List<Group>> listAllGroups() {
		List<Group> groups = groupService.findAllGroups();
		if (groups.isEmpty()) {
			return new ResponseEntity<List<Group>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
	}

	// -------------------Retrieve Single Group--------------------------------------------------------

	@RequestMapping(value = "/group/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Group> getGroup(@PathVariable("id") long id) {
		Group group = groupService.findGroupById(id);
		if (group == null) {
			System.out.println("Group with id " + id + " not found");
			return new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Group>(group, HttpStatus.OK);
	}

	// -------------------Create a  Group--------------------------------------------------------

	@RequestMapping(value = "/group/", method = RequestMethod.POST)
	public ResponseEntity<Group> createGroup(@RequestBody Group group) {
		

//		if (groupService.isGroupExist(group)) {
//		
//			return new ResponseEntity<Group>(HttpStatus.CONFLICT);
//		}

		groupService.create(group);

		return new ResponseEntity<Group>(group,HttpStatus.CREATED);
	}

	// ------------------- Update a Group  --------------------------------------------------------

	@RequestMapping(value = "/group/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Group> updateUser(@PathVariable("id") long id,
			@RequestBody Group group) {
		
//		Group currentGroup = groupService.findGroupById(id);
//
//		if (currentGroup == null) {
//			System.out.println("User with id " + id + " not found");
//			return new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
//		}
		groupService.updateGroup(id, group);
		return new ResponseEntity<Group>(HttpStatus.OK);
	}

	// ------------------- Delete a Group  --------------------------------------------------------

	@RequestMapping(value = "/group/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Group> deleteGroup(@PathVariable("id") long id) {
	
		Group group = groupService.findGroupById(id);
		if (group == null) {
			return new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
		}

		groupService.deletGroup(id);
		return new ResponseEntity<Group>(HttpStatus.NO_CONTENT);
	}
		@RequestMapping(value = "/addRightToGroup", method = RequestMethod.POST)
		public  ResponseEntity<Group> addRightToGroup(@RequestParam(value="idright") Long idRight ,@RequestParam(value="idgroup") Long idGroup){
			groupService.addRightToGroup(idRight, idGroup);
			return new  ResponseEntity<Group>(HttpStatus.OK);
		}
		
		@RequestMapping(value = "/addUserToGroup", method = RequestMethod.POST)
		public ResponseEntity<Group> addUserToGroup(@RequestParam(value="iduser") Long idUser ,@RequestParam(value="idgroup") Long idGroup){
			groupService.addUserToGroup(idUser, idGroup);
			return new ResponseEntity<Group>(HttpStatus.OK);
			
		}
		@RequestMapping(value = "/grouprights", method = RequestMethod.GET)
		public ResponseEntity<List<Right>> getRightsFromGroup(@RequestParam(value="id")Long id){
			List<Right> rights= groupService.getRightsFromGroup(id);
			return new ResponseEntity<List<Right>>(rights,HttpStatus.OK);
		}
		
		@RequestMapping(value = "/removeRightFromGroup", method = RequestMethod.POST)
		public ResponseEntity<Void> removeRightFromGroup(@RequestParam(value="idRight")Long idRight,@RequestParam(value="idGroup")Long idGroup){
			groupService.removeRightFromGroup(idRight, idGroup);
			return new ResponseEntity<Void>(HttpStatus.OK) ;
		}
		
		@RequestMapping(value = "/removeUserFromGroup", method = RequestMethod.POST)
		public ResponseEntity<Void> removeUserFromGroup(@RequestParam(value="idUser")Long idUser,@RequestParam(value="idGroup") Long idGroup){
			groupService.removeUserFromGroup(idUser, idGroup);
			return new ResponseEntity<Void>(HttpStatus.OK) ;
		}

}

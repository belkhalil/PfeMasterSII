package com.empsi.managers.rights;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.rights.GroupDao;
import com.empsi.dao.rights.RightDao;
import com.empsi.dao.rights.UserDao;
import com.empsi.entities.rights.Group;
import com.empsi.entities.rights.Right;
import com.empsi.entities.rights.User;
import com.empsi.services.rights.GroupService;

@Service
public class GroupManager implements GroupService{

	
	
	public GroupManager() {	
	}
	
	@Autowired
	GroupDao groupDao ;
	
	@Autowired
	UserDao userDao ;
	
	@Autowired
	RightDao rightDao;
	
	@Override
	public Group findGroupById(Long id){
		return groupDao.getOne(id);
	}
	@Override
	public List<Group> findAllGroups(){
		return groupDao.findAll();
	}
	@Override
	public Boolean deletGroup(Long id){
		Group group =findGroupById(id);
		groupDao.delete(group);
		return true;
	}
	@Override
	public Boolean create(Group group){
		groupDao.saveAndFlush(group);
		return true;
	}
	
	@Override
	public Boolean updateGroup(Long id, Group group) {
	
		Group currentGroup =findGroupById(id);
		currentGroup.setGroupName(group.getGroupName());
		groupDao.saveAndFlush(currentGroup);
		return true;
	}
	@Override
	public Boolean isGroupExist(Group group) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean addUserToGroup(Long idUser, Long idGroup) {
		System.out.println("addUserToGroup in GroupManager id user :"+idUser +" ,and the id group "+idGroup);
		Group group =findGroupById(idGroup);
		User user =userDao.findOne(idUser);
		group.getUsers().add(user);
		groupDao.saveAndFlush(group);
		
		return true;
	}
	@Override
	public Boolean addRightToGroup(Long idRight, Long idGroup) {
		Group group =findGroupById(idGroup);
		Right right =rightDao.findOne(idRight);
		group.getRights().add(right);
		groupDao.saveAndFlush(group);
		return true;
	}
	@Override
	public Boolean removeUserFromGroup(Long idUser, Long idGroup) {
		Group group =findGroupById(idGroup);
		List<User> users =group.getUsers();
		 
		for(int index=0;index<users.size();index++){
			if(users.get(index).getId()==idUser)
			{
				users.remove(index);
				break;
			}
		}
		groupDao.saveAndFlush(group);
		return null;
	}
	@Override
	public Boolean removeRightFromGroup(Long idRight, Long idGroup) {
		Group group =findGroupById(idGroup);
		List<Right> rights =group.getRights();
		 
		for(int index=0;index<rights.size();index++){
			if(rights.get(index).getId()==idRight)
			{
				rights.remove(index);
				break;
			}
		}
		groupDao.saveAndFlush(group);
		return null;
	}
	@Override
	public List<Right> getRightsFromGroup(Long id) {
		Group group =groupDao.findOne(id);
		List<Right> rights =group.getRights();
		return rights;
	}
	@Override
	public Boolean addUserToEtudiant(Long idUser) {

		addUserToGroup(idUser,2L);
		return true;
	}
	@Override
	public Boolean addUserToEnseignantPermanent(Long idUser) {
		addUserToGroup(idUser,3L);
		return true;
	}
	@Override
	public Boolean addUserToEnseignantVacataire(Long idUser) {
		addUserToGroup(idUser,4L);
		return true;
	}
	@Override
	public Boolean addUserToTempUser(Long idUser) {
		addUserToGroup(idUser,5L);
		return true;
	}
	
}

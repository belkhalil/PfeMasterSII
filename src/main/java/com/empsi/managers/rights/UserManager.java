package com.empsi.managers.rights;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.rights.GroupDao;
import com.empsi.dao.rights.UserDao;
import com.empsi.entities.rights.Group;
import com.empsi.entities.rights.Right;
import com.empsi.entities.rights.User;
import com.empsi.services.rights.UserService;

@Service
public class UserManager implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private GroupDao groupDao ;
	
	
	
	@Override
	public User findUserById(Long id) {
		return userDao.findOne(id);
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.findAll();
	}

	@Override
	public Boolean deletUser(Long id) {
		
		 userDao.delete(id);
		 return true;
	}

	@Override
	public Boolean createUser(User user) {
		userDao.save(user);
		return true;
	}

	@Override
	public Boolean updateUser(Long id, User user) {
		
		userDao.saveAndFlush(user);
		return true;
		
	}

	@Override
	public boolean isUserExist(User user) {
		
		return false;
	}

	@Override
	public Long loginUser(String email, String password) {
		List<User> users = findAllUsers();
		for (User user : users) {
			if (user.getEmail().equals(email))
				if (user.getPassword().equals(password))
					return user.getId();
		}
		return null;
	}

	@Override
	public List<Group> getAllUserGroups(long id) {
		User user =findUserById(id);
		//List<Group> groups =user.getGroups();
		List<Group> allgroups =groupDao.findAll();
		List<Group> groups =new ArrayList<Group>();
		for(Group group: allgroups){
			if(group.getUsers().contains(user)){
				groups.add(group);
			}
		}
		return groups;
	}

	@Override
	public List<User> findUsersByGroup(Long id) {
		Group group =groupDao.findOne(id);
		List<User> users =group.getUsers();
		return users;
	}

	@Override
	public List<Right> getUserAllRights(Long id) {
		List<Right> rightsToreturn = new ArrayList<Right>();
//		User user = findUserById(id);
//		List<Group> groups = user.getGroups();
		List<Group> groups =getAllUserGroups(id);
		for (Group group : groups) {
			List<Right> rights = group.getRights();
			for (Right right : rights) {

				if (!rightsToreturn.contains(right)) {
					rightsToreturn.add(right);
				}
			}
		}
		return rightsToreturn;
	}

	@Override
	public User findByEmail(String email) {
		//		List<User> users =findAllUsers();
		//		for (int i = 0; i < users.size(); i++) {
		//			if (users.get(i).getEmail()==email) {
		//				return users.get(i);
		//			}
		//		}
		return userDao.findByEmail(email);
		//return null ;
	}

	

}

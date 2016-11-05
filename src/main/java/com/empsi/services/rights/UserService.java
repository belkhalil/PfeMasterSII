package com.empsi.services.rights;
import java.util.List;

import org.springframework.stereotype.Service;

import com.empsi.entities.rights.Group;
import com.empsi.entities.rights.Right;
import com.empsi.entities.rights.User;

@Service
public interface UserService {
	
	public User findUserById(Long id);
	public List<User> findAllUsers();
	public Boolean deletUser(Long id);
	public Boolean createUser(User user);
	public Boolean updateUser(Long id,User user);
	public boolean isUserExist(User user);
	public Long loginUser(String email, String password);
	public List<Group> getAllUserGroups(long id) ;
	public List<User> findUsersByGroup(Long id);
	public List<Right> getUserAllRights(Long id);
	public User findByEmail(String email);
	
}

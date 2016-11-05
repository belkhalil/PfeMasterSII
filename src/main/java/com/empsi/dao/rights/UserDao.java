package com.empsi.dao.rights;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.empsi.entities.rights.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
	 @Transactional	
	 @Query("SELECT u FROM User u WHERE u.email = :email ")
	 User findByEmail(@Param("email") String email );

}
/*
 
	@Transactional
	public List<Group> getAllUserGroups(long id){
		User user = entityManager.find(User.class, id);
		List<Group> groups = user.getGroups();
		Hibernate.initialize(groups);
		return groups ;
	}
	
	public List<User> findAllUsers() {

		return entityManager.createQuery("SELECT u FROM User u", User.class)
				.getResultList();
	}

	public long countAllUsers() {
		return entityManager.createQuery("SELECT COUNT(u) FROM User u",
				long.class).getSingleResult();
	}

	public User findUser(Long id) {
		if (id == null)
			return null;
		return entityManager.find(User.class, id);
	}

	@Transactional
	public void addUser(User user) {
		this.entityManager.persist(user);
	}

	@Transactional
	public List<Right> getUserAllRight(Long id) {
		List<Right> rightsToreturn = new ArrayList<Right>();
		User user = entityManager.find(User.class, id);
		List<Group> groups = user.getGroups();
		Hibernate.initialize(groups);
		for (Group group : groups) {
			List<Right> rights = group.getRights();
			Hibernate.initialize(rights);
			for (Right right : rights) {

				if (!rightsToreturn.contains(right)) {
					rightsToreturn.add(right);
				}
			}
		}
		return rightsToreturn;
	}

	public void deleteUserById(Long id) {
		User user = entityManager.find(User.class, id);
		entityManager.remove(user);
	}

	@Transactional
	public void updateUser(long id, User user) {
		User currentUser = entityManager.find(User.class, id);
		currentUser.setDeletable(false);
		currentUser.setEmail(user.getEmail());
		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setTelephone(user.getTelephone());
		currentUser.setPassword(user.getPassword());
		entityManager.merge(currentUser);

	}

	public List<User> searchUser(String name, Long groupId) {
		List<User> result = new ArrayList<User>();

		List<User> users;
		if (groupId == null) {
			users = findAllUsers();
		} else {
			Group group = entityManager.find(Group.class, groupId);
			users = group.getUsers();
			Hibernate.initialize(users);
		}
		if (name==null) {
			result=users;
		}
		else{
			for (int i = 0; i < users.size(); i++) {

				User user = users.get(i);

				Boolean testFirstName = false;
				Boolean testLastName = false;
				//Boolean testDiscription = true;

				testFirstName = user.getFirstName().toLowerCase()
						.contains(name.toLowerCase());
				testLastName = user.getLastName().toLowerCase()
						.contains(name.toLowerCase());

				if (testLastName || testFirstName) {
					result.add(user);
				}
			}
		}
		
		return result;

	}
	@Transactional
	public List<User> findUsersByGroup(Long id) {
		Group group = entityManager.find(Group.class, id);
		List<User>users = group.getUsers();
		Hibernate.initialize(users);
		return users;
	}
 */
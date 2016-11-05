package com.empsi.services.rights;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empsi.entities.rights.Group;
import com.empsi.entities.rights.Right;

@Service
public interface GroupService {
	
	public Group findGroupById(Long id);
	public List<Group> findAllGroups();
	public Boolean deletGroup(Long id);
	public Boolean create(Group group);
	public Boolean updateGroup(Long id,Group group);
	public Boolean isGroupExist(Group group);
	public Boolean addUserToGroup(Long idUser,Long idGroup);
	public Boolean addRightToGroup(Long idRight,Long idGroup);
	public List<Right> getRightsFromGroup(Long id);
	public Boolean addUserToEtudiant(Long idUser);
	public Boolean addUserToEnseignantPermanent(Long idUser);
	public Boolean addUserToEnseignantVacataire(Long idUser);
	public Boolean addUserToTempUser(Long idUser);
	
	public Boolean removeUserFromGroup(Long idUser,Long idGroup);
	public Boolean removeRightFromGroup(Long idRight,Long idGroup);
}

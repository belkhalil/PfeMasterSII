package com.empsi.services.rights;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empsi.entities.rights.Group;
import com.empsi.entities.rights.Right;

@Service
public interface RightService{
		
	public Right findRightById(Long id);
	public List<Right> findAllRights();
	public Boolean deletRight(Long id);
	public Boolean createRight(Right right);
	public Boolean updateRight(Long id,Right right);
	public boolean isRightExist(Group group);
	
}

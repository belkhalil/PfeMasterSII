package com.empsi.managers.rights;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.rights.RightDao;
import com.empsi.entities.rights.Group;
import com.empsi.entities.rights.Right;
import com.empsi.services.rights.RightService;

@Service
public class RightManager implements RightService{

	@Autowired
	private RightDao rightDao;
	
	public RightManager() {
	}
	@Override
	public Right findRightById(Long id) {
		return rightDao.findOne(id);
	}

	@Override
	public List<Right> findAllRights() {
		return rightDao.findAll();
	}

	@Override
	public Boolean deletRight(Long id) {
		rightDao.delete(id);
		return true;
	}

	@Override
	public Boolean createRight(Right right) {
		rightDao.saveAndFlush(right);
		return true;
	}

	@Override
	public Boolean updateRight(Long id, Right right) {
		right.setId(id);
		rightDao.saveAndFlush(right);
		return true ;
	}

	@Override
	public boolean isRightExist(Group group) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
}

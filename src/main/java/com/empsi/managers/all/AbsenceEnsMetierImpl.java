package com.empsi.managers.all;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.empsi.dao.all.AbsenceEnsRepository;
import com.empsi.entities.all.AbsenceEns;
import com.empsi.services.all.IAbsenceEnsMetier;

public class AbsenceEnsMetierImpl implements IAbsenceEnsMetier {

	@Autowired
	private AbsenceEnsRepository absence;
	
	@Override
	public AbsenceEns get(Long id) {
		
		return absence.getOne(id);
	}

	@Override
	public List<AbsenceEns> getAll() {
		// TODO Auto-generated method stub
		return absence.findAll();
	}

	@Override
	public AbsenceEns save(AbsenceEns abs) {
		// TODO Auto-generated method stub
		return absence.save(abs);
	}

	@Override
	public AbsenceEns update(AbsenceEns abs) {
		// TODO Auto-generated method stub
		return absence.saveAndFlush(abs);
	}

	@Override
	public boolean delete(Long id) {
		if( absence.getOne(id) != null)
			absence.delete(id);
		else
			return false;
		return true;
	}

}

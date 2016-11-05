package com.empsi.services.all;

import java.util.List;

import com.empsi.entities.all.AbsenceEns;

public interface IAbsenceEnsMetier {

	public AbsenceEns get(Long id);
	public List<AbsenceEns> getAll();
	public AbsenceEns save(AbsenceEns abs);
	public AbsenceEns update(AbsenceEns abs);
	public boolean delete(Long id);

}

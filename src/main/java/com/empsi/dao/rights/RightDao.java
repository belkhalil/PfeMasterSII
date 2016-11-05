package com.empsi.dao.rights;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empsi.entities.rights.Right;

@Repository
public interface RightDao extends JpaRepository<Right, Long> {

	
}
/*
 @PersistenceContext(name = "acme")
	EntityManager entityManager;
	
	public RightDao() {
		
	}
	@Transactional
	public void addRight(Right right){
		entityManager.persist(right);
	}
	public List<Right> findAllRights(){
		return entityManager.createQuery("SELECT r FROM Right r",Right.class).getResultList();
	}
	public Right findRighitById(Long id){
		return entityManager.find(Right.class, id);
	}
	@Transactional
	public void deleteRight(Long id){
		if (id==null) return;
		Right right =findRighitById(id);
		entityManager.remove(right);
		
	}
	public void updateRight(Long id,Right right){
		Right currentRight =findRighitById(id);
		currentRight.setCategory(right.getCategory());
		currentRight.setDeletable(right.getDeletable());
		currentRight.setDisc(right.getDisc());
		currentRight.setName(right.getName());
		
	}
 * */

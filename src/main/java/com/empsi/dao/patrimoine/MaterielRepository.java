package com.empsi.dao.patrimoine;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empsi.entities.patrimoine.Materiel;

public interface MaterielRepository extends JpaRepository<Materiel, Long> {

}

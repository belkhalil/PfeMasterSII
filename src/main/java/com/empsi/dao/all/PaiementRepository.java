package com.empsi.dao.all;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empsi.entities.all.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {

}

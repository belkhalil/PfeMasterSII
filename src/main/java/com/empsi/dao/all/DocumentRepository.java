package com.empsi.dao.all;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empsi.entities.all.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{

}

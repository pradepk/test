package com.sonata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sonata.model.Certificate_Details;

//Certificate repository extending JPA repository to perform CRUD operations
@Repository
public interface CertificateRepository extends JpaRepository<Certificate_Details, Long>{
	
}

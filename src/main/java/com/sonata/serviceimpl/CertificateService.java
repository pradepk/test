package com.sonata.serviceimpl;

import java.util.List;
import java.util.Optional;

import com.sonata.exception.DuplicateCertificateException;
import com.sonata.service.CertificateServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sonata.model.CertificateDetailsList;
import com.sonata.model.Certificate_Details;
import com.sonata.repository.CertificateRepository;

//Certificate service class that provides service to the controller
@Service
@Component
public class CertificateService implements CertificateServ {
	@Autowired
	CertificateDetailsList certificateList;
	
	@Autowired
	CertificateRepository certificateRepo; 
	
	//Getting a list of certification courses
	@Override
	public CertificateDetailsList getAllCourses() {
		List<Certificate_Details> list = certificateRepo.findAll();
		certificateList.setCertificateList(list);
		return certificateList;
	}
	
	//Getting a certification course detail by passing certificate Id as parameter
	@Override
	public Optional<Certificate_Details> getCourse(long cId) {
		return certificateRepo.findById(cId);
	}
	
	//Saving a certification course detail in database
	@Override
	public boolean saveCourses(Certificate_Details c3) {
		boolean contains = false;
		try {
			List<Certificate_Details> certificates=certificateRepo.findAll();
			certificateList.setCertificateList(certificates);

			for (Certificate_Details certList : certificates){
				Long certId = certList.getCertificateId();

				if (c3.getCertificateId()==certId)
					throw new DuplicateCertificateException("Certificate is already present");
				else
					return contains;

			}
			certificateRepo.save(c3);


		} catch (DuplicateCertificateException e) {
            throw new RuntimeException(e);
        }

		return contains;
	}
	
	//Deleting a certification course detail in database
	@Override
	public void deleteCourse(Certificate_Details c3) {
		certificateRepo.delete(c3);
	}
	
	//Updating a certification course detail
	@Override
	public Certificate_Details updateCourses(long pid,Certificate_Details c3){
		Certificate_Details c2=certificateRepo.findById(pid).get();
		c2.setCriticality(c3.getCriticality());
		c2.setValidity(c3.getValidity());
		return certificateRepo.save(c3);
	}
}

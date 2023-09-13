package com.sonata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sonata.model.CertificateDetailsList;
import com.sonata.model.Certificate_Details;
import com.sonata.serviceimpl.CertificateService;

//Certificate controller class 
@RestController
public class CertificateResource {
	
	@Autowired
	CertificateService certificateService;
	
	//Getting all certification course details
	@GetMapping("/certificate")
	public CertificateDetailsList getAllCertificates(){
		return certificateService.getAllCourses();
	}
	
	//Getting a certification course detail by passing certificate Id as parameter
	@GetMapping("/certificate/{certificateId}")
	public Certificate_Details getCertificate(@PathVariable("certificateId") long id){
		Certificate_Details certificateDetails = certificateService.getCourse(id).get();
		return certificateDetails;
	}
	
	//Saving a certification course detail in database
	@PostMapping("/certificate")
	public boolean saveCertificate(@RequestBody Certificate_Details c3) {
//		Certificate_Details savedCertificate =certificateService.saveCourses(c3);
		return certificateService.saveCourses(c3);
	}
	
	//Deleting a certification course detail in database
	@DeleteMapping("/certificate/{certificateId}")
	public void deleteCertificate(@PathVariable("certificateId") Certificate_Details c3) {
		certificateService.deleteCourse(c3);
	}
	
	//Updating a certification course detail in database
	@PutMapping("/certificate/{certificateId}")
	public Certificate_Details updateCertificate(@PathVariable long certificateId,@RequestBody Certificate_Details c2) {
		return certificateService.updateCourses(certificateId, c2);
	}
}

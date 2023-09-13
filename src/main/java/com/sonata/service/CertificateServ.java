package com.sonata.service;

import com.sonata.model.CertificateDetailsList;
import com.sonata.model.Certificate_Details;

import java.util.Optional;

public interface CertificateServ {

    public CertificateDetailsList getAllCourses();
    public Optional<Certificate_Details> getCourse(long cId);
    public boolean saveCourses(Certificate_Details c3);
    public void deleteCourse(Certificate_Details c3);
    public Certificate_Details updateCourses(long pid,Certificate_Details c3);

}

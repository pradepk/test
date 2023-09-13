package com.sonata;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

 

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sonata.model.Certificate_Details;
import com.sonata.repository.CertificateRepository;

import com.sonata.serviceimpl.CertificateService;
import org.springframework.context.ApplicationContext;

//@RunWith(SpringRunner.class)
@SpringBootTest
class CertificateMicroServiceApplicationTests {
	
	@Autowired
	Certificate_Details certificate;
    @Autowired
    CertificateService certificateService;
    @MockBean
    CertificateRepository certificateRepo;

    @Autowired
    private ApplicationContext context;
    
    @Test
    void contextLoads() {
        assertNotNull(context);


    }
    
    @BeforeEach
    public void initEach(){
    	certificate=new Certificate_Details(3,"Angular",4,"3years","Udemy",500,4);
    	
    	
    }
    
    @Test
     void testGetCertificateId() {
      assertEquals(3, certificate.getCertificateId());
        }
    @Test
    void testGetCourseName() {
        assertEquals("Angular", certificate.getCourseName());
    }

    @Test
    void testGetCriticality() {
        assertEquals(4, certificate.getCriticality());
    }

    @Test
    void testGetValidity() {
        assertEquals("3Years", certificate.getValidity());
    }
    @Test
    void testGetCourse() {
        when(certificateRepo.findAll()).thenReturn(Stream.of(new Certificate_Details(3,"Angular",4,"3Years","Udemy",500,4)).collect(Collectors.toList()));
        assertEquals(1, certificateService.getAllCourses().getCertificateList().size());
    }
    @Test
    void saveCourses() {
        certificate=new Certificate_Details(1,"React Js",3,"2Years","Eudreka",2000,3);
        when(certificateRepo.save(certificate)).thenReturn(certificate);
        assertEquals(certificate,certificateService.saveCourses(certificate));
    }
    @Test
    void deleteCourse() {
    	certificate=new Certificate_Details(3,"Angular",4,"3Years","Udemy",500,4);
        certificateService.deleteCourse(certificate);
        verify(certificateRepo,times(1)).delete(certificate);
    }
    
    @Test
    void getbyid() {
        Certificate_Details e1=new Certificate_Details(3,"Angular",4,"3Years","Udemy",500,4);
        Optional<Certificate_Details> option=certificateRepo.findById(e1.getCertificateId());
        when(certificateRepo.findById(e1.getCertificateId())).thenReturn(option);
        assertEquals(option,certificateService.getCourse(e1.getCertificateId()));
    }
}

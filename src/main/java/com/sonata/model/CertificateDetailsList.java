package com.sonata.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

//Model class for list of certification courses details
@Getter
@Setter

@NoArgsConstructor
@Component
public class CertificateDetailsList {
	
	private List<Certificate_Details> certificateList;
	



}

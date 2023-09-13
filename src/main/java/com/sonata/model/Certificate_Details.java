package com.sonata.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



//Model class of certification courses details
@Component
@Entity
@Getter @Setter

@NoArgsConstructor
@AllArgsConstructor
public class Certificate_Details {
	@Id
	private long certificateId;
	
	private String courseName;

	private int criticality;
	
	private String validity;
	
	private String vendor;
	
	private double cost;
	
	private int score;


}

package com.sonata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CertificateMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CertificateMicroServiceApplication.class, args);
	}

}

package com.revature.eurekaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CmSforceMicroEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmSforceMicroEurekaApplication.class, args);
	}

}

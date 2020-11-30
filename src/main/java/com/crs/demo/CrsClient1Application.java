package com.crs.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class CrsClient1Application {

	@Bean
	public AuditorAware<String> auditorAware(){
		return new SpringSecurityAuditware();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(CrsClient1Application.class, args);
	}

}

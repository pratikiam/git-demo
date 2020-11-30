package com.crs.demo;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class SpringSecurityAuditware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		return Optional.ofNullable("Pratik").filter(s -> !s.isEmpty());
	}

}

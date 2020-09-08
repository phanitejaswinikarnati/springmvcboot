package com.example.springmvcboot;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	@Before("execution( public * getAliens())")
	public void logBefore() {
		LOGGER.info("inside getAliens() method.");
	}
	
	@After("execution( public * getAliens())")
	public void logAfter() {
		LOGGER.info("getAliens() method Executed.");
	}
	
	@AfterReturning("execution( public * getAliens())")
	public void logAfterReturning() {
		LOGGER.info("getAliens() method returned Data.");
	}
	
	@AfterThrowing("execution( public * getAliens())")
	public void logAfterThrowing() {
		LOGGER.info("Error thrown.");
	}
	
	@AfterThrowing("execution( public * com.example.springmvcboot.MyUserDetailsService.loadUserByUsername(*))")
	public void logLoginError() {
		LOGGER.error("User_Not_found error.");
	}

}

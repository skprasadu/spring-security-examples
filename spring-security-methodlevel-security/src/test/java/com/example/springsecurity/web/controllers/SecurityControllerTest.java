package com.example.springsecurity.web.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.springsecurity.service.CalendarService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = WebContextLoader.class, value = { "classpath:/META-INF/spring/services.xml",
		"classpath:/META-INF/spring/security.xml",
		"classpath:/META-INF/spring/mvc-config.xml" })
public class SecurityControllerTest {
	
	@Autowired
	CalendarService calendarService;

	@Test
	public void testMyEvents() throws Exception {
        Authentication auth = new UsernamePasswordAuthenticationToken("user1@example.com", "user1");
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(auth);

        calendarService.findForUser(0);
        SecurityContextHolder.clearContext();
	}
	
	@Test(expected = AuthenticationCredentialsNotFoundException.class)  
	public void testForbiddenEvents() throws Exception {
        calendarService.findForUser(0);
	}
}

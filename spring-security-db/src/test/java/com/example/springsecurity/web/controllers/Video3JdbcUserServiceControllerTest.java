package com.example.springsecurity.web.controllers;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.springsecurity.web.controllers.util.SecurityControllerTest;
import com.example.springsecurity.web.controllers.util.WebContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = WebContextLoader.class, value = { "classpath:/META-INF/spring/video3-jdbc-user-service-config/services.xml",
		"classpath:/META-INF/spring/video3-jdbc-user-service-config/security.xml",
		"classpath:/META-INF/spring/video3-jdbc-user-service-config/mvc-config.xml" })
public class Video3JdbcUserServiceControllerTest extends SecurityControllerTest {
}

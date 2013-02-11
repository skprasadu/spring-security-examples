package com.example.springsecurity.web.controllers;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.springsecurity.web.controllers.util.SecurityControllerTest;
import com.example.springsecurity.web.controllers.util.WebContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = WebContextLoader.class, value = {
		"classpath:/META-INF/spring/video1-spring-inmemory-userdetailservice-config/services.xml",
		"classpath:/META-INF/spring/video1-spring-inmemory-userdetailservice-config/security.xml",
		"classpath:/META-INF/spring/video1-spring-inmemory-userdetailservice-config/mvc-config.xml" })
public class Video1SpringInmemoryUserdetailServiceControllerTest extends SecurityControllerTest {
}

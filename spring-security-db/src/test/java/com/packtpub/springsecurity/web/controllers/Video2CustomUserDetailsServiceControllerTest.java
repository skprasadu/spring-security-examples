package com.packtpub.springsecurity.web.controllers;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.packtpub.springsecurity.web.controllers.util.SecurityControllerTest;
import com.packtpub.springsecurity.web.controllers.util.WebContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = WebContextLoader.class, value = { "classpath:/META-INF/spring/video2-custom-userdetailservice-config/services.xml",
		"classpath:/META-INF/spring/video2-custom-userdetailservice-config/security.xml",
		"classpath:/META-INF/spring/video2-custom-userdetailservice-config/mvc-config.xml", 
		"classpath:/META-INF/spring/video2-custom-userdetailservice-config/ipTokenRepository.xml" })
public class Video2CustomUserDetailsServiceControllerTest extends SecurityControllerTest {
}

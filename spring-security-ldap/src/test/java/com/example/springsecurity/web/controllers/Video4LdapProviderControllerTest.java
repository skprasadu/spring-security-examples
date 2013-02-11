package com.example.springsecurity.web.controllers;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.springsecurity.web.controllers.util.LdapSecurityControllerTest;
import com.example.springsecurity.web.controllers.util.WebContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = WebContextLoader.class, value = { "classpath:/META-INF/spring/video4-ldap-provider-config/services.xml",
		"classpath:/META-INF/spring/video4-ldap-provider-config/security.xml",
		"classpath:/META-INF/spring/video4-ldap-provider-config/mvc-config.xml",
		"classpath:/META-INF/spring/video4-ldap-provider-config/security-ldap-explicitly.xml" })
public class Video4LdapProviderControllerTest extends LdapSecurityControllerTest {
}

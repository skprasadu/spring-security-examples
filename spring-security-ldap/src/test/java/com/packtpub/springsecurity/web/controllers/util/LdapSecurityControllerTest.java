package com.packtpub.springsecurity.web.controllers.util;

import static com.packtpub.springsecurity.web.controllers.util.LdapSecurityRequestPostProcessors.userDeatilsService;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class LdapSecurityControllerTest {

	@Autowired
	private FilterChainProxy springSecurityFilterChain;

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webApplicationContextSetup(this.wac).addFilters(this.springSecurityFilterChain).build();
	}

	@Test
	public void testIndex() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(forwardedUrl("/WEB-INF/views/index.jsp"));
	}

	@Test
	public void testEventsNonAdmin() throws Exception {
		mockMvc.perform(get("/events/").with(userDeatilsService("user1@example.com"))).andExpect(status().isForbidden());
	}

	@Test
	public void testEventsAdminLogin() throws Exception {
		mockMvc.perform(get("/events/").with(userDeatilsService("admin1@example.com"))).andExpect(status().isOk());
	}

	@Test
	public void testMyEvents() throws Exception {
		mockMvc.perform(get("/events/my").with(userDeatilsService("user1@example.com"))).andExpect(status().isOk());
	}

	@Test
	public void testShow() throws Exception {
		mockMvc.perform(get("/events/100").with(userDeatilsService("user1@example.com"))).andExpect(status().isOk());
	}

	@Test
	public void testCreateEventForm() throws Exception {
		mockMvc.perform(
				post("/events/new").param("attendeeEmail", "user1@example.com").param("summary", "krishna").param("description", "whatever")
						.param("when", "2012-01-01 01:02").with(userDeatilsService("user1@example.com"))).andExpect(status().isOk())
				.andExpect(redirectedUrl("/events/my"));
	}
}

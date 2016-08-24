package com.oAuth2SpringSecurity.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.oAuth2SpringSecurity.OAuth2SpringSecurityApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = OAuth2SpringSecurityApplication.class)
@WebAppConfiguration
public class OAuth2SpringSecurityApplicationTests {

	@Test
	public void contextLoads() {
	}

}
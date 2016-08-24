package com.oAuth2SpringSecurity;


/*
 * @Swapnali Shrikhande 
 */

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oAuth2SpringSecurity.Entity.*;
import com.oAuth2SpringSecurity.Repository.BookingRepository;


@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class OAuth2SpringSecurityApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2SpringSecurityApplication.class, args);
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("Admin").password("admin").roles("ADMIN")
        	.and()
        		.withUser("User").password("user").roles("USER")
        	.and()
        		.withUser("Guest").password("guest").roles("GUEST")
	        .and()
				.withUser("Superuser").password("superuser").roles("SUPERUSER");
    }    
	
	/*
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return super.configure(builder);
	}
	*/
}

@Component
class BookingCommandLineRunner implements CommandLineRunner {
	private org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BookingCommandLineRunner.class);

	@Override
	public void run(String... arg0) throws Exception {
		for(Booking b : bookingRepository.findAll()) {
			System.out.println(b.toString());
		}
		logger.info("Booking Service", bookingRepository.getClass());
	}
	
	@Autowired
	BookingRepository bookingRepository;
}
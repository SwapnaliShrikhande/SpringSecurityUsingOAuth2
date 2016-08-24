package com.oAuth2SpringSecurity.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

        @RequestMapping("/test")
        @Secured("ROLE_USER")
        public String hi() {
            return "This API is only available for clients with role as User\n";
        }
        
        //@PreAuthorize("#oauth2-resource.hasScope('read')")
    	//@Secured("hasScope('read')")
    	@RequestMapping("/welcome")
    	public String home() { return "Welcome to Spring Security oAuth2.0!\n"; }
    	
    	@RequestMapping(value="/", method=RequestMethod.POST)
    	@ResponseStatus(HttpStatus.CREATED)
    	public String create(@RequestBody MultiValueMap<String, String> map) { return "Ok"; }
}
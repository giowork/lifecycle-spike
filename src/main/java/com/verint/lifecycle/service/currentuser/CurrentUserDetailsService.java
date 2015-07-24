package com.verint.lifecycle.service.currentuser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.verint.lifecycle.domain.CurrentUser;
import com.verint.lifecycle.domain.User;
import com.verint.lifecycle.service.user.UserService;

@Service
public class CurrentUserDetailsService implements UserDetailsService {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);
    private final UserService userService;
    
    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }
    
    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
    	LOGGER.debug("Authenticating user with email={}", email.replaceFirst("@.*", "@***"));
        User user = userService.getUserByEmail(email);
        
        if (user != null) {
        	return new CurrentUser(user);
        } else {
        	throw new UsernameNotFoundException(String.format("User with email=%s was not found", email));
        }
    }
}

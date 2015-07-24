package com.verint.lifecycle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.verint.lifecycle.domain.CurrentUser;

@ControllerAdvice
public class CurrentUserControllerAdvice {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);

    @ModelAttribute("currentUser")
    public CurrentUser getCurrentUser(Authentication authentication) {
        return (authentication == null) ? null : (CurrentUser) authentication.getPrincipal();
    }
    
}

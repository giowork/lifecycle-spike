package com.verint.lifecycle.service.user;

import java.util.Collection;

import com.verint.lifecycle.domain.User;
import com.verint.lifecycle.domain.UserCreateForm;

public interface UserService {
	
    User getUserById(long id);

    User getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}

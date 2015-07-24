package com.verint.lifecycle.service.currentuser;

import com.verint.lifecycle.domain.CurrentUser;

public interface CurrentUserService {
	
	boolean canAccessUser(CurrentUser currentUser, Long userId);

}

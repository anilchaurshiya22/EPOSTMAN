package edu.mum.waa.epostman.util;

import org.springframework.security.core.context.SecurityContextHolder;

import edu.mum.waa.epostman.domain.User;

public class SecurityUtil {

	public static User getSessionUser() {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		return user;
	}

}

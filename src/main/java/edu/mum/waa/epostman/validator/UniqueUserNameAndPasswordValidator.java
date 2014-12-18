package edu.mum.waa.epostman.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.mum.waa.epostman.domain.User;
import edu.mum.waa.epostman.service.UserService;

@Component
public class UniqueUserNameAndPasswordValidator implements Validator {

	@Autowired
	private UserService userService;
	
	public boolean supports(Class<?> paramClass) {
		return User.class.equals(paramClass);
	}

	public void validate(Object obj, Errors errors) {
		User user = (User) obj;

		User userNameUser = userService.findUserByLoginId(user.getUsername());
		
		if(userNameUser != null)
			errors.rejectValue("username", "unique.username.register");
		
		User emailUser = userService.findUserByEmail(user.getEmail());
		
		if(emailUser != null)
			errors.rejectValue("email", "unique.email.register");
		
	}
}

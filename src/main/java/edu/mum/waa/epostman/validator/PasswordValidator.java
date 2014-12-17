package edu.mum.waa.epostman.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import edu.mum.waa.epostman.domain.User;
import edu.mum.waa.epostman.service.UserService;

@Component
public class PasswordValidator implements Validator {

	@Autowired
	UserService userService;


	public boolean supports(Class<?> paramClass) {
		return User.class.equals(paramClass);
	}

	public void validate(Object obj, Errors errors) {
		User user = (User) obj;
		User oldUser = userService.find(user.getId());
		if (user.getLoginPassword().equals(user.getOldLoginPassword()))
			errors.rejectValue("oldLoginPassword",
					"password.oldnew.match");
		if (!user.getOldLoginPassword().equals(oldUser.getLoginPassword()))
			errors.rejectValue("loginPassword",
					"password.old.mismatch");		
		if(!user.getConfirmLoginPassword().equals(user.getLoginPassword()))
			errors.rejectValue("confirmLoginPassword",
					"password.mismatch");
		
	}
}

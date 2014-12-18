package edu.mum.waa.epostman.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.mum.waa.epostman.domain.User;

@Component
public class ConfirmPasswordValidator implements Validator {

	public boolean supports(Class<?> paramClass) {
		return User.class.equals(paramClass);
	}

	public void validate(Object obj, Errors errors) {
		User user = (User) obj;
		if(!user.getConfirmLoginPassword().equals(user.getLoginPassword()))
			errors.rejectValue("confirmLoginPassword",
					"password.mismatch");
		
	}
}

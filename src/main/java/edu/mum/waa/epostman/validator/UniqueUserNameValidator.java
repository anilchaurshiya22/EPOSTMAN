package edu.mum.waa.epostman.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.waa.epostman.domain.User;
import edu.mum.waa.epostman.service.UserService;

public class UniqueUserNameValidator implements
		ConstraintValidator<UniqueUserName, String> {
	@Autowired
	private UserService userService;

	public void initialize(UniqueUserName constraintAnnotation) {
		// intentionally left blank; this is the place to initialize the constraint annotation for any sensible default values.
	}


	public boolean isValid(String value, ConstraintValidatorContext context) {
		User user = userService.findUserByLoginId(value);
		if(user != null)
			return false;
		else
			return true;
	}
}
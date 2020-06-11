package com.app.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(!((User)o).getPassword().equals(((User)o).getPasswordConfirmation())){
            errors.rejectValue("password", "password.notsame", "passwords are not the same");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "firstname.empty", "Fill the firstname please");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "lastname.empty", "Fill the lastname please");
    }
}

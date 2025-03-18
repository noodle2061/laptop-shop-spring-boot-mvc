package com.javaweb.laptopshop.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.javaweb.laptopshop.domain.dto.RegisterDTO;
import com.javaweb.laptopshop.service.UserService;
import com.javaweb.laptopshop.validator.RegisterChecked;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RegisterValidator implements ConstraintValidator<RegisterChecked, RegisterDTO> {

    @Autowired UserService userService;

    @Override
    public boolean isValid(RegisterDTO user, ConstraintValidatorContext context) {
        boolean valid = true;
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            context.buildConstraintViolationWithTemplate("Password must match")
            .addPropertyNode("confirmPassword")
            .addConstraintViolation()
            .disableDefaultConstraintViolation()            ;
            valid = false;
        }

        if (userService.checkEmailExist(user.getEmail())) {
            context.buildConstraintViolationWithTemplate("Email đã tồn tại")
            .addPropertyNode("email")
            .addConstraintViolation()
            .disableDefaultConstraintViolation();
            valid = false;
        }

        if (!user.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d).{8,}$")) {
            context.buildConstraintViolationWithTemplate("Mật khẩu phải có ít nhất 8 ký tự, chứa ít nhất một chữ cái và một số")
                   .addPropertyNode("password")
                   .addConstraintViolation()
                   .disableDefaultConstraintViolation();
            valid = false;
        }
        

        if (!user.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            context.buildConstraintViolationWithTemplate("Email is not valid")
            .addPropertyNode("email")
            .addConstraintViolation()
            .disableDefaultConstraintViolation();
            valid = false;
        }

        return valid;
    }
    
}

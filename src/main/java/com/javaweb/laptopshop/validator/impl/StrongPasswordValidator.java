package com.javaweb.laptopshop.validator.impl;

import com.javaweb.laptopshop.validator.StrongPassword;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) {
            return false;
        }
        // This regex checks for at least one uppercase letter, one lowercase letter, one digit, and one special character,
        // and ensures the password has at least 8 characters.
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
    }
}

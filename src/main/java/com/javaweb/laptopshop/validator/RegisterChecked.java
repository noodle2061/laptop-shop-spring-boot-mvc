package com.javaweb.laptopshop.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.javaweb.laptopshop.validator.impl.RegisterValidator;

import jakarta.validation.Constraint;

@Constraint(validatedBy = RegisterValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RegisterChecked {
    
    String message() default "Password must match";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}

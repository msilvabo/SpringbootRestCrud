package com.learning.seccion12webapirestful.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class RequieredValidation implements ConstraintValidator<IsRequiered, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
//        return (s != null && !s.isEmpty() && !s.isBlank());
        return StringUtils.hasText(s);
    }
}

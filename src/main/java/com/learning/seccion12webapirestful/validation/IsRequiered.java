package com.learning.seccion12webapirestful.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RequieredValidation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface IsRequiered {
    String message() default "es requerido usando anotaciones";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

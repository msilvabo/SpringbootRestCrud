package com.learning.seccion12webapirestful.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsExistsDbValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsExistsDb {
    String message() default "ya existe valor de Sku en BD";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

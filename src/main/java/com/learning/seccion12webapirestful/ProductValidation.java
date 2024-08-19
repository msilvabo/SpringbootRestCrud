package com.learning.seccion12webapirestful;

import com.learning.seccion12webapirestful.entities.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",null, "es requerido!");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty.product.description");
        if (product.getDescription()==null || product.getDescription().isBlank()) {
            errors.rejectValue("description",null, "es requerido el texto!");
        }
        if (product.getPrice() >= 1000)
        {
            errors.rejectValue("price",null,"debe ser menor o igual a 1000!");
        }
    }
}

package com.joao.book.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class ValidateUtil {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();
    
    public static void validarEntity(Object entity) {
        Set<ConstraintViolation<Object>> violations = validator.validate(entity);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

}

package com.example.hexagonalstudy.common;

import jakarta.validation.*;

import java.util.Set;

public abstract class SelfValidationg<T> {

    private Validator validator;

    public SelfValidationg() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    protected void validateSelf() {
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}

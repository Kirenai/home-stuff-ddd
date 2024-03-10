package me.kirenai.re.validation.exception;

import me.kirenai.re.validation.dto.ErrorResponse;

import java.util.List;

public class ValidatorException extends RuntimeException {

    private final List<ErrorResponse> errorResponses;

    public ValidatorException(List<ErrorResponse> errorResponses) {
        super("Binding Error");
        this.errorResponses = errorResponses;
    }

    public List<ErrorResponse> createError() {
        return this.errorResponses;
    }

}

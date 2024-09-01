package me.kirenai.re.nourishment.domain.exception;

import me.kirenai.re.nourishment.domain.model.dto.ErrorResponse;

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

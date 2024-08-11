package me.kirenai.re.consumption.domain.exception;

import me.kirenai.re.consumption.domain.model.dto.KeycloakUserErrorMessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.time.LocalDateTime;

public class KeycloakUserNotFoundException extends RuntimeException {
    public KeycloakUserNotFoundException(String message) {
        super(message);
    }

    public KeycloakUserErrorMessageResponse createError(ServerRequest serverRequest) {
        return KeycloakUserErrorMessageResponse
                .builder()
                .message(super.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now())
                .path(serverRequest.path())
                .build();
    }
}

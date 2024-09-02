package me.kirenai.re.user.domain.exception;

import me.kirenai.re.user.domain.model.dto.KeycloakServiceUnavailableErrorMessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.time.LocalDateTime;

public class KeycloakServiceUnavailableException extends RuntimeException {
    public KeycloakServiceUnavailableException(String message) {
        super(message);
    }

    public KeycloakServiceUnavailableErrorMessageResponse createError(ServerRequest serverRequest) {
        return KeycloakServiceUnavailableErrorMessageResponse
                .builder()
                .message(super.getMessage())
                .statusCode(HttpStatus.SERVICE_UNAVAILABLE.value())
                .timestamp(LocalDateTime.now())
                .path(serverRequest.path())
                .build();
    }
}

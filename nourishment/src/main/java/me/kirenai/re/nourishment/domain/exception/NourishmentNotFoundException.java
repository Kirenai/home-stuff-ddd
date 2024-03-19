package me.kirenai.re.nourishment.domain.exception;

import me.kirenai.re.nourishment.domain.model.dto.NourishmentErrorMessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.time.LocalDateTime;

public class NourishmentNotFoundException extends RuntimeException {

    public NourishmentNotFoundException(String message) {
        super(message);
    }

    public NourishmentErrorMessageResponse createError(ServerRequest serverRequest) {
        return NourishmentErrorMessageResponse
                .builder()
                .message(super.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now())
                .path(serverRequest.path())
                .build();
    }

}

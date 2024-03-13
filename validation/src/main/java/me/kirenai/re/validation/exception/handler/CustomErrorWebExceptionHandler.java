package me.kirenai.re.validation.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
@Order(-2)
public class CustomErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {

    public CustomErrorWebExceptionHandler(@Qualifier("customErrorAttributes") ErrorAttributes errorAttributes, WebProperties resources,
                                          ApplicationContext applicationContext, ServerCodecConfigurer codecConfigure) {
        super(errorAttributes, resources.getResources(), applicationContext);
        super.setMessageReaders(codecConfigure.getReaders());
        super.setMessageWriters(codecConfigure.getWriters());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(
                RequestPredicates.methods(HttpMethod.POST, HttpMethod.PUT),
                this::renderErrorResponse
        );
    }

    private Mono<ServerResponse> renderErrorResponse(ServerRequest request) {
        log.info("Invoking CustomErrorWebExceptionHandler.renderErrorResponse method");
        Map<String, Object> errorMap = super.getErrorAttributes(request, ErrorAttributeOptions.defaults());
        HttpStatus status = (HttpStatus) Optional.ofNullable(errorMap.get("status")).orElse(HttpStatus.INTERNAL_SERVER_ERROR);
        return ServerResponse
                .status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(errorMap);
    }

}

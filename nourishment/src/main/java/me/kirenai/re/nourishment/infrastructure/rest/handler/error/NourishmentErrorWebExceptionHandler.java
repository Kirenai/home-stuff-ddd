package me.kirenai.re.nourishment.infrastructure.rest.handler.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Slf4j
@Component
@Order(-2)
public class NourishmentErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {


    public NourishmentErrorWebExceptionHandler(@Qualifier("nourishmentErrorAttributes") ErrorAttributes errorAttributes, WebProperties webProperties,
                                               ApplicationContext applicationContext, ServerCodecConfigurer codecConfigurer) {
        super(errorAttributes, webProperties.getResources(), applicationContext);
        super.setMessageReaders(codecConfigurer.getReaders());
        super.setMessageWriters(codecConfigurer.getWriters());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(
                RequestPredicates.methods(GET, PUT, DELETE),
                this::renderErrorResponse
        );
    }

    private Mono<ServerResponse> renderErrorResponse(ServerRequest serverRequest) {
        log.info("Invoking NourishmentErrorWebExceptionHandler#renderErrorResponse(.) method");
        Map<String, Object> errorMap = super.getErrorAttributes(serverRequest, ErrorAttributeOptions.defaults());
        HttpStatus status = (HttpStatus) Optional.ofNullable(errorMap.get("status")).orElse(INTERNAL_SERVER_ERROR);
        return ServerResponse
                .status(status)
                .contentType(APPLICATION_JSON)
                .bodyValue(errorMap);
    }

}

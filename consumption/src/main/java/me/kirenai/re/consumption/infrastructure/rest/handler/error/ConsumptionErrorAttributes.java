package me.kirenai.re.consumption.infrastructure.rest.handler.error;

import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.consumption.domain.exception.ConsumptionNotFoundException;
import me.kirenai.re.consumption.domain.exception.KeycloakUserNotFoundException;
import me.kirenai.re.consumption.domain.exception.ValidatorException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Component
public class ConsumptionErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest serverRequest, ErrorAttributeOptions options) {
        log.info("Invoking ConsumptionErrorAttributes#getErrorAttributes(..) method");
        Map<String, Object> errorAttributes = new LinkedHashMap<>();
        Throwable throwable = super.getError(serverRequest);

        if (throwable instanceof ConsumptionNotFoundException exception) {
            log.error("An error of type ConsumptionNotFoundException occurs");
            errorAttributes.put("error", exception.createError(serverRequest));
            errorAttributes.put("status", HttpStatus.NOT_FOUND);
        } else if (throwable instanceof ValidatorException exception) {
            log.error("An error of type ValidatorException occurs");
            errorAttributes.put("error", exception.createError());
            errorAttributes.put("status", HttpStatus.BAD_REQUEST);
        } else if (throwable instanceof KeycloakUserNotFoundException exception) {
            log.error("An error of type KeycloakUserNotFoundException occurs");
            errorAttributes.put("error", exception.createError(serverRequest));
            errorAttributes.put("status", HttpStatus.NOT_FOUND);
        }

        return errorAttributes;
    }

}

package me.kirenai.re.consumption.infrastructure.rest.handler.error;

import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.consumption.domain.exception.ConsumptionNotFoundException;
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
        log.info("Invoking RoleErrorAttributes#getErrorAttributes(..) method");
        Map<String, Object> errorAttributes = new LinkedHashMap<>();
        Throwable throwable = super.getError(serverRequest);

        if (throwable instanceof ConsumptionNotFoundException exception) {
            log.error("An error of type ConsumptionNotFoundException occurs");
            errorAttributes.put("error", exception.createError(serverRequest));
            errorAttributes.put("status", HttpStatus.NOT_FOUND);
        }

        return errorAttributes;
    }

}

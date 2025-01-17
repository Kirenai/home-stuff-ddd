package me.kirenai.re.category.infrastructure.rest.handler.error;

import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.category.domain.exception.CategoryNotFoundException;
import me.kirenai.re.category.domain.exception.ValidatorException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Component
public class CategoryErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest serverRequest, ErrorAttributeOptions options) {
        log.info("Invoking CategoryErrorAttributes#getErrorAttributes(..) method");
        Map<String, Object> errorAttributes = new LinkedHashMap<>();
        Throwable throwable = super.getError(serverRequest);

        if (throwable instanceof CategoryNotFoundException exception) {
            log.error("An error of type CategoryNotFoundException occurs");
            errorAttributes.put("error", exception.createError(serverRequest));
            errorAttributes.put("status", HttpStatus.NOT_FOUND);
        } else if (throwable instanceof ValidatorException validatorException) {
            log.error("An error of type ValidatorException occurs");
            errorAttributes.put("error", validatorException.createError());
            errorAttributes.put("status", HttpStatus.BAD_REQUEST);
        }

        return errorAttributes;
    }

}

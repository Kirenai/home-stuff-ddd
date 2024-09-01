package me.kirenai.re.nourishment.infrastructure.rest.handler.error;

import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.nourishment.domain.exception.NourishmentNotFoundException;
import me.kirenai.re.nourishment.domain.exception.NourishmentTypeNotFoundException;
import me.kirenai.re.nourishment.domain.exception.ValidatorException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Component
public class NourishmentErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest serverRequest, ErrorAttributeOptions options) {
        log.info("Invoking NourishmentErrorAttributes#getErrorAttributes(..) method");
        Map<String, Object> errorAttributes = new LinkedHashMap<>();
        Throwable throwable = super.getError(serverRequest);

        if (throwable instanceof NourishmentNotFoundException exception) {
            log.error("An error of type NourishmentNotFoundException occurs");
            errorAttributes.put("error", exception.createError(serverRequest));
            errorAttributes.put("status", HttpStatus.NOT_FOUND);
        } else if (throwable instanceof NourishmentTypeNotFoundException exception) {
            log.error("An error of type NourishmentTypeNotFoundException occurs");
            errorAttributes.put("error", exception.createError(serverRequest));
            errorAttributes.put("status", HttpStatus.NOT_FOUND);
        } else if (throwable instanceof ValidatorException exception) {
            log.error("An error of type ValidatorException occurs");
            errorAttributes.put("error", exception.createError());
            errorAttributes.put("status", HttpStatus.BAD_REQUEST);
        }

        return errorAttributes;
    }

}

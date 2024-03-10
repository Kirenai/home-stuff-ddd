package me.kirenai.re.validation.exception.handler;

import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.validation.exception.ValidatorException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        log.info("Invoking CustomErrorAttributes#getErrorAttributes(..) method");
        Map<String, Object> errorAttributes = new LinkedHashMap<>();
        Throwable throwable = super.getError(request);

        if (throwable instanceof ValidatorException exception) {
            log.error("An error of type ValidatorException occurs");
            errorAttributes.put("error", exception.createError());
            errorAttributes.put("status", HttpStatus.BAD_REQUEST);
        }

        return errorAttributes;
    }

}

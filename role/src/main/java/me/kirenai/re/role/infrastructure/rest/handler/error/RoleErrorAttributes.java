package me.kirenai.re.role.infrastructure.rest.handler.error;

import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.role.domain.exception.RoleNotFoundException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Component
public class RoleErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest serverRequest, ErrorAttributeOptions options) {
        log.info("Invoking RoleErrorAttributes#getErrorAttributes(..) method");
        Map<String, Object> errorAttributes = new LinkedHashMap<>();
        Throwable throwable = super.getError(serverRequest);

        if (throwable instanceof RoleNotFoundException exception) {
            log.error("An error of type RoleNotFoundException occurs");
            errorAttributes.put("error", exception.createError(serverRequest));
            errorAttributes.put("status", HttpStatus.NOT_FOUND);
        }

        return errorAttributes;
    }

}

package me.kirenai.re.role.infrastructure.rest.router;

import me.kirenai.re.role.infrastructure.rest.handler.RoleHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RoleRouter {

    private static final String URL = "/roles";

    @Bean
    public RouterFunction<ServerResponse> router(RoleHandler roleHandler) {
        return RouterFunctions.route()
                .GET(URL, roleHandler::findAll)
                .GET(URL + "/{roleId}", roleHandler::findById)
                .GET(URL + "/user/{userId}", roleHandler::findAllByUserId)
                .POST(URL, roleHandler::create)
                .POST(URL + "/user/{userId}", roleHandler::createRoleUser)
                .PUT(URL + "/{roleId}", roleHandler::update)
                .build();
    }

}
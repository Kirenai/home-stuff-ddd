package me.kirenai.re.user.infrastructure.rest.router;

import me.kirenai.re.user.infrastructure.rest.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class UserRouter {

    private static final String PATH = "/users";

    @Bean
    public RouterFunction<ServerResponse> router(UserHandler userHandler) {
        return RouterFunctions.route()
                .GET(PATH, userHandler::findAll)
                .GET(PATH + "/{email}", userHandler::findByEmail)
                .POST(PATH, userHandler::create)
                .PUT(PATH + "/{userId}", userHandler::update)
                .DELETE(PATH + "/{userId}", userHandler::delete)
                .build();
    }

}

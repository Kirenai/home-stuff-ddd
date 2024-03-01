package me.kire.re.consumption.infrastructure.rest.router;

import me.kire.re.consumption.infrastructure.rest.handler.ConsumptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ConsumptionRouter {

    private static final String PATH = "/consumptions";

    @Bean
    public RouterFunction<ServerResponse> router(ConsumptionHandler consumptionHandler) {
        return route()
                .GET(PATH, consumptionHandler::findAll)
                .GET(PATH + "/{consumptionId}", consumptionHandler::findById)
                .POST(PATH + "/user/{userId}/nourishment/{nourishmentId}", consumptionHandler::create)
                .build();
    }

}

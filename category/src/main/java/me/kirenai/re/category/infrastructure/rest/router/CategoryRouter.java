package me.kirenai.re.category.infrastructure.rest.router;

import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.category.infrastructure.rest.handler.CategoryHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Slf4j
@Configuration
public class CategoryRouter {

    private static final String PATH = "/categories";

    @Bean
    public RouterFunction<ServerResponse> router(CategoryHandler handler) {
        return RouterFunctions.route()
                .GET(PATH, handler::findAll)
                .GET(PATH + "/{categoryId}", handler::findById)
                .POST(PATH, handler::create)
                .PUT(PATH + "/{categoryId}", handler::update)
                .DELETE(PATH + "/{categoryId}", handler::delete)
                .build();
    }

}

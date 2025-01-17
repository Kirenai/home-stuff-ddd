package me.kirenai.re.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("users", r -> r.path("/users/**")
                        .filters(f -> f.rewritePath("/users?(?<segment>.*)", "/api/v0/users${segment}"))
                        .uri("lb://USER"))
                .route("roles", r -> r.path("/roles/**")
                        .filters(f -> f.rewritePath("/roles?(?<segment>.*)", "/api/v0/roles${segment}"))
                        .uri("lb://ROLE"))
                .route("nourishments", r -> r.path("/nourishments/**")
                        .filters(f -> f.rewritePath("/nourishments?(?<segment>.*)", "/api/v0/nourishments${segment}"))
                        .uri("lb://NOURISHMENT"))
                .route("consumptions", r -> r.path("/consumptions/**")
                        .filters(f -> f.rewritePath("/consumptions?(?<segment>.*)", "/api/v0/consumptions${segment}"))
                        .uri("lb://CONSUMPTION"))
                .route("categories", r -> r.path("/categories/**")
                        .filters(f -> f.rewritePath("/categories?(?<segment>.*)", "/api/v0/categories${segment}"))
                        .uri("lb://CATEGORY"))
                .build();
    }

}

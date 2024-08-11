package me.kirenai.re.consumption.domain.port.out.client;

import reactor.core.publisher.Mono;

public interface KeycloakClientPort {
    Mono<String> getUserIdByEmail(String email);
}

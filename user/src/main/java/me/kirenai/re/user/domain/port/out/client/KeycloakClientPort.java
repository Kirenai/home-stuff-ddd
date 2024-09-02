package me.kirenai.re.user.domain.port.out.client;

import me.kirenai.re.user.domain.model.User;
import reactor.core.publisher.Mono;

public interface KeycloakClientPort {
    Mono<User> getUserBy(String email);
}

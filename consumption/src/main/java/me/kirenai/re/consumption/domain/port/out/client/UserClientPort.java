package me.kirenai.re.consumption.domain.port.out.client;

import me.kirenai.re.consumption.domain.model.User;
import reactor.core.publisher.Mono;

public interface UserClientPort {
    Mono<User> getUserBy(String email);
}

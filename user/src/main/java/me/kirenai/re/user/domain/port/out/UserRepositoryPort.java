package me.kirenai.re.user.domain.port.out;

import me.kirenai.re.user.domain.model.User;
import reactor.core.publisher.Mono;

public interface UserRepositoryPort {

    Mono<User> findById(Long userId);

    Mono<User> createUser(User user);

}

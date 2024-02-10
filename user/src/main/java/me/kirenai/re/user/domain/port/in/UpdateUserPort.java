package me.kirenai.re.user.domain.port.in;

import me.kirenai.re.user.domain.model.User;
import reactor.core.publisher.Mono;

public interface UpdateUserPort {

    Mono<User> updateUser(Long userId, User user);

}

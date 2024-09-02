package me.kirenai.re.user.domain.port.in;

import me.kirenai.re.user.domain.model.User;
import reactor.core.publisher.Flux;

public interface ListUsersPort {

    Flux<User> getUsers();

}

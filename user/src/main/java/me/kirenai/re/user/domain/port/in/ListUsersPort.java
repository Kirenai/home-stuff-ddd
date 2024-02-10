package me.kirenai.re.user.domain.port.in;

import me.kirenai.re.user.domain.model.User;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public interface ListUsersPort {

    Flux<User> getUsers(Pageable pageable);

}

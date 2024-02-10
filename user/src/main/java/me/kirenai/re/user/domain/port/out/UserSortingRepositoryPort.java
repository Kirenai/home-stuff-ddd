package me.kirenai.re.user.domain.port.out;

import me.kirenai.re.user.domain.model.User;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public interface UserSortingRepositoryPort {

    Flux<User> findAll(Pageable pageable);

}

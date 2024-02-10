package me.kirenai.re.user.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.user.domain.model.User;
import me.kirenai.re.user.domain.port.in.ListUsersPort;
import me.kirenai.re.user.domain.port.out.UserSortingRepositoryPort;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListUsersUseCase implements ListUsersPort {

    private final UserSortingRepositoryPort userSortingRepositoryPort;

    @Override
    public Flux<User> getUsers(Pageable pageable) {
        return this.userSortingRepositoryPort.findAll(pageable);
    }

}

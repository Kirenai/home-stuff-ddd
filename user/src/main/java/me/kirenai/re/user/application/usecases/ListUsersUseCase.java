package me.kirenai.re.user.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.user.domain.model.User;
import me.kirenai.re.user.domain.port.in.ListUsersPort;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListUsersUseCase implements ListUsersPort {

    @Override
    public Flux<User> getUsers() {
        return Flux.empty();
    }

}

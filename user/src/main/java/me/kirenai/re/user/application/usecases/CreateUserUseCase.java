package me.kirenai.re.user.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.user.domain.model.User;
import me.kirenai.re.user.domain.port.in.CreateUserPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateUserUseCase implements CreateUserPort {

    @Override
    public Mono<User> createUser(User user) {
        return Mono.empty();
    }

}

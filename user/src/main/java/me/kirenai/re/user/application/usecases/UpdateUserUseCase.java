package me.kirenai.re.user.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.user.domain.model.User;
import me.kirenai.re.user.domain.port.in.UpdateUserPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateUserUseCase implements UpdateUserPort {

    @Override
    public Mono<User> updateUser(Long userId, User user) {
        return Mono.empty();
    }

}

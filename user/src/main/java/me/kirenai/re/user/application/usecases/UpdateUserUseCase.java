package me.kirenai.re.user.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.user.domain.model.User;
import me.kirenai.re.user.domain.port.in.UpdateUserPort;
import me.kirenai.re.user.domain.port.out.UserRepositoryPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateUserUseCase implements UpdateUserPort {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public Mono<User> updateUser(Long userId, User user) {
        return this.userRepositoryPort.updateUser(userId, user);
    }

}

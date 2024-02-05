package me.kirenai.re.user.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.user.domain.model.User;
import me.kirenai.re.user.domain.port.in.GetUserPort;
import me.kirenai.re.user.domain.port.out.UserRepositoryPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetUserUseCase implements GetUserPort {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public Mono<User> getUserById(Long userId) {
        return this.userRepositoryPort.findById(userId);
    }

}

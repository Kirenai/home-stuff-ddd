package me.kirenai.re.user.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.user.domain.port.in.DeleteUserPort;
import me.kirenai.re.user.domain.port.out.UserRepositoryPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteUserUseCase implements DeleteUserPort {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public Mono<Void> deleteUser(Long userId) {
        return this.userRepositoryPort.deleteUser(userId);
    }

}

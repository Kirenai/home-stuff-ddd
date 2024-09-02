package me.kirenai.re.user.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.user.domain.port.in.DeleteUserPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteUserUseCase implements DeleteUserPort {

    @Override
    public Mono<Void> deleteUser(Long userId) {
        return Mono.empty();
    }

}

package me.kirenai.re.user.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.user.domain.model.User;
import me.kirenai.re.user.domain.port.in.GetUserPort;
import me.kirenai.re.user.domain.port.out.client.KeycloakClientPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetUserUseCase implements GetUserPort {

    private final KeycloakClientPort keycloakClientPort;

    @Override
    public Mono<User> getUserBy(String email) {
        return this.keycloakClientPort.getUserBy(email);
    }

}

package me.kirenai.re.consumption.infrastructure.adapter.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.consumption.domain.exception.KeycloakUserNotFoundException;
import me.kirenai.re.consumption.domain.model.User;
import me.kirenai.re.consumption.domain.model.dto.GetUserResponse;
import me.kirenai.re.consumption.domain.port.out.client.UserClientPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserClientAdapter implements UserClientPort {
    @Qualifier("webClientUser")
    private final WebClient webClient;

    @Override
    public Mono<User> getUserBy(String email) {
        log.info("Invoking UserClientAdapter.getUserBy(email) method");
        return this.webClient
                .get()
                .uri("/api/v0/users/{email}", email)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.error(new KeycloakUserNotFoundException("User not found by email"));
                    }
                    return clientResponse.bodyToMono(GetUserResponse.class);
                })
                .map(getUserResponse -> new User(getUserResponse.userId()));
    }
}

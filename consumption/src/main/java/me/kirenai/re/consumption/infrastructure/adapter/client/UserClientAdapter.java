package me.kirenai.re.consumption.infrastructure.adapter.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.consumption.domain.model.dto.GetUserResponse;
import me.kirenai.re.consumption.domain.port.out.client.UserClientPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
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
    public Mono<GetUserResponse> getUserByUserId(Long userId) {
        log.info("Invoking UserClientAdapter.getUserByUserId method");
        return this.webClient
                .get()
                .uri("/api/v0/users/{userId}", userId)
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(GetUserResponse.class));
    }

}

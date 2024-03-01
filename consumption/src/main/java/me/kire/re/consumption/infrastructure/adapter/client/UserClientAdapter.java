package me.kire.re.consumption.infrastructure.adapter.client;

import lombok.RequiredArgsConstructor;
import me.kire.re.consumption.domain.model.dto.GetUserResponse;
import me.kire.re.consumption.domain.port.out.client.UserClientPort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserClientAdapter implements UserClientPort {

    private final WebClient webClient;

    @Override
    public Mono<GetUserResponse> getUserByUserId(Long userId) {
        return this.webClient
                .get()
                .uri("http://localhost:8081/api/v0/users/{userId}", userId)
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(GetUserResponse.class));
    }

}

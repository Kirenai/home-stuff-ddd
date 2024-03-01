package me.kire.re.consumption.infrastructure.adapter.client;

import lombok.RequiredArgsConstructor;
import me.kire.re.consumption.domain.model.dto.GetNourishmentResponse;
import me.kire.re.consumption.domain.model.dto.UpdateNourishmentRequest;
import me.kire.re.consumption.domain.port.out.client.NourishmentClientPort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class NourishmentClientAdapter implements NourishmentClientPort {

    private final WebClient webClient;

    @Override
    public Mono<GetNourishmentResponse> getNourishmentByNourishmentId(Long nourishmentId) {
        return this.webClient
                .get()
                .uri("http://localhost:8083/api/v0/nourishments/{nourishmentId}", nourishmentId)
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(GetNourishmentResponse.class));
    }

    @Override
    public Mono<Void> updateNourishment(Long nourishmentId, UpdateNourishmentRequest updateNourishmentRequest) {
        return this.webClient
                .put()
                .uri("http://localhost:8083/api/v0/nourishments/{nourishmentId}", nourishmentId)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(updateNourishmentRequest), UpdateNourishmentRequest.class)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(Void.class));
    }

}

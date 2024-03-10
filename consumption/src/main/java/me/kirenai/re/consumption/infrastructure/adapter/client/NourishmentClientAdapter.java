package me.kirenai.re.consumption.infrastructure.adapter.client;

import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.consumption.domain.model.dto.GetNourishmentResponse;
import me.kirenai.re.consumption.domain.model.dto.UpdateNourishmentRequest;
import me.kirenai.re.consumption.domain.port.out.client.NourishmentClientPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class NourishmentClientAdapter implements NourishmentClientPort {

    private final WebClient webClient;

    public NourishmentClientAdapter(@Qualifier("webClientNourishment") WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<GetNourishmentResponse> getNourishmentByNourishmentId(Long nourishmentId) {
        log.info("Invoking NourishmentClientAdapter.getNourishmentByNourishmentId method");
        return this.webClient
                .get()
                .uri("/api/v0/nourishments/{nourishmentId}", nourishmentId)
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(GetNourishmentResponse.class));
    }

    @Override
    public Mono<Void> updateNourishment(Long nourishmentId, UpdateNourishmentRequest updateNourishmentRequest) {
        log.info("Invoking NourishmentClientAdapter.updateNourishment method");
        return this.webClient
                .put()
                .uri("/api/v0/nourishments/{nourishmentId}", nourishmentId)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(updateNourishmentRequest), UpdateNourishmentRequest.class)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(Void.class));
    }

}

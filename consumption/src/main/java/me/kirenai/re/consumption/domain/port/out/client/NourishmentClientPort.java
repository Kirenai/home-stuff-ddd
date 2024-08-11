package me.kirenai.re.consumption.domain.port.out.client;

import me.kirenai.re.consumption.domain.model.dto.GetNourishmentResponse;
import me.kirenai.re.consumption.domain.model.dto.UpdateNourishmentRequest;
import reactor.core.publisher.Mono;

public interface NourishmentClientPort {

    Mono<GetNourishmentResponse> getNourishmentByNourishmentId(String nourishmentId);

    Mono<Void> updateNourishment(String nourishmentId, UpdateNourishmentRequest updateNourishmentRequest);

}

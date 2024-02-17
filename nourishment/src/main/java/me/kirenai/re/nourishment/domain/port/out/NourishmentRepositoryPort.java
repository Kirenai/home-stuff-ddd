package me.kirenai.re.nourishment.domain.port.out;

import me.kirenai.re.nourishment.domain.model.Nourishment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NourishmentRepositoryPort {

    Flux<Nourishment> findAllByIsAvailable(Boolean isAvailable);

    Flux<Nourishment> findAllByUserId(Long userId);

    Mono<Nourishment> findById(Long nourishmentId);

    Mono<Nourishment> createNourishment(Nourishment nourishment);

    Mono<Nourishment> updateNourishment(Long nourishmentId, Nourishment nourishment);

    Mono<Void> deleteNourishment(Long nourishmentId);

}

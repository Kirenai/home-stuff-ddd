package me.kirenai.re.nourishment.domain.port.out.repository;

import me.kirenai.re.nourishment.domain.model.Nourishment;
import reactor.core.publisher.Mono;

public interface NourishmentRepositoryPort {

    Mono<Nourishment> findById(Long nourishmentId);

    Mono<Nourishment> createNourishment(Nourishment nourishment);

    Mono<Nourishment> updateNourishment(Long nourishmentId, Nourishment nourishment);

    Mono<Void> deleteNourishment(Long nourishmentId);

}

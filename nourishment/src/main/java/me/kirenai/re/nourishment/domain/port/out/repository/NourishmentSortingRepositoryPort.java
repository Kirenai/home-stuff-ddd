package me.kirenai.re.nourishment.domain.port.out.repository;

import me.kirenai.re.nourishment.domain.model.Nourishment;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NourishmentSortingRepositoryPort {

    Mono<Long> count();

    Flux<Nourishment> findAll(Pageable pageable);

    Flux<Nourishment> findAllByIsAvailable(Boolean isAvailable, Pageable pageable);

    Flux<Nourishment> findAllByUserId(String userId, Pageable pageable);

}

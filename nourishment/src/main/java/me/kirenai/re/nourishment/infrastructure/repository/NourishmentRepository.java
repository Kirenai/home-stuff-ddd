package me.kirenai.re.nourishment.infrastructure.repository;

import me.kirenai.re.nourishment.infrastructure.entity.NourishmentEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface NourishmentRepository extends ReactiveCrudRepository<NourishmentEntity, Long> {

    Flux<NourishmentEntity> findByIsAvailable(Boolean isAvailable);

    Flux<NourishmentEntity> findByUserId(Long userId);

}
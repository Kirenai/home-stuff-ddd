package me.kirenai.re.nourishment.infrastructure.repository;

import me.kirenai.re.nourishment.infrastructure.entity.NourishmentTypeEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface NourishmentTypeRepository extends ReactiveCrudRepository<NourishmentTypeEntity, Long> {

    Mono<NourishmentTypeEntity> findByName(String name);

}

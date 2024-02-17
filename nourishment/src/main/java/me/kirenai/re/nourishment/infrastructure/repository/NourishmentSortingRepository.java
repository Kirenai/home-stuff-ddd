package me.kirenai.re.nourishment.infrastructure.repository;

import me.kirenai.re.nourishment.infrastructure.entity.NourishmentEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface NourishmentSortingRepository extends ReactiveSortingRepository<NourishmentEntity, Long> {

    Flux<NourishmentEntity> findAllBy(Pageable pageable);

}

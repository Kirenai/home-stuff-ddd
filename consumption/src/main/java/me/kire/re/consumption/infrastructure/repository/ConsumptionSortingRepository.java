package me.kire.re.consumption.infrastructure.repository;

import me.kire.re.consumption.infrastructure.entity.ConsumptionEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

/**
 * ConsumptionSortingRepository
 *
 * @author Kirenai
 */
public interface ConsumptionSortingRepository extends ReactiveSortingRepository<ConsumptionEntity, Long> {

    Flux<ConsumptionEntity> findAllBy(Pageable pageable);

}

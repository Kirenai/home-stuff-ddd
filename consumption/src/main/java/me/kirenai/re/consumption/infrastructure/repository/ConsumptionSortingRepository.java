package me.kirenai.re.consumption.infrastructure.repository;

import me.kirenai.re.consumption.infrastructure.entity.ConsumptionEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * ConsumptionSortingRepository
 *
 * @author Kirenai
 */
public interface ConsumptionSortingRepository extends ReactiveMongoRepository<ConsumptionEntity, String> {

    Flux<ConsumptionEntity> findAllBy(Pageable pageable);

}

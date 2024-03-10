package me.kirenai.re.consumption.infrastructure.repository;

import me.kirenai.re.consumption.infrastructure.entity.ConsumptionEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * ConsumptionRepository
 *
 * @author Kirenai
 */
public interface ConsumptionRepository extends ReactiveCrudRepository<ConsumptionEntity, Long> {
}

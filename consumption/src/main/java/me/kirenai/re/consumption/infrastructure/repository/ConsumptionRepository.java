package me.kirenai.re.consumption.infrastructure.repository;

import me.kirenai.re.consumption.infrastructure.entity.ConsumptionEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * ConsumptionRepository
 *
 * @author Kirenai
 */
public interface ConsumptionRepository extends ReactiveMongoRepository<ConsumptionEntity, String> {
}

package me.kirenai.re.consumption.infrastructure.adapter.repository;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.consumption.domain.exception.ConsumptionNotFoundException;
import me.kirenai.re.consumption.domain.model.Consumption;
import me.kirenai.re.consumption.domain.port.out.repository.ConsumptionRepositoryPort;
import me.kirenai.re.consumption.infrastructure.mapper.ConsumptionMapper;
import me.kirenai.re.consumption.infrastructure.repository.ConsumptionRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ConsumptionRepositoryAdapter implements ConsumptionRepositoryPort {

    private final ConsumptionRepository consumptionRepository;
    private final ConsumptionMapper mapper;

    @Override
    public Mono<Consumption> findById(Long consumptionId) {
        return this.consumptionRepository.findById(consumptionId)
                .switchIfEmpty(Mono.error(new ConsumptionNotFoundException(String.format("Consumption not found with id: %d", consumptionId))))
                .map(this.mapper::mapOutConsumptionEntityToConsumption);
    }

    @Override
    public Mono<Consumption> createConsumption(Consumption consumption) {
        return Mono.just(this.mapper.mapInConsumptionToConsumptionEntity(consumption))
                .flatMap(this.consumptionRepository::save)
                .map(this.mapper::mapOutConsumptionEntityToConsumption);
    }

}

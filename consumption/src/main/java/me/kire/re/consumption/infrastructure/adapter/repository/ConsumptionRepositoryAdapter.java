package me.kire.re.consumption.infrastructure.adapter.repository;

import lombok.RequiredArgsConstructor;
import me.kire.re.consumption.domain.model.Consumption;
import me.kire.re.consumption.domain.port.out.repository.ConsumptionRepositoryPort;
import me.kire.re.consumption.infrastructure.mapper.ConsumptionMapper;
import me.kire.re.consumption.infrastructure.repository.ConsumptionRepository;
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
                .map(this.mapper::mapOutConsumptionEntityToConsumption);
    }

    @Override
    public Mono<Consumption> createConsumption(Consumption consumption) {
        return Mono.just(this.mapper.mapInConsumptionToConsumptionEntity(consumption))
                .flatMap(this.consumptionRepository::save)
                .map(this.mapper::mapOutConsumptionEntityToConsumption);
    }

}

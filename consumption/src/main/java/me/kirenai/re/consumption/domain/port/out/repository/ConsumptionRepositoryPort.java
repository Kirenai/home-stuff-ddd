package me.kirenai.re.consumption.domain.port.out.repository;

import me.kirenai.re.consumption.domain.model.Consumption;
import reactor.core.publisher.Mono;

public interface ConsumptionRepositoryPort {

    Mono<Consumption> findById(Long consumptionId);

    Mono<Consumption> createConsumption(Consumption consumption);

}

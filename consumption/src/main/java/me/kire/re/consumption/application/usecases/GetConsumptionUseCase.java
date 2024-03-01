package me.kire.re.consumption.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kire.re.consumption.domain.model.Consumption;
import me.kire.re.consumption.domain.port.in.GetConsumptionPort;
import me.kire.re.consumption.domain.port.out.repository.ConsumptionRepositoryPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetConsumptionUseCase implements GetConsumptionPort {

    private final ConsumptionRepositoryPort consumptionRepositoryPort;

    @Override
    public Mono<Consumption> getConsumptionById(Long consumptionId) {
        return this.consumptionRepositoryPort.findById(consumptionId);
    }

}

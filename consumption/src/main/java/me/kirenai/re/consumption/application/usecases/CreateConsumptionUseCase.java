package me.kirenai.re.consumption.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.consumption.domain.model.Consumption;
import me.kirenai.re.consumption.domain.port.in.CreateConsumptionPort;
import me.kirenai.re.consumption.domain.port.out.repository.ConsumptionRepositoryPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateConsumptionUseCase implements CreateConsumptionPort {

    private final ConsumptionRepositoryPort consumptionRepositoryPort;

    @Override
    public Mono<Consumption> execute(Consumption consumption) {
        return this.consumptionRepositoryPort.createConsumption(consumption);
    }

}

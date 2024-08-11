package me.kirenai.re.consumption.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.consumption.domain.model.Consumption;
import me.kirenai.re.consumption.domain.port.in.GetConsumptionPort;
import me.kirenai.re.consumption.domain.port.out.repository.ConsumptionRepositoryPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetConsumptionUseCase implements GetConsumptionPort {

    private final ConsumptionRepositoryPort consumptionRepositoryPort;

    @Override
    public Mono<Consumption> execute(String consumptionId) {
        return this.consumptionRepositoryPort.findById(consumptionId);
    }

}

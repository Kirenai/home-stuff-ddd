package me.kire.re.consumption.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kire.re.consumption.domain.model.Consumption;
import me.kire.re.consumption.domain.port.in.ListConsumptionsPort;
import me.kire.re.consumption.domain.port.out.repository.ConsumptionSortingRepositoryPort;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListConsumptionsUseCase implements ListConsumptionsPort {

    private final ConsumptionSortingRepositoryPort consumptionSortingRepositoryPort;

    @Override
    public Flux<Consumption> getConsumptions(Pageable pageable) {
        return this.consumptionSortingRepositoryPort.findAll(pageable);
    }

}

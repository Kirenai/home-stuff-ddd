package me.kirenai.re.consumption.infrastructure.adapter.repository;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.consumption.domain.model.Consumption;
import me.kirenai.re.consumption.domain.port.out.repository.ConsumptionSortingRepositoryPort;
import me.kirenai.re.consumption.infrastructure.mapper.ConsumptionMapper;
import me.kirenai.re.consumption.infrastructure.repository.ConsumptionSortingRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class ConsumptionSortingRepositoryAdapter implements ConsumptionSortingRepositoryPort {

    private final ConsumptionSortingRepository consumptionSortingRepository;
    private final ConsumptionMapper mapper;

    @Override
    public Flux<Consumption> findAll(Pageable pageable) {
        return this.consumptionSortingRepository.findAllBy(pageable)
                .map(this.mapper::mapOutConsumptionEntityToConsumption);
    }

}

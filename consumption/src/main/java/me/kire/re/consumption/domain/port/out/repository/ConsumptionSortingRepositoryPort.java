package me.kire.re.consumption.domain.port.out.repository;

import me.kire.re.consumption.domain.model.Consumption;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public interface ConsumptionSortingRepositoryPort {

    Flux<Consumption> findAll(Pageable pageable);

}

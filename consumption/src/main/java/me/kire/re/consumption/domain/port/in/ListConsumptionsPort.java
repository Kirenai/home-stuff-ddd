package me.kire.re.consumption.domain.port.in;

import me.kire.re.consumption.domain.model.Consumption;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public interface ListConsumptionsPort {

    Flux<Consumption> getConsumptions(Pageable pageable);

}

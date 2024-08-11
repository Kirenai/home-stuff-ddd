package me.kirenai.re.consumption.domain.port.in;

import me.kirenai.re.consumption.domain.model.Consumption;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public interface ListConsumptionsPort {

    Flux<Consumption> execute(Pageable pageable);

}

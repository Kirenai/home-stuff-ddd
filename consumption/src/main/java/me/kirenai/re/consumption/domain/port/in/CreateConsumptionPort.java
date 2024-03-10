package me.kirenai.re.consumption.domain.port.in;

import me.kirenai.re.consumption.domain.model.Consumption;
import reactor.core.publisher.Mono;

public interface CreateConsumptionPort {

    Mono<Consumption> createConsumption(Consumption consumption);

}

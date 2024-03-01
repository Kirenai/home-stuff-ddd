package me.kire.re.consumption.domain.port.in;

import me.kire.re.consumption.domain.model.Consumption;
import reactor.core.publisher.Mono;

public interface CreateConsumptionPort {

    Mono<Consumption> createConsumption(Consumption consumption);

}

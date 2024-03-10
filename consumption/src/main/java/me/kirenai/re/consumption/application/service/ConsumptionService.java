package me.kirenai.re.consumption.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.consumption.domain.model.Consumption;
import me.kirenai.re.consumption.domain.model.dto.UpdateNourishmentRequest;
import me.kirenai.re.consumption.domain.port.in.CreateConsumptionPort;
import me.kirenai.re.consumption.domain.port.in.GetConsumptionPort;
import me.kirenai.re.consumption.domain.port.in.ListConsumptionsPort;
import me.kirenai.re.consumption.domain.port.out.client.NourishmentClientPort;
import me.kirenai.re.consumption.domain.port.out.client.UserClientPort;
import me.kirenai.re.consumption.util.ConsumptionProcess;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class ConsumptionService {

    private final GetConsumptionPort getConsumptionPort;
    private final ListConsumptionsPort listConsumptionsPort;
    private final CreateConsumptionPort createConsumptionPort;
    private final UserClientPort userClientPort;
    private final NourishmentClientPort nourishmentClientPort;

    public Flux<Consumption> getConsumptions(Pageable pageable) {
        log.info("Invoking ConsumptionService.getConsumptions method");
        return this.listConsumptionsPort.getConsumptions(pageable);
    }

    public Mono<Consumption> getConsumptionById(Long consumptionId) {
        log.info("Invoking ConsumptionService.getConsumptionById method");
        return this.getConsumptionPort.getConsumptionById(consumptionId);
    }

    public Mono<Consumption> createConsumption(Long userId, Long nourishmentId, Consumption consumption) {
        log.info("Invoking ConsumptionService.createConsumption method");
        return this.userClientPort.getUserByUserId(userId)
                .flatMap(userResponse -> {
                    consumption.setUserId(userResponse.userId());
                    return this.nourishmentClientPort.getNourishmentByNourishmentId(nourishmentId);
                })
                .flatMap(nourishmentResponse -> {
                    consumption.setNourishmentId(nourishmentResponse.nourishmentId());
                    ConsumptionProcess consumptionProcess = new ConsumptionProcess(consumption);
                    UpdateNourishmentRequest nourishmentRequest = consumptionProcess.consumeToUpdateNourishmentRequest(nourishmentResponse);
                    return this.nourishmentClientPort.updateNourishment(nourishmentResponse.nourishmentId(), nourishmentRequest);
                })
                .then(this.createConsumptionPort.createConsumption(consumption));
    }

}
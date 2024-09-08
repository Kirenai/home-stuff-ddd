package me.kirenai.re.consumption.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.consumption.domain.model.Consumption;
import me.kirenai.re.consumption.domain.model.dto.UpdateNourishmentRequest;
import me.kirenai.re.consumption.domain.port.in.CreateConsumptionPort;
import me.kirenai.re.consumption.domain.port.in.GetConsumptionPort;
import me.kirenai.re.consumption.domain.port.in.ListConsumptionsPort;
import me.kirenai.re.consumption.domain.port.out.client.UserClientPort;
import me.kirenai.re.consumption.domain.port.out.client.NourishmentClientPort;
import me.kirenai.re.consumption.domain.service.ConsumptionProcess;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class ConsumptionService {

    private final GetConsumptionPort getConsumptionPort;
    private final ListConsumptionsPort listConsumptionsPort;
    private final CreateConsumptionPort createConsumptionPort;
    private final NourishmentClientPort nourishmentClientPort;
    private final UserClientPort userClientPort;

    public Flux<Consumption> getConsumptions(Pageable pageable) {
        log.info("Invoking ConsumptionService.getConsumptions method");
        return this.listConsumptionsPort.execute(pageable);
    }

    public Mono<Consumption> getConsumptionById(String consumptionId) {
        log.info("Invoking ConsumptionService.getConsumptionById method");
        return this.getConsumptionPort.execute(consumptionId);
    }

    @Transactional
    public Mono<Consumption> createConsumption(String email, String nourishmentId, Consumption consumption) {
        log.info("Invoking ConsumptionService.createConsumption method");
        return this.userClientPort.getUserBy(email)
                .flatMap(user -> {
                    consumption.setUserId(user.userId());
                    return this.nourishmentClientPort.getNourishmentBy(nourishmentId);
                })
                .flatMap(nourishmentResponse -> {
                    consumption.setNourishmentId(nourishmentResponse.nourishmentId());
                    ConsumptionProcess consumptionProcess = new ConsumptionProcess(consumption);
                    UpdateNourishmentRequest nourishmentRequest = consumptionProcess.consumeToUpdateNourishmentRequest(nourishmentResponse);
                    return this.nourishmentClientPort.updateNourishment(nourishmentResponse.nourishmentId(), nourishmentRequest)
                            .then(this.createConsumptionPort.execute(consumption));
                });
    }

}
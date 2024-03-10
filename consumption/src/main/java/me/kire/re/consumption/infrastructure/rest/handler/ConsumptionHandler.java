package me.kire.re.consumption.infrastructure.rest.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kire.re.consumption.application.service.ConsumptionService;
import me.kire.re.consumption.domain.model.dto.CreateConsumptionRequest;
import me.kire.re.consumption.domain.model.dto.ListConsumptionsResponse;
import me.kire.re.consumption.infrastructure.mapper.ConsumptionMapper;
import me.kirenai.re.validation.Validator;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.server.ServerResponse.status;

@Slf4j
@Component
@RequiredArgsConstructor
public class ConsumptionHandler {

    private final ConsumptionService consumptionService;
    private final ConsumptionMapper mapper;
    private final Validator validator;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        log.info("Invoking ConsumptionHandler.findAll method");
        int page = Integer.parseInt(request.queryParam("page").orElse("0"));
        int size = Integer.parseInt(request.queryParam("size").orElse("6"));
        String[] sort = request.queryParam("sort").orElse("consumptionId,ASC").split(",");
        PageRequest pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(sort[1]), sort[0]));
        Flux<ListConsumptionsResponse> response = this.consumptionService.getConsumptions(pageable)
                .map(this.mapper::mapOutConsumptionToListConsumptionsResponse);
        return ok().contentType(APPLICATION_JSON).body(response, ListConsumptionsResponse.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        log.info("Invoking ConsumptionHandler.findById method");
        String consumptionId = request.pathVariable("consumptionId");
        return this.consumptionService.getConsumptionById(Long.valueOf(consumptionId))
                .map(this.mapper::mapOutConsumptionToGetConsumptionResponse)
                .flatMap(consumptionResponse -> ok()
                        .contentType(APPLICATION_JSON)
                        .bodyValue(consumptionResponse));
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        log.info("Invoking ConsumptionHandler.create method");
        String userId = request.pathVariable("userId");
        String nourishmentId = request.pathVariable("nourishmentId");
        return request.bodyToMono(CreateConsumptionRequest.class)
                .doOnNext(this.validator::validate)
                .map(this.mapper::mapInCreateConsumptionRequestToConsumption)
                .flatMap(consumption -> this.consumptionService.createConsumption(
                        Long.valueOf(userId),
                        Long.valueOf(nourishmentId),
                        consumption
                ))
                .map(this.mapper::mapOutConsumptionToCreateConsumptionResponse)
                .flatMap(consumptionResponse -> status(HttpStatus.CREATED)
                        .contentType(APPLICATION_JSON)
                        .bodyValue(consumptionResponse));
    }

}

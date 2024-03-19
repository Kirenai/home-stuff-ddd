package me.kirenai.re.nourishment.infrastructure.rest.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.nourishment.application.service.NourishmentService;
import me.kirenai.re.nourishment.domain.model.dto.CreateNourishmentRequest;
import me.kirenai.re.nourishment.domain.model.dto.ListNourishmentsResponse;
import me.kirenai.re.nourishment.domain.model.dto.UpdateNourishmentRequest;
import me.kirenai.re.nourishment.infrastructure.mapper.NourishmentMapper;
import me.kirenai.re.validation.Validator;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class NourishmentHandler {

    private final NourishmentService nourishmentService;
    private final NourishmentMapper mapper;
    private final Validator validator;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        log.info("Invoking NourishmentHandler.findAll method");
        int page = Integer.parseInt(request.queryParam("page").orElse("0"));
        int size = Integer.parseInt(request.queryParam("size").orElse("5"));
        String[] sort = request.queryParam("sort").orElse("nourishmentId,ASC").split(",");
        PageRequest pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(sort[1]), sort[0]));
        Flux<ListNourishmentsResponse> response = this.nourishmentService.getNourishments(pageable)
                .flatMap(this.mapper::mapOutNourishmentToListNourishmentsResponse);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(response, ListNourishmentsResponse.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        log.info("Invoking NourishmentHandler.findById method");
        String nourishmentId = request.pathVariable("nourishmentId");
        return this.nourishmentService.getNourishmentById(Long.valueOf(nourishmentId))
                .flatMap(this.mapper::mapOutNourishmentToGetNourishmentResponse)
                .flatMap(response -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(response));
    }

    public Mono<ServerResponse> findAllByUserId(ServerRequest request) {
        log.info("Invoking NourishmentHandler.findAllByUserId method");
        int page = Integer.parseInt(request.queryParam("page").orElse("0"));
        int size = Integer.parseInt(request.queryParam("size").orElse("3"));
        String[] sort = request.queryParam("sort").orElse("nourishmentId,ASC").split(",");
        PageRequest pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(sort[1]), sort[0]));
        String userId = request.pathVariable("userId");
        Flux<ListNourishmentsResponse> response = this.nourishmentService.getNourishmentsByUserId(Long.valueOf(userId), pageable)
                .flatMap(this.mapper::mapOutNourishmentToListNourishmentsResponse);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(response, ListNourishmentsResponse.class);
    }

    public Mono<ServerResponse> findAllByIsAvailable(ServerRequest request) {
        log.info("Invoking NourishmentHandler.findAllByIsAvailable method");
        String isAvailable = request.pathVariable("isAvailable");
        int page = Integer.parseInt(request.queryParam("page").orElse("0"));
        int size = Integer.parseInt(request.queryParam("size").orElse("4"));
        String[] sort = request.queryParam("sort").orElse("nourishmentId,ASC").split(",");
        PageRequest pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(sort[1]), sort[0]));
        Flux<ListNourishmentsResponse> response = this.nourishmentService.getNourishmentsByIsAvailable(Boolean.valueOf(isAvailable), pageable)
                .flatMap(this.mapper::mapOutNourishmentToListNourishmentsResponse);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(response, ListNourishmentsResponse.class);
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        log.info("Invoking NourishmentHandler.create method");
        String userId = request.pathVariable("userId");
        String categoryId = request.pathVariable("categoryId");
        return request.bodyToMono(CreateNourishmentRequest.class)
                .doOnNext(this.validator::validate)
                .flatMap(this.mapper::mapInCreateNourishmentRequestToNourishment)
                .flatMap(nourishment -> this.nourishmentService
                        .createNourishment(Long.valueOf(userId), Long.valueOf(categoryId), nourishment))
                .flatMap(response -> ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(response));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        log.info("Invoking NourishmentHandler.update method");
        String nourishmentId = request.pathVariable("nourishmentId");
        return request.bodyToMono(UpdateNourishmentRequest.class)
                .doOnNext(this.validator::validate)
                .flatMap(this.mapper::mapInUpdateNourishmentRequestToNourishment)
                .flatMap(nourishment -> this.nourishmentService
                        .updateNourishment(Long.valueOf(nourishmentId), nourishment))
                .flatMap(response -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(response));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        log.info("Invoking NourishmentHandler.delete method");
        String nourishmentId = request.pathVariable("nourishmentId");
        return this.nourishmentService.deleteNourishment(Long.valueOf(nourishmentId))
                .then(Mono.defer(() -> ServerResponse.ok().bodyValue(Mono.empty())));
    }

}
package me.kirenai.re.nourishment.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.nourishment.domain.model.Nourishment;
import me.kirenai.re.nourishment.domain.port.in.*;
import org.springframework.data.domain.PageRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class NourishmentService {

    private final GetNourishmentPort getNourishmentPort;
    private final ListNourishmentsPort listNourishmentsPort;
    private final CreateNourishmentPort createNourishmentPort;
    private final UpdateNourishmentPort updateNourishmentPort;
    private final DeleteNourishmentPort deleteNourishmentPort;

    public Flux<Nourishment> getNourishments(PageRequest pageable) {
        log.info("Invoking NourishmentService.getNourishments method");
        return this.listNourishmentsPort.getNourishments(pageable);
    }

    public Mono<Nourishment> getNourishmentById(Long nourishmentId) {
        log.info("Invoking NourishmentService.getNourishmentById method");
        return this.getNourishmentPort.findById(nourishmentId);
    }

    public Flux<Nourishment> getNourishmentsByUserId(Long userId) {
        log.info("Invoking NourishmentService.getNourishmentsByUserId method");
        return this.listNourishmentsPort.getNourishmentsByUserId(userId);
    }

    public Flux<Nourishment> getNourishmentsByIsAvailable(Boolean isAvailable) {
        log.info("Invoking NourishmentService.getNourishmentsByIsAvailable method");
        return this.listNourishmentsPort.getNourishmentsByIsAvailable(isAvailable);
    }

    public Mono<Nourishment> createNourishment(Long userId, Long categoryId, Nourishment nourishment) {
        log.info("Invoking NourishmentService.create method");
        // TODO: call user and category services
        nourishment.setIsAvailable(Boolean.TRUE);
        return this.createNourishmentPort.createNourishment(nourishment);
    }

    public Mono<Nourishment> updateNourishment(Long nourishmentId, Nourishment nourishment) {
        log.info("Invoking NourishmentService.update method");
        return this.updateNourishmentPort.updateNourishment(nourishmentId, nourishment);
    }

    public Mono<Void> deleteNourishment(Long nourishmentId) {
        log.info("Invoking NourishmentService.deleteNourishment method");
        return this.deleteNourishmentPort.deleteNourishment(nourishmentId);
    }

}
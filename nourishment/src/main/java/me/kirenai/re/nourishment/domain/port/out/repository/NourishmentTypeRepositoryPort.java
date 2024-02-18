package me.kirenai.re.nourishment.domain.port.out.repository;

import me.kirenai.re.nourishment.domain.model.NourishmentType;
import reactor.core.publisher.Mono;

public interface NourishmentTypeRepositoryPort {

    Mono<NourishmentType> findById(Long nourishmentTypeId);

    Mono<NourishmentType> findByName(String name);

}

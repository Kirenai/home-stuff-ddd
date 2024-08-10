package me.kirenai.re.nourishment.infrastructure.adapter.repository;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.nourishment.domain.exception.NourishmentNotFoundException;
import me.kirenai.re.nourishment.domain.model.Nourishment;
import me.kirenai.re.nourishment.domain.port.out.repository.NourishmentRepositoryPort;
import me.kirenai.re.nourishment.infrastructure.mapper.out.MongoNourishmentMapper;
import me.kirenai.re.nourishment.infrastructure.repository.MongoNourishmentRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class MongoNourishmentRepositoryAdapter implements NourishmentRepositoryPort {

    private final MongoNourishmentRepository mongoNourishmentRepository;
    private final MongoNourishmentMapper mapper;

    @Override
    public Mono<Nourishment> findById(String nourishmentId) {
        return this.mongoNourishmentRepository.findById(nourishmentId)
                .switchIfEmpty(Mono.error(new NourishmentNotFoundException(String.format("Nourishment not found by id: %s", nourishmentId))))
                .map(this.mapper::mapOutNourishmentEntityToNourishment);
    }

    @Override
    public Mono<Nourishment> createNourishment(Nourishment nourishment) {
        return Mono.just(this.mapper.mapInNourishmentToNourishmentEntity(nourishment))
                .flatMap(this.mongoNourishmentRepository::save)
                .map(this.mapper::mapOutNourishmentEntityToNourishment);
    }

    @Override
    public Mono<Nourishment> updateNourishment(String nourishmentId, Nourishment nourishment) {
        return this.mongoNourishmentRepository.findById(nourishmentId)
                .switchIfEmpty(Mono.error(new NourishmentNotFoundException(String.format("Nourishment not found by id: %s", nourishmentId))))
                .map(nourishmentEntity -> {
                    nourishmentEntity.setName(nourishment.getName());
                    nourishmentEntity.setDescription(nourishment.getDescription());
                    nourishmentEntity.setImageUrl(nourishment.getImageUrl());
                    nourishmentEntity.setNourishmentType(nourishment.getNourishmentType());
                    return nourishmentEntity;
                })
                .flatMap(this.mongoNourishmentRepository::save)
                .map(this.mapper::mapOutNourishmentEntityToNourishment);
    }

    @Override
    public Mono<Void> deleteNourishment(String nourishmentId) {
        return this.mongoNourishmentRepository.findById(nourishmentId)
                .switchIfEmpty(Mono.error(new NourishmentNotFoundException(String.format("Nourishment not found by id: %s", nourishmentId))))
                .flatMap(this.mongoNourishmentRepository::delete);
    }

}

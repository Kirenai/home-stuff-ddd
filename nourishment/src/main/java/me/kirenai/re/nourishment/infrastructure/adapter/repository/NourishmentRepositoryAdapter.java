package me.kirenai.re.nourishment.infrastructure.adapter.repository;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.nourishment.domain.exception.NourishmentNotFoundException;
import me.kirenai.re.nourishment.domain.model.Nourishment;
import me.kirenai.re.nourishment.domain.port.out.repository.NourishmentRepositoryPort;
import me.kirenai.re.nourishment.infrastructure.mapper.NourishmentMapper;
import me.kirenai.re.nourishment.infrastructure.repository.NourishmentRepository;
import me.kirenai.re.nourishment.util.MapperUtils;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class NourishmentRepositoryAdapter implements NourishmentRepositoryPort {

    private final NourishmentRepository nourishmentRepository;
    private final NourishmentMapper mapper;

    @Override
    public Mono<Nourishment> findById(Long nourishmentId) {
        return this.nourishmentRepository.findById(nourishmentId)
                .switchIfEmpty(Mono.error(new NourishmentNotFoundException(String.format("Nourishment not found by id: %d", nourishmentId))))
                .map(this.mapper::mapOutNourishmentEntityToNourishment);
    }

    @Override
    public Mono<Nourishment> createNourishment(Nourishment nourishment) {
        return Mono.just(this.mapper.mapInNourishmentToNourishmentEntity(nourishment))
                .flatMap(this.nourishmentRepository::save)
                .map(this.mapper::mapOutNourishmentEntityToNourishment);
    }

    @Override
    public Mono<Nourishment> updateNourishment(Long nourishmentId, Nourishment nourishment) {
        return this.nourishmentRepository.findById(nourishmentId)
                .switchIfEmpty(Mono.error(new NourishmentNotFoundException(String.format("Nourishment not found by id: %d", nourishmentId))))
                .map(nourishmentEntity -> MapperUtils.loadNourishmentToNourishmentEntityByReference(nourishment, nourishmentEntity))
                .map(this.mapper::mapOutNourishmentEntityToNourishment);
    }

    @Override
    public Mono<Void> deleteNourishment(Long nourishmentId) {
        return this.nourishmentRepository.findById(nourishmentId)
                .switchIfEmpty(Mono.error(new NourishmentNotFoundException(String.format("Nourishment not found by id: %d", nourishmentId))))
                .flatMap(this.nourishmentRepository::delete);
    }

}

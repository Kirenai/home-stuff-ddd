package me.kirenai.re.nourishment.infrastructure.adapter.repository;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.nourishment.domain.model.NourishmentType;
import me.kirenai.re.nourishment.domain.port.out.repository.NourishmentTypeRepositoryPort;
import me.kirenai.re.nourishment.infrastructure.mapper.NourishmentTypeMapper;
import me.kirenai.re.nourishment.infrastructure.repository.NourishmentTypeRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class NourishmentTypeRepositoryAdapter implements NourishmentTypeRepositoryPort {

    private final NourishmentTypeRepository nourishmentTypeRepository;
    private final NourishmentTypeMapper mapper;

    @Override
    public Mono<NourishmentType> findById(Long nourishmentTypeId) {
        return this.nourishmentTypeRepository.findById(nourishmentTypeId)
                .map(this.mapper::mapOutNourishmentTypeToNourishment);
    }

    @Override
    public Mono<NourishmentType> findByName(String name) {
        return this.nourishmentTypeRepository.findByName(name)
                .map(this.mapper::mapOutNourishmentTypeToNourishment);
    }

}

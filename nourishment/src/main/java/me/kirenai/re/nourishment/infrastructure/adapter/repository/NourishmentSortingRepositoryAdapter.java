package me.kirenai.re.nourishment.infrastructure.adapter.repository;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.nourishment.domain.model.Nourishment;
import me.kirenai.re.nourishment.domain.port.out.repository.NourishmentSortingRepositoryPort;
import me.kirenai.re.nourishment.infrastructure.mapper.NourishmentMapper;
import me.kirenai.re.nourishment.infrastructure.repository.NourishmentSortingRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class NourishmentSortingRepositoryAdapter implements NourishmentSortingRepositoryPort {

    private final NourishmentSortingRepository nourishmentSortingRepository;
    private final NourishmentMapper mapper;

    @Override
    public Flux<Nourishment> findAll(Pageable pageable) {
        return this.nourishmentSortingRepository.findAllBy(pageable)
                .map(this.mapper::mapOutNourishmentEntityToNourishment);
    }

}

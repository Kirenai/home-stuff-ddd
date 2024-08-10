package me.kirenai.re.nourishment.infrastructure.adapter.repository;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.nourishment.domain.model.Nourishment;
import me.kirenai.re.nourishment.domain.port.out.repository.NourishmentSortingRepositoryPort;
import me.kirenai.re.nourishment.infrastructure.mapper.out.MongoNourishmentMapper;
import me.kirenai.re.nourishment.infrastructure.repository.MongoNourishmentSortingRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class MongoNourishmentSortingRepositoryAdapter implements NourishmentSortingRepositoryPort {

    private final MongoNourishmentSortingRepository nourishmentSortingRepository;
    private final MongoNourishmentMapper mapper;

    @Override
    public Flux<Nourishment> findAll(Pageable pageable) {
        return this.nourishmentSortingRepository.findAllBy(pageable)
                .map(this.mapper::mapOutNourishmentEntityToNourishment);
    }

    @Override
    public Flux<Nourishment> findAllByIsAvailable(Boolean isAvailable, Pageable pageable) {
        return this.nourishmentSortingRepository.findAllByIsAvailable(isAvailable, pageable)
                .map(this.mapper::mapOutNourishmentEntityToNourishment);
    }

    @Override
    public Flux<Nourishment> findAllByUserId(String userId, Pageable pageable) {
        return this.nourishmentSortingRepository.findAllByUserId(userId, pageable)
                .map(this.mapper::mapOutNourishmentEntityToNourishment);
    }

}

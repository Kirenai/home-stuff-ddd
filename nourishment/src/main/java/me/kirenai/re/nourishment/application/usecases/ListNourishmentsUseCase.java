package me.kirenai.re.nourishment.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.nourishment.domain.model.Nourishment;
import me.kirenai.re.nourishment.domain.port.in.ListNourishmentsPort;
import me.kirenai.re.nourishment.domain.port.out.repository.NourishmentSortingRepositoryPort;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListNourishmentsUseCase implements ListNourishmentsPort {

    private final NourishmentSortingRepositoryPort nourishmentSortingRepositoryPort;

    @Override
    public Flux<Nourishment> getNourishments(Pageable pageable) {
        return this.nourishmentSortingRepositoryPort.findAll(pageable);
    }

    @Override
    public Flux<Nourishment> getNourishmentsByIsAvailable(Boolean isAvailable, Pageable pageable) {
        return this.nourishmentSortingRepositoryPort.findAllByIsAvailable(isAvailable, pageable);
    }

    @Override
    public Flux<Nourishment> getNourishmentsByUserId(Long userId, Pageable pageable) {
        return this.nourishmentSortingRepositoryPort.findAllByUserId(userId, pageable);
    }

}

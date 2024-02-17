package me.kirenai.re.nourishment.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.nourishment.domain.model.Nourishment;
import me.kirenai.re.nourishment.domain.port.in.ListNourishmentsPort;
import me.kirenai.re.nourishment.domain.port.out.NourishmentRepositoryPort;
import me.kirenai.re.nourishment.domain.port.out.NourishmentSortingRepositoryPort;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListNourishmentsUseCase implements ListNourishmentsPort {

    private final NourishmentRepositoryPort nourishmentRepositoryPort;
    private final NourishmentSortingRepositoryPort nourishmentSortingRepositoryPort;

    @Override
    public Flux<Nourishment> getNourishments(Pageable pageable) {
        return this.nourishmentSortingRepositoryPort.findAll(pageable);
    }

    @Override
    public Flux<Nourishment> getNourishmentsByIsAvailable(Boolean isAvailable) {
        return this.nourishmentRepositoryPort.findAllByIsAvailable(isAvailable);
    }

    @Override
    public Flux<Nourishment> getNourishmentsByUserId(Long userId) {
        return this.nourishmentRepositoryPort.findAllByUserId(userId);
    }

}

package me.kirenai.re.nourishment.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.nourishment.domain.model.NourishmentPrice;
import me.kirenai.re.nourishment.domain.port.in.ListNourishmentsPricePort;
import me.kirenai.re.nourishment.domain.port.out.repository.NourishmentPriceRepositoryPort;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListNourishmentsPriceUseCase implements ListNourishmentsPricePort {
    private final NourishmentPriceRepositoryPort nourishmentPriceRepositoryPort;

    @Override
    public Flux<NourishmentPrice> execute(String nourishmentId, Pageable pageable) {
        return this.nourishmentPriceRepositoryPort.findAll(nourishmentId, pageable);
    }
}

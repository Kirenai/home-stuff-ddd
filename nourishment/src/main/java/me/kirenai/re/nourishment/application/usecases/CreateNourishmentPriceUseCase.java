package me.kirenai.re.nourishment.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.nourishment.domain.model.NourishmentPrice;
import me.kirenai.re.nourishment.domain.port.in.CreateNourishmentPricePort;
import me.kirenai.re.nourishment.domain.port.out.repository.NourishmentPriceRepositoryPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateNourishmentPriceUseCase implements CreateNourishmentPricePort {
    private final NourishmentPriceRepositoryPort nourishmentPriceRepositoryPort;

    @Override
    public Mono<NourishmentPrice> execute(NourishmentPrice nourishmentPrice) {
        return this.nourishmentPriceRepositoryPort.create(nourishmentPrice);
    }
}

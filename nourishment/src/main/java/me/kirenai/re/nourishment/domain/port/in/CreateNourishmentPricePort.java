package me.kirenai.re.nourishment.domain.port.in;

import me.kirenai.re.nourishment.domain.model.NourishmentPrice;
import reactor.core.publisher.Mono;

public interface CreateNourishmentPricePort {
    Mono<NourishmentPrice> execute(NourishmentPrice nourishmentPrice);
}

package me.kirenai.re.nourishment.domain.port.in;

import me.kirenai.re.nourishment.domain.model.NourishmentPrice;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public interface ListNourishmentsPricePort {
    Flux<NourishmentPrice> execute(String nourishmentId, Pageable pageable);
}

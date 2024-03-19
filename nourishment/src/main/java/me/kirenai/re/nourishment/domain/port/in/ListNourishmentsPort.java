package me.kirenai.re.nourishment.domain.port.in;

import me.kirenai.re.nourishment.domain.model.Nourishment;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public interface ListNourishmentsPort {

    Flux<Nourishment> getNourishments(Pageable pageable);

    Flux<Nourishment> getNourishmentsByIsAvailable(Boolean isAvailable, Pageable pageable);

    Flux<Nourishment> getNourishmentsByUserId(Long userId, Pageable pageable);

}

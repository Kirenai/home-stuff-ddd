package me.kirenai.re.nourishment.domain.port.in;

import me.kirenai.re.nourishment.domain.model.Nourishment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ListNourishmentsPort {

    Mono<Page<Nourishment>> getNourishments(Pageable pageable);

    Flux<Nourishment> getNourishmentsByIsAvailable(Boolean isAvailable, Pageable pageable);

    Flux<Nourishment> getNourishmentsByUserId(String userId, Pageable pageable);

}

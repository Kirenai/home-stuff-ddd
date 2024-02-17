package me.kirenai.re.nourishment.domain.port.out;

import me.kirenai.re.nourishment.domain.model.Nourishment;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NourishmentSortingRepositoryPort {

    Flux<Nourishment> findAll(Pageable pageable);

}

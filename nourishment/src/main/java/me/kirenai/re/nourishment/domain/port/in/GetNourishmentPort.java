package me.kirenai.re.nourishment.domain.port.in;

import me.kirenai.re.nourishment.domain.model.Nourishment;
import reactor.core.publisher.Mono;

public interface GetNourishmentPort {

    Mono<Nourishment> findById(Long nourishmentId);

}

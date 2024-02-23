package me.kirenai.re.nourishment.domain.port.out.client;

import me.kirenai.re.nourishment.domain.model.dto.GetUserResponse;
import reactor.core.publisher.Mono;

public interface UserClientPort {

    Mono<GetUserResponse> getUserByUserId(Long userId);

}

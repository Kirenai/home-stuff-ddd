package me.kirenai.re.nourishment.domain.port.out.client;

import me.kirenai.re.nourishment.domain.model.dto.UserResponse;
import reactor.core.publisher.Mono;

public interface UserClientPort {

    Mono<UserResponse> getUserByUserId(Long userId);

}

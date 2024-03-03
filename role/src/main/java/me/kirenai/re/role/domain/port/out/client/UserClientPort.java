package me.kirenai.re.role.domain.port.out.client;

import me.kirenai.re.role.domain.model.dto.GetUserResponse;
import reactor.core.publisher.Mono;

public interface UserClientPort {

    Mono<GetUserResponse> getUserByUserId(Long userId);

}
